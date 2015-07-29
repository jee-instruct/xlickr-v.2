package com.xlickr.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xlickr.hibernate.entities.FlickrImage;
import com.xlickr.hibernate.entities.FlickrImageComments;
import com.xlickr.hibernate.entities.FlickrImageMetadata;
@Repository
@Transactional
public class ImageDaoImpl implements ImageDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistImage(FlickrImage image) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(image);
	}

	@Override
	public Long getImagesCountInAlbumByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from FlickrImage where albumId = :albumId").setParameter("albumId", albumId).uniqueResult();
		//return new Long(sessionFactory.getCurrentSession().getNamedQuery("getImagesInAlbumByAlbumId").setParameter("albumId", albumId).list().size());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlickrImage> getAlbumImages(Long albumId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery("getImagesInAlbumByAlbumId").setParameter("albumId", albumId).list();
	}

	@Override
	public Set<FlickrImageComments> getImageComments(Long imageId) {
		// TODO Auto-generated method stub
		FlickrImage image =  (FlickrImage) sessionFactory.getCurrentSession().load(FlickrImage.class, imageId);
		return image.getFlickrImageCommentses();
	}

	@Override
	public FlickrImage getFlickrImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		return (FlickrImage) sessionFactory.getCurrentSession().load(FlickrImage.class, imageId);
	}

	@Override
	public Set<FlickrImageMetadata> getImageMetaDataByIMageId(Long imageId) {
		// TODO Auto-generated method stub
		return getFlickrImageByImageId(imageId).getFlickrImageMetadatas();
	}

	@Override
	public void saveOrUpdate(FlickrImage image) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(image);
	}

	@Override
	public void deleteImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getFlickrImageByImageId(imageId));
	}

}
