package com.get.ds.ti.operation.customer.portal.content.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.get.ds.ti.operation.customer.portal.boxconnection.BoxSecureConnection;
import com.get.ds.ti.operation.customer.portal.content.iao.BoxConentIAO;
import com.get.ds.ti.operation.customer.portal.model.UserContentDTO;

import java.util.List;

@RestController
public class BoxContentController {
	BoxConentIAO boxContentIAO = null;
	BoxSecureConnection boxSecureConnection;
	BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection;
	
	//252827965906 -file id
	//2972566251 -test user id
	@RequestMapping(value = "/downloadContent", method = RequestMethod.GET)
	public void downloadContentFroBox(String userLoginID, String fileID) {
		boxContentIAO = new BoxConentIAO();
		  
		  
		try {
			boxSecureConnection = new BoxSecureConnection();
			
			boxDeveloperEditionAPIConnection = boxSecureConnection.getAPPUserConnectionFromBox(userLoginID);
			boxContentIAO.downloadBoxContent(boxDeveloperEditionAPIConnection, fileID);;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getFolderAndFile", method = RequestMethod.GET)
    public
    @ResponseBody
    List<UserContentDTO> getFolderAndFile(String userBoxID) {
        boxContentIAO = new BoxConentIAO();
        List<UserContentDTO> userContentDTO = null;

        try {
            boxSecureConnection = new BoxSecureConnection();

            boxDeveloperEditionAPIConnection = boxSecureConnection.getAPPUserConnectionFromBox(userBoxID);
            userContentDTO = boxContentIAO.getFolderAndFile(boxDeveloperEditionAPIConnection);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userContentDTO;
    }
	
	/**
	//252827965906 -file id
	//2972566251 -test user id
	@RequestMapping(value = "/downloadContent", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadContentFroBoxWithResponse(String userLoginID, String fileID) {
		boxContentIAO = new BoxConentIAO();
		  
		try {
			boxSecureConnection = new BoxSecureConnection();
			
			boxDeveloperEditionAPIConnection = boxSecureConnection.getAPPUserConnectionFromBox(userLoginID);
			boxContentIAO.downloadBoxContent(boxDeveloperEditionAPIConnection, fileID);;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok()
	           .headers(headers)
	           .contentLength(file.length())
	           .contentType(MediaType.parseMediaType("application/octet-stream"))
	           .body(resource);
	}
	*/
}
