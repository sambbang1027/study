package app.labs.ex06.fileupload.service;

import java.util.List;

import app.labs.ex06.fileupload.model.UploadFile;

public interface IUploadFileService {

			void uploadFile(UploadFile file);
		
		    List<UploadFile> getFileList(String dir);
		    List<UploadFile> getAllFileList();
		    List<UploadFile> getImageList(String dir);
		
		    UploadFile getFile(int fileId);
		
		    String getDirectoryName(int fileId);
		    void updateDirectory(int[] fileIds, String directoryName);
		
		    void deleteFile(int fileId);
}
