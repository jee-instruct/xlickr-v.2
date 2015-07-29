package com.xlickr.service;

import com.xlickr.beans.LoggedInUser;
import com.xlickr.beans.User;
import com.xlickr.hibernate.entities.FlickrUser;
import com.xlickr.hibernate.entities.FlickrUserProfile;

public interface UserService {
	public void saveNewUser(User user);
	public FlickrUser getFlickrUser(String username);
	public Long saveNewUserAlbums(String userName, String albumName, String albumDescription, Boolean isprivate);
	public FlickrUserProfile getUserProfile(String username);
	public LoggedInUser getLoggedInUserDetailsByUserName(String username);
	public FlickrUser getFlickrUserById(Long userId);
}
