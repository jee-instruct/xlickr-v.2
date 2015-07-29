package com.xlickr.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xlickr.beans.Image;
import com.xlickr.beans.ImageComments;
import com.xlickr.beans.LoggedInUser;
import com.xlickr.beans.MData;
import com.xlickr.beans.UserAlbums;
import com.xlickr.service.AlbumService;
import com.xlickr.service.ImageService;
import com.xlickr.service.UserService;

@RestController
@RequestMapping("/service")
public class RestServiceController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ImageService imageService;
	

	
	@RequestMapping(value="/user/details",method=RequestMethod.GET)
	public LoggedInUser getLoggedInUserdetails(Principal principal){
		return userService.getLoggedInUserDetailsByUserName(principal.getName());
	}
	
	@RequestMapping(value="/user/albums",method=RequestMethod.GET)
	public List<UserAlbums> getAlbumsForLoggedInUser(Principal principal){
		return albumService.getUserAlbums(principal.getName());
	}
	
	@RequestMapping(value="/user/album/{albumId}",method=RequestMethod.GET)
	public UserAlbums getAlbumInfoByAlbumID(Principal principal,@PathVariable("albumId") Long albumId){
		return albumService.getUserAlbumById(albumId);
	}
	
	@RequestMapping(value="/album/images/{albumId}",method=RequestMethod.GET)
	public List<Image> getImagesByAlbumId(Principal principal,@PathVariable("albumId") Long albumId){
		return imageService.getImagesByAlbumId(albumId);
	}
	
	@RequestMapping(value="/comments/image/{imageId}",method=RequestMethod.GET)
	public List<ImageComments>  getImageCommentsByImageId(Principal principal,@PathVariable("imageId") Long imageId){
		return imageService.getImageCommentsByImageId(imageId);
	}
	
	@RequestMapping(value="/image/{imageId}",method=RequestMethod.GET)
	public Image getImageByImageId(Principal principal,@PathVariable("imageId") Long imageId){
		return imageService.getImageByImageId(imageId);
	}
	
	@RequestMapping(value="/image/metadata/{imageId}",method=RequestMethod.GET)
	public List<MData> getIMageMetadataByIMageId(Principal principal,@PathVariable("imageId") Long imageId){
		return imageService.getIMageMetaDataByIMageId(imageId);
	}
	
	@RequestMapping(value="/image/comment/{imageId}",method=RequestMethod.POST)
	public void addCommentForImage(@RequestParam("comment")String comment,@RequestParam("imageId")Long imageId,Principal principal ){
		
		imageService.addComment(comment, imageId, principal.getName());
		
	}
	
	
	
	
}
