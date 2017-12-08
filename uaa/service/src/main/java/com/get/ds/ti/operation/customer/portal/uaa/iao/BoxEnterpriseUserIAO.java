package com.get.ds.ti.operation.customer.portal.uaa.iao;

import com.box.sdk.*;
import com.get.ds.ti.operation.customer.portal.boxconnection.BoxSecureConnection;
import com.get.ds.ti.operation.customer.portal.model.UserDTO;

public class  BoxEnterpriseUserIAO {
    
	//this is for quick test purpose
	public static void main( String[] args ) {
		
		BoxEnterpriseUserIAO boxEnterpriseUser = new BoxEnterpriseUserIAO();
		UserDTO userDTO = boxEnterpriseUser.getBoxManagedUser("sameer.p@123.com");
		
		//in the Customer Portal, the user login ID is the same as user's company email
		System.out.println("User login ID: " + userDTO.getUserLoginID());
		System.out.println("User Box ID: " + userDTO.getUserBoxID());
    }
	
	public UserDTO getBoxEnterpriseUser() {
		BoxSecureConnection boxSecureConnection;
    	BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection;
    	BoxUser serviceAccountUser;
    	BoxUser.Info serviceAccountUserInfo;
    	UserDTO userDTO = new UserDTO();
    	
    	try {
			boxSecureConnection = new BoxSecureConnection();
			
			boxDeveloperEditionAPIConnection = boxSecureConnection.getAppEnterpriseConnectionFromBox();
			
			serviceAccountUser = BoxUser.getCurrentUser(boxDeveloperEditionAPIConnection);
	        serviceAccountUserInfo = serviceAccountUser.getInfo();
	         
	        
	        userDTO.setUserLoginID(serviceAccountUserInfo.getAddress());
	        userDTO.setEMail(serviceAccountUserInfo.getLogin());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return userDTO;
	}
	
	//use userloginID, which is the user's email address to match the email in box.com
	//and get all other info for the user
	public UserDTO getBoxManagedUser(String userLoginID) {
		BoxSecureConnection boxSecureConnection;
    	BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection;
    	
    	UserDTO userDTO = new UserDTO();
    	
    	try {
			boxSecureConnection = new BoxSecureConnection();
			
			boxDeveloperEditionAPIConnection = boxSecureConnection.getAppEnterpriseConnectionFromBox();
			
			Iterable<com.box.sdk.BoxUser.Info> managedUsers = BoxUser.getAllEnterpriseUsers(boxDeveloperEditionAPIConnection);
	         
			 for (BoxUser.Info managedUser : managedUsers) {
	                if (managedUser.getAddress().equals(userLoginID)) {
	                	
	                	userDTO.setName(managedUser.getName());
	                	userDTO.setEMail(managedUser.getAddress());
	         	        userDTO.setUserLoginID(managedUser.getAddress());
	         	        userDTO.setUserBoxID(managedUser.getID());
	         	        userDTO.setPassWord(managedUser.getPhone());
	         	        userDTO.setAccessToken(this.getAppUser(managedUser.getID()).getAccessToken());
	         	        
	         	        break;
	                }
	            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return userDTO;
	}
	
	public UserDTO getAppUser(String userBoxID) {
		BoxSecureConnection boxSecureConnection;
    	BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection;
    	
    	UserDTO userDTO = new UserDTO();
    	
    	try {
			boxSecureConnection = new BoxSecureConnection();
			
			boxDeveloperEditionAPIConnection = boxSecureConnection.getAPPUserConnectionFromBox(userBoxID);
			
			userDTO.setAccessToken(boxDeveloperEditionAPIConnection.getAccessToken());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return userDTO;
	}
}
