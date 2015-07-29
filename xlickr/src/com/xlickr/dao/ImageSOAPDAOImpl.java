package com.xlickr.dao;

import java.util.List;

import javax.xml.ws.WebServiceRef;

import org.springframework.stereotype.Repository;

import com.vamsee.flickr.ejb.FlickerImageEJBBeanService;
import com.vamsee.flickr.ejb.FlickerImageEJBBeanService_Service;
import com.vamsee.flickr.ejb.FlickrImage;

@Repository
public class ImageSOAPDAOImpl implements ImageSOAPDAO {
	
	  private FlickerImageEJBBeanService_Service  service = new FlickerImageEJBBeanService_Service();
	  FlickerImageEJBBeanService serviceImpl = service.getFlickerImageEJBBeanServiceSoap12HttpPort();
	
	

	@Override
	public List<com.vamsee.flickr.ejb.FlickrImage> getFlickrImages() {
		// TODO Auto-generated method stub
		return serviceImpl.getFlickrImageFindAll();
	}
	
	
	
	public static void main(String... args){
		ImageSOAPDAOImpl impl = new ImageSOAPDAOImpl();
		
		for(FlickrImage image: impl.getFlickrImages()){
			System.out.println(image.getImageName());
		}
		
	}

}
