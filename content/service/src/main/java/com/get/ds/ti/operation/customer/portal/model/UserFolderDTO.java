package com.get.ds.ti.operation.customer.portal.model;

public class UserFolderDTO {
	private String userBoxID;
	private String folderID;
	private String folderName;

	public UserFolderDTO (
	      String userBoxID, String folderID, String folderName) {
	   
	    this.userBoxID = userBoxID;
	    this.folderID = folderID;
	    this.folderName = folderName;
	  }

	  	public UserFolderDTO() {}

		public String getUserBoxID() {
			return userBoxID;
		}
		
		public void setUserBoxID(String userBoxID) {
			this.userBoxID = userBoxID;
		}

		public String getFolderID() {
			return folderID;
		}

		public void setFolderID(String folderID) {
			this.folderID = folderID;
		}

		public String getFolderName() {
			return folderName;
		}

		public void setFolderName(String folderName) {
			this.folderName = folderName;
		}
}
