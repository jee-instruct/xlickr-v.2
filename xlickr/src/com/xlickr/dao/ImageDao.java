package com.xlickr.dao;

import java.util.List;
import java.util.Set;

import com.xlickr.hibernate.entities.FlickrImage;
import com.xlickr.hibernate.entities.FlickrImageComments;
import com.xlickr.hibernate.entities.FlickrImageMetadata;

public interface ImageDao {

	public void persistImage(FlickrImage image);
	
	public void saveOrUpdate(FlickrImage image);
	
	public Long getImagesCountInAlbumByAlbumId(Long albumId);
	
	public List<FlickrImage> getAlbumImages(Long albumId);
	
	public Set<FlickrImageComments> getImageComments(Long imageId);
	
	public FlickrImage getFlickrImageByImageId(Long imageId);
	
	public Set<FlickrImageMetadata> getImageMetaDataByIMageId(Long imageId);
	
	public void deleteImageByImageId(Long imageId);
}
