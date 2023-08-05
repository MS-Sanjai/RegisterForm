package com.example.Registration_form;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register_Model {
	
	
	
	public Register_Model() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int UserId;
	
	private String username;
	private String Mail;
	private String Mobile;
	private String City;
	private String password;
	public Register_Model(int userId, String username, String mail, String mobile, String city, String password) {
		super();
		UserId = userId;
		this.username = username;
		Mail = mail;
		Mobile = mobile;
		City = city;
		this.password = password;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
