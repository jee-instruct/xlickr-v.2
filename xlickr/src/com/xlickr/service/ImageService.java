package com.xlickr.service;

import java.util.List;

import com.xlickr.beans.Image;
import com.xlickr.beans.ImageComments;
import com.xlickr.beans.MData;
import com.xlickr.hibernate.entities.FlickrImage;
import com.xlickr.hibernate.entities.FlickrImageData;

public interface ImageService {
	
	public List<Image> getImagesByAlbumId(Long albumId);
	
	public List<ImageComments> getImageCommentsByImageId(Long imageId);
	
	public List<MData> getIMageMetaDataByIMageId(Long imageId);
	
	public Image getImageByImageId(Long imageId);
	
	public FlickrImageData getImageDataByImageId(Long imageId);
	
	public FlickrImage getFlickrImageById(Long imageId);
	
	public void addComment(String comment, Long imageId, String username);
	
	
}
