package com.get.ds.ti.operation.customer.portal.boxconnection;

import java.io.FileReader;
import java.io.Reader;

import com.box.sdk.BoxConfig;
import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.IAccessTokenCache;
import com.box.sdk.InMemoryLRUAccessTokenCache;

public class BoxSecureConnection {
	
	private static final int MAX_CACHE_ENTRIES = 100;
	
	//to get the connection to Box.com for a specific app user with known ID
	public BoxDeveloperEditionAPIConnection getAPPUserConnectionFromBox(String userBoxID) throws Exception {
		BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection = null;
		
		try(Reader reader = new FileReader("config.json")) {
			
			IAccessTokenCache accessTokenCache = new InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);
            
			BoxConfig boxConfig = BoxConfig.readFrom(reader);

	        boxDeveloperEditionAPIConnection = BoxDeveloperEditionAPIConnection.getAppUserConnection(
	        		userBoxID, boxConfig, accessTokenCache);

		} catch (java.io.IOException e) {
            // Log any errors for debugging
            e.printStackTrace();
        }
		
		return boxDeveloperEditionAPIConnection;
	}
	
	//to get the connection to Box.com for the enterprise user
	public BoxDeveloperEditionAPIConnection getAppEnterpriseConnectionFromBox() throws Exception {
		BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection = null;
		
		try(Reader reader = new FileReader("config.json")) {
			BoxConfig boxConfig = BoxConfig.readFrom(reader);
			boxDeveloperEditionAPIConnection = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(boxConfig);
			//System.out.println("The enterprise user access token is - " + boxDeveloperEditionAPIConnection.getAccessToken());
		} catch (java.io.IOException e) {
            // Log any errors for debugging
            e.printStackTrace();
        }
		
		return boxDeveloperEditionAPIConnection;
		
	}

}
