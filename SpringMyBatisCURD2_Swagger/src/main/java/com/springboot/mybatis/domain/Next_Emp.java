package com.springboot.mybatis.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springboot.mybatis.utility.DateHandler;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(value=Include.NON_NULL)
public class Next_Emp {
	
	private int id;
	private String first_name;
	private String last_name;
	
	@JsonDeserialize(using =DateHandler.class)
	private Date birth_date;
	
	private String email;
	
	
	public Next_Emp() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Date getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}


	@Override
	public String toString() {
		return "Next_Emp [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ",birth_date="+birth_date+"]";
	}

	
	

}
