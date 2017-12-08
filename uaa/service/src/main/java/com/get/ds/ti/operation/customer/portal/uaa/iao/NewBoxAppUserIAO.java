package com.get.ds.ti.operation.customer.portal.uaa.iao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxUser;
import com.box.sdk.CreateUserParams;
import com.get.ds.ti.operation.customer.portal.boxconnection.BoxSecureConnection;
import com.get.ds.ti.operation.customer.portal.model.UserDTO;


public class NewBoxAppUserIAO {

	//for testing purpose
    public static void main(String[] args) throws IOException {
        // Turn off logging to prevent polluting the output.
        Logger.getLogger("com.box.sdk").setLevel(Level.OFF);
        
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Bill");
        userDTO.setLastName("Moory");
        userDTO.setUserLoginID("bill.moory@cn.com");
        userDTO.setPassWord("cnisgreat");
        
        NewBoxAppUserIAO newBoxAppUserIAO = new NewBoxAppUserIAO();
        newBoxAppUserIAO.addNewAppUser(userDTO);    
    }
    
    //this is for users to signing up for the first time
    //A new app user will be added to Box.com
    public void addNewAppUser(UserDTO userDTO) {
    	BoxSecureConnection boxSecureConnection;
    	BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection;
    	
    	//box.com stores user name together
    	String userName = userDTO.getFirstName() + " " + userDTO.getLastName();
    	
    	try {
    		
    		boxSecureConnection = new BoxSecureConnection();
			
			boxDeveloperEditionAPIConnection = boxSecureConnection.getAppEnterpriseConnectionFromBox();
			
			CreateUserParams params = new CreateUserParams();
	        params.setSpaceAmount(573741824); //0.5 GB storage space for the user. can be changed later
	        
	        //These params can be used to store any id, like an email, of the user
	        //for which the associated app user is being created.
	        //email as the user login id is being setup here
	        params.setExternalAppUserId(userDTO.getUserLoginID()); 
	        //for the time being, store the password into the phone attribute.
	        params.setPhone(userDTO.getPassWord()); 
	        params.setAddress(userDTO.getUserLoginID());
	        
	        params.setIsPlatformAccessOnly(true);   
	        
	        BoxUser.Info user = BoxUser.createAppUser(boxDeveloperEditionAPIConnection, userName, params);
	        
	        System.out.format("User created with name %s and id %s\n\n", userName, user.getID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
