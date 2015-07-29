package com.xlickr.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.xlickr.hibernate.entities.FlickrImage;
import com.xlickr.hibernate.entities.FlickrUserProfile;
import com.xlickr.service.ImageService;
import com.xlickr.service.UserService;



@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@RequestMapping(value="/multifileupload",method=RequestMethod.POST)
	public void multiuploadFilePage(Principal principal, @RequestParam("file") MultipartFile file,HttpServletResponse response,@RequestParam("albumId")Long albumId ){
		try {
			FileHandler fh = (FileHandler) applicationContext.getBean("filehandler");
			fh.setImageInfo(file.getOriginalFilename(), file.getBytes(), file.getContentType(), file.getSize(),principal.getName(),albumId);
			taskExecutor.execute(fh);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	@RequestMapping(value="/profile/image")
	public void displayProfileImage(Principal principal, HttpServletResponse response){
		if(null!= principal){
		FlickrUserProfile profile = userService.getUserProfile(principal.getName());
		response.setContentType(profile.getProfileImageType());
		try {
			response.getOutputStream().write(profile.getUserProfilePicture());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  }
	}
	
	@RequestMapping(value="/user/profile/image/{userId}")
	public void displayUserProfileImage(Principal principal, HttpServletResponse response,@PathVariable("userId") Long userId){
		FlickrUserProfile profile = userService.getFlickrUserById(userId).getFlickrUserProfiles();
		response.setContentType(profile.getProfileImageType());
		try {
			response.getOutputStream().write(profile.getUserProfilePicture());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
	}
	
	@RequestMapping(value="/stream/image/{imageId}")
	public void displayProfileImage(Principal principal, HttpServletResponse response,@PathVariable("imageId") Long imageId){
		FlickrImage data = imageService.getFlickrImageById(imageId);
		response.setContentType(data.getImageContentType());
		response.setContentLengthLong(data.getImageSize());
		try {
			response.getOutputStream().write(data.getFlickrImageData().getImageBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="/download/image/{imageId}")
	public void downloadImage(Principal principal, HttpServletResponse response,@PathVariable("imageId") Long imageId){
		FlickrImage data = imageService.getFlickrImageById(imageId);
		response.setContentType(data.getImageContentType());
		response.setContentLengthLong(data.getImageSize());
		response.setHeader("Content-Disposition","attachment; filename="+data.getImageName());
		try {
			response.getOutputStream().write(data.getFlickrImageData().getImageBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
