package com.xlickr.beans;

import java.io.Serializable;

public class LoggedInUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2554882400266455626L;
	private String email;
	private String firstname;
	private String lastname;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public LoggedInUser(String email, String firstname, String lastname) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	
}
