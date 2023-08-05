package com.example.Registration_form;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recover_Model {
	
	
	public Recover_Model() {
		super();
	}
	public Recover_Model( String username, String mail, String mobile, String city, String password) {
		super();
		
		this.Username = username;
		this.Mail = mail;
		this.Mobile = mobile;
		this.City = city;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int UserId;
	
	private String Username;
	private String Mail;
	private String Mobile;
	private String City;
	private String password;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
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
