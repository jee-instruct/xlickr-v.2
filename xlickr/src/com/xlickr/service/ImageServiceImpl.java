package com.xlickr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlickr.beans.Image;
import com.xlickr.beans.ImageComments;
import com.xlickr.beans.MData;
import com.xlickr.dao.AlbumDao;
import com.xlickr.dao.ImageDao;
import com.xlickr.dao.UserDao;
import com.xlickr.hibernate.entities.FlickrAlbum;
import com.xlickr.hibernate.entities.FlickrImage;
import com.xlickr.hibernate.entities.FlickrImageComments;
import com.xlickr.hibernate.entities.FlickrImageData;
import com.xlickr.hibernate.entities.FlickrImageMetadata;
@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private AlbumDao albumDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Image> getImagesByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		List<Image> images = new ArrayList<Image>();
		for(FlickrImage im: imageDao.getAlbumImages(albumId)){
			Image i = new Image(im.getImageId(), im.getAlbumId(), im.getImageName(), im.getImageDescription(), im.getImageContentType(), im.getImageSize(), im.isImageIsPrivate(), im.getImageCreatedDate(), null, null, 0L/*new Long(im.getFlickrImageCommentses().size())*/,im.getFlickrUser().getUserUsername());
			images.add(i);
		}
		return images;
	}

	@Override
	public List<ImageComments> getImageCommentsByImageId(Long imageId) {
		// TODO Auto-generated method stub
		List<ImageComments> comments = new ArrayList<ImageComments>();
		FlickrImage image = imageDao.getFlickrImageByImageId(imageId);
		if(CollectionUtils.isNotEmpty(image.getFlickrImageCommentses())){
		for(FlickrImageComments c:image.getFlickrImageCommentses()){
			ImageComments comment = new ImageComments(c.getImageComentsId(), imageId, c.getFlickrUser().getUserId(), c.getFlickrUser().getUserUsername(), c.getImageComments(), c.getImageCommentsCreatedDate());
			comments.add(comment);
		}
		}
		return comments;
	}

	@Override
	public Image getImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		String albumName = "";
		String albumDescription = "";
		FlickrImage image = imageDao.getFlickrImageByImageId(imageId);
		if(0!= image.getAlbumId()){
			FlickrAlbum album = albumDao.getAlbumById(image.getAlbumId());
			albumName = album.getAlbumName();
			albumDescription = album.getAlbumDescription();
		}
		return new Image(image.getImageId(), image.getAlbumId(), image.getImageName(), image.getImageDescription(), image.getImageContentType(), image.getImageSize(), image.isImageIsPrivate(), image.getImageCreatedDate(), albumName, albumDescription,new Long(image.getFlickrImageCommentses().size()),image.getFlickrUser().getUserUsername());
	}

	@Override
	public List<MData> getIMageMetaDataByIMageId(Long imageId) {
		// TODO Auto-generated method stub
		List<MData> md = new ArrayList<MData>();
		for(FlickrImageMetadata data: imageDao.getImageMetaDataByIMageId(imageId)){
			MData meta = new MData(data.getImageMetadataId(), data.getPropertyName(), data.getPropertyValue());
			md.add(meta);
		}
		return md;
	}

	@Override
	public FlickrImageData getImageDataByImageId(Long imageId) {
		// TODO Auto-generated method stub
		FlickrImage image = imageDao.getFlickrImageByImageId(imageId);
		return image.getFlickrImageData();
	}

	@Override
	public FlickrImage getFlickrImageById(Long imageId) {
		// TODO Auto-generated method stub
		return imageDao.getFlickrImageByImageId(imageId);
	}

	@Override
	public void addComment(String comment, Long imageId, String username) {
		// TODO Auto-generated method stub
		FlickrImage image = imageDao.getFlickrImageByImageId(imageId);
		FlickrImageComments comments = new FlickrImageComments();
		comments.setFlickrImage(image);
		comments.setFlickrUser(userDao.getFlickerUsedByUserName(username));
		comments.setImageComments(comment);
		comments.setImageCommentsCreatedDate(new Date());
		image.getFlickrImageCommentses().add(comments);
		imageDao.saveOrUpdate(image);
	}
	
	

}
