package com.xlickr.beans;

import java.text.DateFormat;
import java.util.Date;

public class Image {

	private long imageId;
	private long albumId;
	private String imageName;
	private String imageDescription;
	private String imageContentType;
	private long imageSize;
	private boolean imageIsPrivate;
	private Date imageCreatedDate;
	private String imageUploadedBy;
	private String albumName;
	private String albumDescription;
	private Long imageComments;

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public long getImageSize() {
		return imageSize;
	}

	public void setImageSize(long imageSize) {
		this.imageSize = imageSize;
	}

	public boolean isImageIsPrivate() {
		return imageIsPrivate;
	}

	public void setImageIsPrivate(boolean imageIsPrivate) {
		this.imageIsPrivate = imageIsPrivate;
	}

	public Date getImageCreatedDate() {
		return imageCreatedDate;
	}

	public String getCreatedDataString(){
		return	DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT).format(getImageCreatedDate());
	}
	
	public String getImagePrivateString(){
		if(isImageIsPrivate()){
			return "private";
		}
		return "public";
	}
	
	public void setImageCreatedDate(Date imageCreatedDate) {
		this.imageCreatedDate = imageCreatedDate;
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

	public Long getImageComments() {
		return imageComments;
	}

	public void setImageComments(Long imageComments) {
		this.imageComments = imageComments;
	}

	public Image(long imageId, long albumId, String imageName,
			String imageDescription, String imageContentType, long imageSize,
			boolean imageIsPrivate, Date imageCreatedDate, String albumName,
			String albumDescription, Long imageComments,String imageUploadedBy) {
		super();
		this.imageId = imageId;
		this.albumId = albumId;
		this.imageName = imageName;
		this.imageDescription = imageDescription;
		this.imageContentType = imageContentType;
		this.imageSize = imageSize;
		this.imageIsPrivate = imageIsPrivate;
		this.imageCreatedDate = imageCreatedDate;
		this.albumName = albumName;
		this.albumDescription = albumDescription;
		this.imageComments = imageComments;
		this.imageUploadedBy = imageUploadedBy;
	}

	public String getImageUploadedBy() {
		return imageUploadedBy;
	}

	public void setImageUploadedBy(String imageUploadedBy) {
		this.imageUploadedBy = imageUploadedBy;
	}
	
	
	
	
	
}
