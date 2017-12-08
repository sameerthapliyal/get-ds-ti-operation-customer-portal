package com.get.ds.ti.operation.customer.portal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class UserDTO {

	  private String firstName;
	  private String lastName;
	  private String name;
	  private String userLoginID;
	  private String passWord;
	  private String eMail;
	  private String userBoxID;
	  private String company;
	  private String accessToken;

	  public UserDTO(
	      String firstName, String lastName, String name, String eMail, String company, String userLoginID, String passWord, String 
	      userBoxID, String accessToken) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.name = name;
	    
	    //userLoginID is same as user email
	    this.userLoginID = userLoginID;
	    this.passWord = passWord;
	    this.eMail = eMail;
	    this.userBoxID = userBoxID;
	    this.company = company;
	    this.accessToken = accessToken;
	  }

	  public UserDTO() {}

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  public String getCompany() {
	    return company;
	  }

	  public void setCompany(String company) {
	    this.company = company;
	  }

	  public String getUserLoginID() {
	    return userLoginID;
	  }

	  public void setUserLoginID(String userLoginID) {
	    this.userLoginID = userLoginID;
	  }

	  public String getEMail() {
		  return eMail;
	  }
		
	  public void setEMail(String eMail) {
		  this.eMail = eMail;
	  }

	  public String getPassWord() {
		  return passWord;
	  }

	  public void setPassWord(String passWord) {
		  this.passWord = passWord;
	  }
	  
		  public String getName() {
			  return name;
		  }
		
		  public void setName(String name) {
			  this.name = name;
		  }

		public String getUserBoxID() {
			return userBoxID;
		}
		
		public void setUserBoxID(String userBoxID) {
			this.userBoxID = userBoxID;
		}
		
		public String getAccessToken() {
			return accessToken;
		}
		
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
	}
