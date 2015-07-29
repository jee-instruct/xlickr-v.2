package com.xlickr.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xlickr.hibernate.entities.FlickrUser;
import com.xlickr.hibernate.entities.FlickrUserProfile;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistNewUser(FlickrUser user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public FlickrUser getFlickerUsedByUserName(String username) {
		// TODO Auto-generated method stub
		return (FlickrUser) sessionFactory.getCurrentSession().getNamedQuery("getFlickerUserByUserName").setCacheable(true).setParameter("username", username).list().get(0);
	}

	@Override
	public FlickrUser saveOrUpdate(FlickrUser user) {
		// TODO Auto-generated method stub
		return (FlickrUser) sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public FlickrUserProfile getFlickerUserProfileByUserName(String userName) {
		// TODO Auto-generated method stub
		return getFlickerUsedByUserName(userName).getFlickrUserProfiles();
	}

	@Override
	public FlickrUser getFlickrUserById(Long userId) {
		// TODO Auto-generated method stub
		return (FlickrUser) sessionFactory.getCurrentSession().load(FlickrUser.class, userId);
	}

}
