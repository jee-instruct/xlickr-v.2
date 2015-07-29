package com.xlickr.service;

import java.util.List;

import com.xlickr.beans.UserAlbums;
import com.xlickr.hibernate.entities.FlickrAlbum;

public interface AlbumService {
	
	public List<FlickrAlbum> getAlbumsByUserName(String username);
	public FlickrAlbum getFlickrAlbumById(Long albumId);
	public List<UserAlbums> getUserAlbums(String username);
	public UserAlbums getUserAlbumById(Long albumId);
	public void deleteAlbumByAlbumId(Long albumId);
	
	public void deleteImageByImageId(Long imageId);
}
