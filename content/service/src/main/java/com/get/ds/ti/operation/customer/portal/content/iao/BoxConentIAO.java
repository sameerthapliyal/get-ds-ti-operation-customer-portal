package com.get.ds.ti.operation.customer.portal.content.iao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.get.ds.ti.operation.customer.portal.model.UserContentDTO;
import com.get.ds.ti.operation.customer.portal.model.UserFileDTO;
import com.get.ds.ti.operation.customer.portal.model.UserFolderDTO;



public class BoxConentIAO {
	private static final int MAX_DEPTH = 10;

	public void downloadBoxContent(BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection, String fileID) {
		FileOutputStream stream = null;
		
		try {
			
			BoxFile file = new BoxFile(boxDeveloperEditionAPIConnection, fileID);
			BoxFile.Info info = file.getInfo();
			
			System.out.println("file id: " + file.getID());
			System.out.println("file name: " + info.getName());
			
			stream = new FileOutputStream(info.getName());
			
			file.download(stream);
			//stream.close();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<UserContentDTO> getFolderAndFile(BoxDeveloperEditionAPIConnection boxDeveloperEditionAPIConnection) {
        List<UserContentDTO> userContentDTOList = new ArrayList<>();
        BoxFolder rootFolder = BoxFolder.getRootFolder(boxDeveloperEditionAPIConnection);
        userContentDTOList = listFolder(rootFolder, 5);
        return userContentDTOList;
    }

    private List<UserContentDTO> listFolder(BoxFolder folder, int depth) {
        List<UserContentDTO> userContentDTOList = new ArrayList<>();
        for (BoxItem.Info itemInfo : folder) {
            UserContentDTO userContentDTO = new UserContentDTO();
            if (itemInfo instanceof BoxFile.Info) {
                //BoxFile.Info fileInfo = (BoxFile.Info) itemInfo;
                System.out.println("Your file name is: " + itemInfo.getName());
                System.out.println("Your file id is: : " + itemInfo.getID());
                UserFileDTO userFileDTO = new UserFileDTO();
                userFileDTO.setFileID(itemInfo.getID());
                userFileDTO.setFileName(itemInfo.getName());
                userContentDTO.setUserFileDTO(userFileDTO);
            } else if (itemInfo instanceof BoxFolder.Info) {
                //BoxFolder.Info folderInfo = (BoxFolder.Info) itemInfo;
                System.out.println("Your folder name is: " + itemInfo.getName());
                System.out.println("Your folder id is: : " + itemInfo.getID());
                UserFolderDTO userFolderDTO = new UserFolderDTO();
                userFolderDTO.setFolderID(itemInfo.getID());
                userFolderDTO.setFolderName(itemInfo.getName());
                userContentDTO.setUserFolderDTO(userFolderDTO);
            }
            if (itemInfo instanceof BoxFolder.Info) {
                BoxFolder childFolder = (BoxFolder) itemInfo.getResource();
                if (depth < MAX_DEPTH) {
                    userContentDTOList.addAll(listFolder(childFolder, depth + 1));
                }
            }
            userContentDTOList.add(userContentDTO);
        }
        return userContentDTOList;
    }
}

