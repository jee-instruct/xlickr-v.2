package com.xlickr.beans;

public class MData {
	private Long id;
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public MData(Long id, String key, String value) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
	}
	
	
	
	

}
