package com.xlickr.dao;

import java.util.List;

import com.xlickr.beans.UserAlbums;
import com.xlickr.hibernate.entities.FlickrAlbum;

public interface AlbumDao {

	public Long persistAlbum(FlickrAlbum album);
	public FlickrAlbum getAlbumById(Long albumId);
	public List<FlickrAlbum> getAlbumsByUserName(String username);
	public void deleteAlbumByAlbumId(Long albumId);
	
	
	
	/*
	 * 
	 * Native Queries
	 */
	
	public List<UserAlbums> getUserAlbumsByLoggedInUser(String username);
	
}
