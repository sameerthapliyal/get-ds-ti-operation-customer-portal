package com.get.ds.ti.operation.customer.portal.model;

public class UserContentDTO {
	
	private String userBoxID;
	private String folderID;
	private String folderName;
	private String fileID;
	private String fileName;
	
	private UserFolderDTO userFolderDTO;
	private UserFileDTO userFileDTO;

	  public UserContentDTO (
	      String userBoxID, String folderID, String folderName, String fileID, String fileName) {
	   
	    this.userBoxID = userBoxID;
	    this.folderID = folderID;
	    this.folderName = folderName;
	    this.fileID = fileID;
	    this.fileName = fileName;
	  }

	  	public UserContentDTO() {}

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

		public UserFolderDTO getUserFolderDTO() {
			return userFolderDTO;
		}

		public void setUserFolderDTO(UserFolderDTO userFolderDTO) {
			this.userFolderDTO = userFolderDTO;
		}

		public UserFileDTO getUserFileDTO() {
			return userFileDTO;
		}

		public void setUserFileDTO(UserFileDTO userFileDTO) {
			this.userFileDTO = userFileDTO;
		}
}
