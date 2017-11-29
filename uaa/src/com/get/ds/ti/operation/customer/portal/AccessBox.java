package com.get.ds.ti.operation.customer.portal;

import com.box.sdk.*;
import java.io.FileReader;
import java.io.Reader;

public class AccessBox {

	private static final int MAX_CACHE_ENTRIES = 100;
    
	public static void main( String[] args ) {
        // Open a reader to read and dispose of the automatically created Box configuration file.
    	try(Reader reader = new FileReader("config.json")) {
            // Initialize the SDK with the Box configuration file and create a client that uses the Service Account.
    		BoxConfig boxConfig = BoxConfig.readFrom(reader);
    		
            IAccessTokenCache accessTokenCache = new InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);
            
            System.out.println("getEnterpriseId-->"+boxConfig.getEnterpriseId());
            System.out.println("getClientId-->"+boxConfig.getClientId());
            System.out.println("getClientSecret-->"+boxConfig.getClientSecret());
            System.out.println("getJWTEncryptionPreferences-->"+boxConfig.getJWTEncryptionPreferences());
            System.out.println("boxConfig1-->"+boxConfig.toString());
            
            BoxDeveloperEditionAPIConnection serviceAccountClient = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(boxConfig);
            
            System.out.println("accessTokenCache-->"+accessTokenCache);
            //BoxDeveloperEditionAPIConnection serviceAccountClient = BoxDeveloperEditionAPIConnection.getAppUserConnection(boxConfig,accessTokenCache);
            // Use the getCurrentUser method to retrieve current user's information.
            // Since this client uses the Service Account, this will return the Service Account's information.
            
            System.out.println("serviceAccountClient-->"+serviceAccountClient);  
            
            BoxUser serviceAccountUser = BoxUser.getCurrentUser(serviceAccountClient);
            BoxUser.Info serviceAccountUserInfo = serviceAccountUser.getInfo();
            // Log the Service Account's login value which should contain "AutomationUser".
            // For example, AutomationUser_375517_dxVhfxwzLL@boxdevedition.com
            System.out.println("User Login info: " + serviceAccountUserInfo.getLogin());
            //System.out.println("Enterprise ID Info: " + serviceAccountUserInfo.getEnterprise().getID());
            System.out.format("Welcome, %s!\n\n", serviceAccountUserInfo.getName());
            
            Iterable<com.box.sdk.BoxUser.Info> managedUsers = BoxUser.getAllEnterpriseUsers(serviceAccountClient);
            for (BoxUser.Info managedUser : managedUsers) {
                System.out.println(managedUser.getName() + " " + managedUser.getStatus());
                if (managedUser.getStatus().equals(BoxUser.Status.ACTIVE)) {

                    // BoxDeveloperEditionAPIConnection. getAppUserConnection() is used to get AppUser or ManagedUser
                    // in this example, I'm getting a managedUser (ken.domen@nike.com)
                    //BoxDeveloperEditionAPIConnection userApi = BoxDeveloperEditionAPIConnection.getAppUserConnection(managedUser.getID(), CLIENT_ID, CLIENT_SECRET, encryptionPref, accessTokenCache);
                    BoxFolder boxFolder = new BoxFolder(serviceAccountClient, "2839647567");
                    Iterable<com.box.sdk.BoxItem.Info> items = boxFolder.getChildren();
                    System.out.println("items-->" + items);
                    /**
                    for (BoxItem.Info item : items) {
                                        if (item instanceof BoxFile.Info) {
                            BoxFile.Info fileInto = (BoxFile.Info) item;
                            System.out.println("\t" + item.getName());
                        }
                    }
                    */
                }
            }

        } catch (java.io.IOException e) {
            // Log any errors for debugging
            e.printStackTrace();
        }
    }
	
}
