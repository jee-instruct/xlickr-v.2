package com.xlickr.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xlickr.beans.UserAlbums;
import com.xlickr.hibernate.entities.FlickrAlbum;
@Repository
@Transactional
public class AlbumDaoImpl implements AlbumDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long persistAlbum(FlickrAlbum album) {
		// TODO Auto-generated method stub
		FlickrAlbum a = (FlickrAlbum) sessionFactory.getCurrentSession().merge(album);
		return a.getAlbumId();
	}

	@Override
	public FlickrAlbum getAlbumById(Long albumId) {
		// TODO Auto-generated method stub
		return (FlickrAlbum) sessionFactory.getCurrentSession().get(FlickrAlbum.class, albumId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlickrAlbum> getAlbumsByUserName(String username) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery("getFlickerAlbumByUserName").setParameter("username", username).setCacheable(true).list();
	}

	@Override
	public void deleteAlbumByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getAlbumById(albumId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbums> getUserAlbumsByLoggedInUser(String username) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT album_id as \"albumId\", album_name as \"albumName\" , album_description as \"albumDescription\", album_is_private as \"albumIsPrivate\", "+
       "album_created_date as \"albumCreatedDate\", album_created_by as \"albumCreatedBy\", (select count(*) from flickr_image where album_id = fb.album_id) as \"imageCount\","+ 
      " ( select image_id from flickr_image where album_id = fb.album_id order by Random() limit 1 ) as \"randomImageId\" FROM flickr_album fb WHERE UPPER(album_created_by) = UPPER(:username)";
		
		
	return 	sessionFactory.getCurrentSession().createSQLQuery(sql).
			setParameter("username", username)
			.setResultTransformer(Transformers.aliasToBean(UserAlbums.class)).list();
	}
	
	
	

}
