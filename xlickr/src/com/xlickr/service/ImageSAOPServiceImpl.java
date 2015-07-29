package com.xlickr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamsee.flickr.ejb.FlickrImage;
import com.xlickr.dao.ImageSOAPDAO;

@Service
public class ImageSAOPServiceImpl implements ImageSAOPService {
	
	@Autowired
	private ImageSOAPDAO imageSOAPDAO;
	

	@Override
	public List<FlickrImage> getFlickrImages() {
		// TODO Auto-generated method stub
		return imageSOAPDAO.getFlickrImages();
	}

}
