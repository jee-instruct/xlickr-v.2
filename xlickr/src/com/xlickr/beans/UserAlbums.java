package com.xlickr.beans;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Date;

public class UserAlbums {
	private Long albumId;
	private String albumName;
	private String albumDescription;
	private boolean albumIsPrivate;
	private Date albumCreatedDate;
	private String albumCreatedBy;
	private Long imageCount;
	private Long randomImageId;
	
	public Long getAlbumId() {
		return albumId;
	}
//	public void setAlbumId(Long albumId) {
//		this.albumId = albumId;
//	}
	
	public void setAlbumId(BigInteger albumId) {
		this.albumId = albumId.longValue();
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getAlbumDescription() {
		return albumDescription;
	}
	public void setAlbumDescription(String albumDescription) {
		this.albumDescription = albumDescription;
	}
	public boolean isAlbumIsPrivate() {
		return albumIsPrivate;
	}
	public void setAlbumIsPrivate(boolean albumIsPrivate) {
		this.albumIsPrivate = albumIsPrivate;
	}
	public Date getAlbumCreatedDate() {
		return albumCreatedDate;
	}
	
	public String getCreatedDataString(){
		return	DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT).format(getAlbumCreatedDate());
	}
	
	
	public String getAlbumPrivateString(){
		if(isAlbumIsPrivate()){
			return "private";
		}
		return "public";
	}
	
	public void setAlbumCreatedDate(Date albumCreatedDate) {
		this.albumCreatedDate = albumCreatedDate;
	}
	public String getAlbumCreatedBy() {
		return albumCreatedBy;
	}
	public void setAlbumCreatedBy(String albumCreatedBy) {
		this.albumCreatedBy = albumCreatedBy;
	}
	public Long getImageCount() {
		return imageCount;
	}
//	public void setImageCount(Long imageCount) {
//		this.imageCount = imageCount;
//	}
	
	
	public void setImageCount(BigInteger imageCount) {
		this.imageCount = imageCount.longValue();
	}
	
	public UserAlbums(Long albumId, String albumName, String albumDescription,
			boolean albumIsPrivate, Date albumCreatedDate,
			String albumCreatedBy, Long imageCount,Long randomImageId) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.albumDescription = albumDescription;
		this.albumIsPrivate = albumIsPrivate;
		this.albumCreatedDate = albumCreatedDate;
		this.albumCreatedBy = albumCreatedBy;
		this.imageCount = imageCount;
		this.randomImageId=randomImageId;
	}
	
	
	public UserAlbums() {
		super();
	}
	
	
	public Long getRandomImageId() {
		return randomImageId;
	}
	
//	public void setRandomImageId(Long randomImageId) {
//		this.randomImageId = randomImageId;
//	}	
	
	public void setRandomImageId(BigInteger randomImageId) {
		if(null!=randomImageId)
		this.randomImageId = randomImageId.longValue();
	}
	
	
}
