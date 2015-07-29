package com.xlickr.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlickr.beans.LoggedInUser;
import com.xlickr.beans.User;
import com.xlickr.dao.AlbumDao;
import com.xlickr.dao.UserDao;
import com.xlickr.hibernate.entities.FlickrAlbum;
import com.xlickr.hibernate.entities.FlickrUser;
import com.xlickr.hibernate.entities.FlickrUserProfile;
import com.xlickr.hibernate.entities.FlickrUserRole;
import com.xlickr.utils.SecurityUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public void saveNewUser(User user) {
		// TODO Auto-generated method stub

		FlickrUser fUser = new FlickrUser();
		fUser.setEnabled(Boolean.TRUE);
		fUser.setUserCreatedDate(new Date());
		fUser.setUserUsername(user.getUsername());
		fUser.setUserUpdatedDate(new Date());
		fUser.setUserPassword(SecurityUtils.encryptPassword(user.getPassword()));
		
		FlickrUserRole role = new FlickrUserRole();
		role.setFlickrUser(fUser);
		role.setUserRoleCreatedDate(new Date());
		role.setUserRoleRole("ROLE_USER");
		role.setUserRoleUpdatedDate(new Date());
		role.setUserRoleUsername(user.getUsername());
		fUser.setFlickrUserRoles(role);
		
		FlickrUserProfile profile = new FlickrUserProfile();
		profile.setFlickrUser(fUser);
		profile.setUserProfileCreatedDate(new Date());
		profile.setUserProfileEmail(user.getEmail());
		profile.setUserProfileFirstName(user.getFirstname());
		try{
		profile.setUserProfilePicture(user.getPicture().getBytes());
		profile.setProfileImageType(user.getPicture().getContentType());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		profile.setUserProfileLastName(user.getLastname());
		profile.setUserProfilePhoneNumber(user.getPhonenumber());
		profile.setUserProfileUpdatedDate(new Date());
		fUser.setFlickrUserProfiles(profile);
		userDao.persistNewUser(fUser);
	}

	@Override
	public FlickrUser getFlickrUser(String username) {
		// TODO Auto-generated method stub
		return userDao.getFlickerUsedByUserName(username);
	}

	@Override
	public Long saveNewUserAlbums(String username, String albumName,
			String albumDescription, Boolean isprivate) {
		FlickrAlbum album = new FlickrAlbum();
		album.setFlickrUser(getFlickrUser(username));
		album.setAlbumCreatedBy(username);
		album.setAlbumCreatedDate(new Date());
		album.setAlbumDescription(albumDescription);
		album.setAlbumIsPrivate(isprivate);
		album.setAlbumName(albumName);
		album.setAlbumUpdatedBy(username);
		album.setAlbumUpdatedDate(new Date());
		return albumDao.persistAlbum(album);
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlickrUserProfile getUserProfile(String username) {
		// TODO Auto-generated method stub
		return userDao.getFlickerUserProfileByUserName(username);
	}

	@Override
	public LoggedInUser getLoggedInUserDetailsByUserName(String username) {
		// TODO Auto-generated method stub
		FlickrUserProfile profile = getUserProfile(username);
		return new LoggedInUser(profile.getUserProfileEmail(), profile.getUserProfileFirstName(), profile.getUserProfileLastName());
	}

	@Override
	public FlickrUser getFlickrUserById(Long userId) {
		// TODO Auto-generated method stub
		return userDao.getFlickrUserById(userId);
	}

}
