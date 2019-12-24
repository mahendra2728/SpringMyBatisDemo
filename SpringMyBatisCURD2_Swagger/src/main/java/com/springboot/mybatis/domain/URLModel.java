package com.springboot.mybatis.domain;

public class URLModel {
	
	private String your_url;
	private String alias_name;
	public String getYour_url() {
		return your_url;
	}
	public void setYour_url(String your_url) {
		this.your_url = your_url;
	}
	public String getAlias_name() {
		return alias_name;
	}
	public void setAlias_name(String alias_name) {
		this.alias_name = alias_name;
	}
	public URLModel(String your_url, String alias_name) {
		super();
		this.your_url = your_url;
		this.alias_name = alias_name;
	}
	public URLModel() {
		super();
	}
	
	

}
