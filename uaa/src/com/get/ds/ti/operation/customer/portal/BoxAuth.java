/**
 * 
 */
package com.get.ds.ti.operation.customer.portal;

/**
 * @author haibo.hu
 *
 */
import com.box.sdk.*;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;

public class BoxAuth {

	/**
	 * @param args
	 */
	/*
	static final String ENTERPRISE_ID = ConfigHelper.properties().getProperty("boxEnterpriseId");
    static final String CLIENT_ID = ConfigHelper.properties().getProperty("boxClientId");
    static final String CLIENT_SECRET = ConfigHelper.properties().getProperty("boxClientSecret");
    static final String PRIVATE_KEY_FILE = ConfigHelper.properties().getProperty("boxPrivateKeyFile");
    static final String PRIVATE_KEY_PASSWORD = ConfigHelper.properties().getProperty("boxPrivateKeyPassword");
    static final String PUBLIC_KEY_ID = ConfigHelper.properties().getProperty("boxPublicKeyId");
    */
	
    static final String ENTERPRISE_ID = "32970319";
    static final String CLIENT_ID = "uhmq83muaxf6k8raf9kbsng22yuyj0b9";
    static final String CLIENT_SECRET = "FBH6OUvROWtmwdgJzrbtpMVO2WfIUjly";
    //static final String PRIVATE_KEY_FILE = ConfigHelper.properties().getProperty("boxPrivateKeyFile");
    //static final String PRIVATE_KEY_PASSWORD = ConfigHelper.properties().getProperty("boxPrivateKeyPassword");
    //static final String PUBLIC_KEY_ID = ConfigHelper.properties().getProperty("boxPublicKeyId");

    static final String BOX_USER_ID_KEY = "box_id";
    static final String BOX_USER_NAME = "name";

    static final int MAX_CACHE_ENTRIES = 100;

    private static IAccessTokenCache accessTokenCache;
    private static JWTEncryptionPreferences jwtEncryptionPreferences;
	
