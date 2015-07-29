package com.xlickr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlickr.beans.UserAlbums;
import com.xlickr.dao.AlbumDao;
import com.xlickr.dao.ImageDao;
import com.xlickr.hibernate.entities.FlickrAlbum;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumDao albumDao;
	
	@Autowired
	private ImageDao imageDao;
	private static final Logger logger = Logger.getLogger(AlbumServiceImpl.class);
	
	
	@Override
	public List<FlickrAlbum> getAlbumsByUserName(String username) {
		// TODO Auto-generated method stub
		System.out.println(" user getting albums");
		logger.warn("User getting all his albums.." );
		logger.info(" albums of the user ");
		return albumDao.getAlbumsByUserName(username);
	}

	@Override
	public FlickrAlbum getFlickrAlbumById(Long albumId) {
		// TODO Auto-generated method stub
		return albumDao.getAlbumById(albumId);
	}

	@Override
	public List<UserAlbums> getUserAlbums(String username) {
		// TODO Auto-generated method stub
//		List<UserAlbums> albums = new ArrayList<UserAlbums>();
//		for(FlickrAlbum a:getAlbumsByUserName(username)){
//			Long imageId= 0L;
//			List<FlickrImage> images = imageDao.getAlbumImages(a.getAlbumId());
//			if(CollectionUtils.isNotEmpty(images)){
//				imageId = images.get(0).getImageId();
//			}
//			UserAlbums alb = new UserAlbums(a.getAlbumId(), a.getAlbumName(), a.getAlbumDescription(), a.isAlbumIsPrivate(), a.getAlbumCreatedDate(), a.getAlbumCreatedBy(), imageDao.getImagesCountInAlbumByAlbumId(a.getAlbumId()),imageId);
//			albums.add(alb);
//		}
		
		System.out.println(" user getting albums");
		logger.warn("User getting all his albums.." );
		logger.info(" albums of the user ");
		
		
		return albumDao.getUserAlbumsByLoggedInUser(username);
	}

	@Override
	public UserAlbums getUserAlbumById(Long albumId) {
		// TODO Auto-generated method stub
		FlickrAlbum a =  getFlickrAlbumById(albumId);
		Long imageId= 0L;
		return new UserAlbums(a.getAlbumId(), a.getAlbumName(), a.getAlbumDescription(), a.isAlbumIsPrivate(), a.getAlbumCreatedDate(), a.getAlbumCreatedBy(), imageDao.getImagesCountInAlbumByAlbumId(a.getAlbumId()),imageId);
	}

	@Override
	public void deleteAlbumByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		albumDao.deleteAlbumByAlbumId(albumId);
	}

	@Override
	public void deleteImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		imageDao.deleteImageByImageId(imageId);
	}

	
	
	
	
}
