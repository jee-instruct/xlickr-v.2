package com.xlickr.beans;

import java.text.DateFormat;
import java.util.Date;

public class ImageComments {

	public ImageComments(long imageComentsId, long imageId, long userId,
			String username, String comments, Date commentedDate) {
		super();
		this.imageComentsId = imageComentsId;
		this.imageId = imageId;
		this.userId = userId;
		this.username = username;
		this.comments = comments;
		this.commentedDate = commentedDate;
	}
	
	private long imageComentsId;
	private long imageId;
	private long userId;
	private String username;
	private String comments;
	private Date commentedDate;
	
	public long getImageComentsId() {
		return imageComentsId;
	}
	public void setImageComentsId(long imageComentsId) {
		this.imageComentsId = imageComentsId;
	}
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCommentedDate() {
		return commentedDate;
	}
	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}
	
	public String getCreatedDataString(){
		return	DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT).format(getCommentedDate());
	}
	
	
}
