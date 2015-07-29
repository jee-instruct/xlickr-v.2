package com.xlickr.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.xlickr.dao.AlbumDao;
import com.xlickr.dao.ImageDao;
import com.xlickr.dao.UserDao;
import com.xlickr.hibernate.entities.FlickrImage;
import com.xlickr.hibernate.entities.FlickrImageData;
import com.xlickr.hibernate.entities.FlickrImageMetadata;
import com.xlickr.hibernate.entities.FlickrUser;
import com.xlickr.utils.ImageUtils;


@Scope("prototype")
@Component("filehandler")
public class FileHandler implements Runnable{
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AlbumDao albumDao;
	
	
	private FlickrImage image;
	

	public void  setImageInfo(String fileName, byte[] filedata,
			String contentType, Long fileSize,String username, Long albumId){
		this.image = new FlickrImage();
		FlickrUser user = userDao.getFlickerUsedByUserName(username);
		image.setFlickrUser(user);
		image.setImageContentType(contentType);
		image.setImageCreatedDate(new Date());
		image.setImageDescription("");
		image.setImageIsPrivate(albumDao.getAlbumById(albumId).isAlbumIsPrivate());
		image.setImageName(fileName);
		image.setImageSize(fileSize);
		image.setImageUpdatedDate(new Date());
		image.setAlbumId(albumId);
		
		FlickrImageData data = new FlickrImageData();
		data.setFlickrImage(image);
		data.setImageBytes(filedata);
		data.setImageDataCreatedDate(new Date());
		image.setFlickrImageData(data);
		Set<FlickrImageMetadata> flickrImageMetadata = new HashSet<FlickrImageMetadata>();
		Map<String,String> props = ImageUtils.getImageMetadata(filedata);
		if(!props.isEmpty()){
			for (Map.Entry<String, String> entry : props.entrySet()) {
			    FlickrImageMetadata metadata = new FlickrImageMetadata();
			    metadata.setFlickrImage(image);
			    metadata.setImageMetadataCreatedDate(new Date());
			    metadata.setPropertyName(entry.getKey());
			    metadata.setPropertyValue(entry.getValue());
			    flickrImageMetadata.add(metadata);
			}
			image.setFlickrImageMetadatas(flickrImageMetadata);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		imageDao.persistImage(image);
	}

}