	public static void main(String[] args) {
		/*
		 * original code
		// Open a reader to read and dispose of the automatically created Box
		// configuration file.
		try (Reader reader = new FileReader("src/config/32970319_3kvmfzit_config.json")) {
			// Initialize the SDK with the Box configuration file and create a
			// client that uses the Service Account.
			BoxConfig boxConfig = BoxConfig.readFrom(reader);
			BoxDeveloperEditionAPIConnection serviceAccountClient = BoxDeveloperEditionAPIConnection  //.getAppEnterpriseConnection("32970319", "uhmq83muaxf6k8raf9kbsng22yuyj0b9", "uhmq83muaxf6k8raf9kbsng22yuyj0b9", encryptionPref, accessTokenCache);
			.getAppEnterpriseConnection(boxConfig);
			// Use the getCurrentUser method to retrieve current user's
			// information.
			// Since this client uses the Service Account, this will return the
			// Service Account's information.
			BoxUser serviceAccountUser = BoxUser.getCurrentUser(serviceAccountClient);
			BoxUser.Info serviceAccountUserInfo = serviceAccountUser.getInfo();
			// Log the Service Account's login value which should contain
			// "AutomationUser".
			// For example, AutomationUser_375517_dxVhfxwzLL@boxdevedition.com
			System.out.println(serviceAccountUserInfo.getLogin());
		} catch (java.io.IOException e) {
			// Log any errors for debugging
			e.printStackTrace();
		}
		*/
		
		/*
		File keyFile = new File(PRIVATE_KEY_FILE);
        byte[] fileData = new byte[(int) keyFile.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(keyFile));
        dis.readFully(fileData);
        dis.close();

        String privateKey = new String(fileData);
		*/
		
		/*this block works
		BoxAPIConnection api = new BoxAPIConnection("b20CxpxmG4fcuuQlJokLy1F1xpgbwg0s");
		BoxFolder rootFolder = BoxFolder.getRootFolder(api);
		for (BoxItem.Info itemInfo : rootFolder) {
		    System.out.format("[%s] %s\n", itemInfo.getID(), itemInfo.getName());
		}
		*/
		
		
        JWTEncryptionPreferences encryptionPref = new JWTEncryptionPreferences();
        //encryptionPref.setPublicKeyID(PUBLIC_KEY_ID);
        encryptionPref.setPublicKeyID("wtbyjnzg");
        encryptionPref.setPrivateKey("MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQI6zFr9LGPF/ECAggA\\nMBQGCCqGSIb3DQMHBAgVL9Z1r+N/iQSCBMg8o+6TT9vse2L48ITVCSN7zZXhBUBY\\n+2WJHT3WZXH+gRC737kQ0WBDyABHkXEji4sJc6zrzcQ8h3nQvkYhrATyWjwnVqVs\\nsTNVFnpxRC/1dFseCuGSdqD35qok31C7UlhrO0LKbxZUltAq9h8E73tn9YReOWEz\\njhFbzz05CGwjd1eFnQ2nsss+I13+otaeLypmbDaNL8KFninG4e2sQI7nzXBIBluM\\nOuIEJwDQwOoA8tH788gz0wygrpJVaXkv4Bs6MvzNfqNItxirVqDBDuW+OkwhdIla\\n70hgUIhgLr5c4SaL8s9eL5rQ3ilPP0jiTde8oC+V4wqDaBHU2bU85rmCS3TUqXfV\\nGbNtXn40L/6DTQMw2PNSKMQSJLe6jNpNeQ05c2sdIugHlHGTPRE5TuwzbLdRsRVB\\nqzqYUVmGJ+Lw+0clGSCfQbXzYumFrd6xfIY4TUQI4ZJ0O+v+6x8ghs4+JhI6iqZg\\nJsqU+V6XlHBoSkw4wOb5QobsTiz+Zki90b8TTxz1h1VMV0Tt1rdixPZiCx99LRrm\\nkftaVOU6URG8DYuV8G1+5hKaipnQnI+oUj4ednPpWXs6f98py/3Gp7Qs3ODYrB2E\\nVvtN0Ut4TC+EI1ru6sWSHFeGrzqlhMkIiVlAisCdJSNu3BS9vTcPKUYqbX56KkxB\\npzzsZ36QxYv+JJfabUqSsRMuOIp0DnpIlJ0ABKeBkhhyDggBF0F98ZZMv8ZQie7P\\nfW2gLf9cL/bWF24JM8ILX9h5e9plIU+W4hpoYWvdcoQs/xmWvyVOVlUzxqXpOSPv\\nPFUGoFx0fzU0aDNVapUEaq6I9R3igV9LVjhVvPTiuj5pnKR8jelYO9I6FPBvPYup\\nKy1g9Pv/gOQ0Is/sXMYbq3KP4tR4iC8Fk/QiS1bsmDnejdYqtMenRMX+E7QcL34U\\nQ2SWDIpzq6Hz71skcltZ7a1+pydym2LDMcIlNeTX5DCHawVyxVgCtp76cty+D8la\\nmITALttiLPLAp2L3CYJkMDOKn6saV0flCh8IXWq1qHAY6eGOb0DSenZ5fnLM/CN9\\njwIzS1BVnI0FHY+JR90JTcYsbhf4VKBn/5I+zCTg2W0zxmbeEU5MuC4Xvor4wkqT\\n/Fg2VQ+n2YTnWD34Xd4olwnfkHTfFh2Z4WDZiaZyBAbavnDFkzG7OggomC28uOLQ\\nsvvJQJ0fjUtQwjMdbgzqGMXHg0DCyPeLRMqzruA19iF+FZ1bznKh+fYodCpl8/jN\\n6TsfwKmb5sOmIlcWpf2euyKu1FUP8cu6B4Eqj3ugP063x/Y25SrHC5Qn15Rii0P0\\nGCL+tULFbYXKGt1+CsOOJvRtkIAwqHgQC15LmJI8LQEDbkhVEoLp/dcH6ugV7hsq\\nCh4yA8CPXurigM37nV0RIiQSOiBtemXiUDviWLL6bSCMq3jRolkp6Al6Zry9LP6b\\niAl+5psUnis8oEgRlqIxELP6A6Ovu59jFi59QTp7XchdSXocevh1N1D5TnTApJnD\\naBELaW75dLnL/neak+Ngja+HrZQ9+evZuhLOnY52WGQdM1Ugk4o8FbnnD1fwxSb9\\nOKU2HDanT4z90lSDMm/JPSjvIhhi3ZHjyN2SQgTdQ/hrwWuSJPXXubVfhtoGb4Ig\\no/0=");
        //encryptionPref.setPrivateKeyPassword(PRIVATE_KEY_PASSWORD);
        encryptionPref.setPrivateKeyPassword("d29f841cbf81948275cf6296ce1c4985");
        encryptionPref.setEncryptionAlgorithm(EncryptionAlgorithm.RSA_SHA_256);

        IAccessTokenCache accessTokenCache = new InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);

        BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(
                ENTERPRISE_ID, CLIENT_ID, CLIENT_SECRET, encryptionPref, accessTokenCache);

        
        BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();
        System.out.format("Welcome, %s!\n\n", userInfo.getName());

        Iterable<com.box.sdk.BoxUser.Info> managedUsers = BoxUser.getAllEnterpriseUsers(api, "ken.domen@nike.com");
        for (BoxUser.Info managedUser : managedUsers) {
            System.out.println(managedUser.getName() + " " + managedUser.getStatus());
            if (managedUser.getStatus().equals(BoxUser.Status.ACTIVE)) {

                // BoxDeveloperEditionAPIConnection. getAppUserConnection() is used to get AppUser or ManagedUser
                // in this example, I'm getting a managedUser (ken.domen@nike.com)
                BoxDeveloperEditionAPIConnection userApi = BoxDeveloperEditionAPIConnection.getAppUserConnection(managedUser.getID(), CLIENT_ID, CLIENT_SECRET, encryptionPref, accessTokenCache);

                BoxFolder boxFolder = new BoxFolder(userApi, "0");
                Iterable<com.box.sdk.BoxItem.Info> items = boxFolder.getChildren();
                for (BoxItem.Info item : items) {
                    if (item instanceof BoxFile.Info) {
                        BoxFile.Info fileInto = (BoxFile.Info) item;
                        System.out.println("\t" + item.getName());
                    }
                }
            }
        }

	}

}
