package com.get.ds.ti.operation.customer.portal;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.box.sdk.BoxConfig;
import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxUser;
import com.box.sdk.CreateUserParams;
import com.box.sdk.IAccessTokenCache;
import com.box.sdk.InMemoryLRUAccessTokenCache;


public final class NewAppUser {

    //In the real development, these two will come from the user "Sign Up" page
	//EXTERNAL_APP_USER_ID must be unique to the App, which can be email address as the User Name
	private static final String APP_USER_NAME = "Amanda Clinton";
    private static final String EXTERNAL_APP_USER_ID = "amanda.clinton@cn.com";
    
    private static final int MAX_CACHE_ENTRIES = 100;

    private NewAppUser() { }

    public static void main(String[] args) throws IOException {
        // Turn off logging to prevent polluting the output.
        Logger.getLogger("com.box.sdk").setLevel(Level.OFF);


        //It is a best practice to use an access token cache to prevent unneeded requests to Box for access tokens.
        //For production applications it is recommended to use a distributed cache like Memcached or Redis, and to
        //implement IAccessTokenCache to store and retrieve access tokens appropriately for your environment.
        IAccessTokenCache accessTokenCache = new InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);
        
        System.out.format("Access token is: " + accessTokenCache.toString());
        System.out.format("\n");

        Reader reader = new FileReader("config.json");
        BoxConfig boxConfig = BoxConfig.readFrom(reader);

        BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(
                boxConfig, accessTokenCache);

        CreateUserParams params = new CreateUserParams();
        params.setSpaceAmount(573741824); //1 GB
        //This optional param can be used to store any id, like an email, of the user
        //for which the associated app user is being created.
        params.setExternalAppUserId(EXTERNAL_APP_USER_ID);
        params.setIsPlatformAccessOnly(true);
        
        BoxUser.Info user = BoxUser.createAppUser(api, APP_USER_NAME, params);

        System.out.format("User created with name %s and id %s\n\n", APP_USER_NAME, user.getID());
    }
}