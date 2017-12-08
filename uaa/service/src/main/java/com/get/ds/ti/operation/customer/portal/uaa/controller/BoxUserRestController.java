package com.get.ds.ti.operation.customer.portal.uaa.controller;

import com.get.ds.ti.operation.customer.portal.model.UserDTO;
import com.get.ds.ti.operation.customer.portal.uaa.iao.BoxEnterpriseUserIAO;
import com.get.ds.ti.operation.customer.portal.uaa.iao.NewBoxAppUserIAO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoxUserRestController {

 // @Autowired private BoxAppUserIAO boxAppUserService;

  @RequestMapping(value = "/addNewAppUser", method = RequestMethod.POST)
  public ResponseEntity<String> addNewAppUser(@RequestBody UserDTO appUser) {
	
	/**
	System.out.println(appUser.getFirstName());
	System.out.println(appUser.getLastName());
	System.out.println(appUser.getUserLoginID());
	System.out.println(appUser.getPassWord());
	System.out.println(appUser.getCompany());
	*/
	  
	UserDTO userDTO = new UserDTO();
	userDTO.setPassWord(appUser.getPassWord());
	
	NewBoxAppUserIAO newBoxAppUserIAO = new NewBoxAppUserIAO();
	
	try {
		newBoxAppUserIAO.addNewAppUser(appUser);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ResponseEntity.status(HttpStatus.CREATED).build();
    //return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
   
  }
  
  @RequestMapping(value = "/getAppUser", method = RequestMethod.GET)
  public @ResponseBody UserDTO getAppUser(String userLoginID) {
	  UserDTO userDTO = null;
	  
	  BoxEnterpriseUserIAO boxEnterpriseUserIAO = new BoxEnterpriseUserIAO();
	  
	  try {
		userDTO = boxEnterpriseUserIAO.getBoxManagedUser(userLoginID);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return userDTO;
  }
  
}
