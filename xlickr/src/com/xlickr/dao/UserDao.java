package com.xlickr.dao;

import com.xlickr.hibernate.entities.FlickrUser;
import com.xlickr.hibernate.entities.FlickrUserProfile;

public interface UserDao {
	
	public void persistNewUser(FlickrUser user);
	
	public FlickrUser saveOrUpdate(FlickrUser user);
	public FlickrUser getFlickerUsedByUserName(String username);
	public FlickrUserProfile getFlickerUserProfileByUserName(String userName);
	public FlickrUser getFlickrUserById(Long userId);
	
	
}
