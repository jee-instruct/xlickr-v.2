package com.xlickr.controllers;

import java.security.Principal;
import java.text.DateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xlickr.beans.User;
import com.xlickr.hibernate.entities.FlickrAlbum;
import com.xlickr.service.AlbumService;
import com.xlickr.service.UserService;

@Controller
public class WebController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AlbumService albumService;
	
	private static final Logger logger = Logger.getLogger(WebController.class);
	

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getLandingPage(){
		
		System.out.println("Hitting");
		
		
		logger.info("Hitting");
		
		logger.warn(" i am warining");
		
		
		try{
			Thread.sleep(5000);
		}catch(Exception ex){
			logger.error(" execption in blah   ", ex);
		}
		
		
		
		return new ModelAndView("landingPage");
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView getsignupPage(){
		
		System.out.println("Hitting");
		
		logger.info("Hitting");
		
		return new ModelAndView("signupPage").addObject("user", new User());
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView postSignupPage(@ModelAttribute("user")User user){
		userService.saveNewUser(user);
		return new ModelAndView("landingPage");
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public ModelAndView getsigninPage(){
		return new ModelAndView("signinPage");
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView getcreatePage(Principal principal){
		return new ModelAndView("createPage");
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView postcreatePage(Principal principal,@RequestParam("albumName")String albumName,
			@RequestParam("albumDesc")String albumDesc ,@RequestParam(value="isPrivate",required=false)Boolean isPrivate){
		if(null == isPrivate){
			isPrivate = Boolean.FALSE;
		}
		
		return new ModelAndView("redirect:/album/addImages/"+userService.saveNewUserAlbums(principal.getName(), albumName, albumDesc, isPrivate));
	}
	
	@RequestMapping(value="/album/addImages/{albumId}",method=RequestMethod.GET)
	public ModelAndView addImagesPage(Principal principal,@PathVariable("albumId") Long albumId){
		FlickrAlbum album = albumService.getFlickrAlbumById(albumId);
		return new ModelAndView("addImages")
				.addObject("albumname", album.getAlbumName())
				.addObject("albumId",albumId )
				.addObject("createdBy",album.getAlbumCreatedBy() )
				.addObject("totalimages",100L)
				.addObject("albumdesc",album.getAlbumDescription())
				.addObject("createdDate",DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT).format(album.getAlbumCreatedDate()))
				.addObject("rating",0L );
	}
	
	//return new ModelAndView("redirect:/login");
	
	@RequestMapping(value="/albums",method=RequestMethod.GET)
	public ModelAndView getMyAlbumsPage(Principal principal){
		return new ModelAndView("albumsPage");
	}
	
	@RequestMapping(value="/album/{albumId}",method=RequestMethod.GET)
	public ModelAndView getMyAlbumPage(Principal principal,@PathVariable("albumId") Long albumId){
		return new ModelAndView("albumPage").addObject("albumId", albumId);
	}
	
	@RequestMapping(value="/image/{imageId}",method=RequestMethod.GET)
	public ModelAndView getImagePage(Principal principal,@PathVariable("imageId") Long imageId){
		return new ModelAndView("imagePage").addObject("imageId", imageId);
	}
	
	@RequestMapping(value="/delete/album/{albumId}",method=RequestMethod.GET)
	public ModelAndView deleteAlbum(Principal principal,@PathVariable("albumId") Long albumId){
		albumService.deleteAlbumByAlbumId(albumId);
		return new ModelAndView("redirect:/albums");
	}
	
	@RequestMapping(value="/delete/image/{albumId}/{imageId}",method=RequestMethod.GET)
	public ModelAndView deleteImage(Principal principal,@PathVariable("imageId") Long imageId,@PathVariable("albumId") Long albumId){
		albumService.deleteImageByImageId(imageId);
		return new ModelAndView("redirect:/album/"+albumId);
	}
	
	
	
	
}
