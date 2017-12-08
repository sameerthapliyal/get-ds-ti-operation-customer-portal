package com.get.ds.ti.operation.customer.portal.model;

public class UserFileDTO {
	private String userBoxID;
	private String fileID;
	private String fileName;

	public UserFileDTO (
	      String userBoxID, String fileID, String fileName) {
	   
	    this.userBoxID = userBoxID;
	    this.fileID = fileID;
	    this.fileName = fileName;
	  }

	  	public UserFileDTO() {}

		public String getUserBoxID() {
			return userBoxID;
		}
		
		public void setUserBoxID(String userBoxID) {
			this.userBoxID = userBoxID;
		}

		public String getFileID() {
			return fileID;
		}

		public void setFileID(String fileID) {
			this.fileID = fileID;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
}
