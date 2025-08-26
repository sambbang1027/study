package app.labs.ex06.fileupload.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.labs.ex06.fileupload.model.UploadFile;

@Repository
public class UploadFileRepository implements IUploadFileRepository {

			@Autowired
			JdbcTemplate jdbcTemplate;
		
			// 익명클래스를 이용해서 람다 표현 적용하면 더 간단하고 가독성 좋게 만들 수 있다.
			// 리스트형 따로 다운로드받은 파일 용 따로 만들어야 함
		
			// 리스트
			RowMapper<UploadFile> uploadFileMapper 
									= (ResultSet rs, int rowNum) -> UploadFile.builder()
													.fileId(rs.getInt("file_id"))
													.directoryName(rs.getString("directory_name"))
													.fileName(rs.getString("file_name"))
													.fileSize(rs.getLong("file_size"))
													.fileContentType(rs.getString("file_content_type"))
													.fileUploadDate(rs.getTimestamp("file_upload_date"))
													.build();
		
				// 다운로드 
			RowMapper<UploadFile> uploadFileBinMapper 
									= (ResultSet rs, int rowNum) -> UploadFile.builder()
														.fileId(rs.getInt("file_id"))
														.directoryName(rs.getString("directory_name"))
														.fileName(rs.getString("file_name"))
														.fileSize(rs.getLong("file_size"))
														.fileContentType(rs.getString("file_content_type"))
														.fileData(rs.getBytes("file_data"))
														.build();
									
									
			@Override
			public int getMaxFileId() {
				String sql = "SELECT NVL(MAX(file_id),0) FROM upload_file";
				// null일 경우 0으로 처리 
				return jdbcTemplate.queryForObject(sql, Integer.class);
			}
		
			@Override
			public void uploadFile(UploadFile file) {
				String sql = "INSERT INTO upload_file "
		                + "    (file_id, directory_name, file_name, file_size, "
		                + " file_content_type, file_upload_date, file_data) "
		                + "    VALUES (?, ?, ?, ?, ?, SYSTIMESTAMP, ?)";
				// BLOB은 바로 insert가 안되서 따로 빼서 insert를 했어야했는데 jdbc는 알아서 다 넣어줌 굳
				jdbcTemplate.update(sql,
										file.getFileId(),
						                file.getDirectoryName(), 
						                file.getFileName(), 
						                file.getFileSize(), 
						                file.getFileContentType(),
						                file.getFileData());
			}
		
			@Override
			public List<UploadFile> getFileList(String directoryName) {
				String sql = "SELECT file_id, directory_name, file_name, file_size, "
		                + "    file_content_type, file_upload_date "
		                + " FROM upload_file WHERE directory_name=? "
		                + " ORDER BY file_upload_date DESC ";
				
				return jdbcTemplate.query(sql, uploadFileMapper, directoryName);
			}
		
			@Override
			public List<UploadFile> getAllFileList() {
				String sql = "SELECT file_id, directory_name, file_name, file_size, "
		                + "    file_content_type, file_upload_date "
		                + " FROM upload_file"
		                + " ORDER BY file_upload_date DESC ";
				return jdbcTemplate.query(sql, uploadFileMapper);
			}
		
			@Override
			public List<UploadFile> getImageList(String directoryName) {
				String sql = "SELECT file_id, directory_name, file_name, file_size, "
		                + "    file_content_type, file_upload_date , file_data"
		                + " FROM upload_file WHERE directory_name=? "
		                + " ORDER BY file_upload_date DESC ";
				
				return jdbcTemplate.query(sql, uploadFileMapper, directoryName);
			}
		
			@Override
			public UploadFile getFile(int fileId) {
				String sql = "SELECT file_id, directory_name, file_name, file_size, "
		                + "    file_content_type, file_data "
		                + " FROM upload_file "
		                + " WHERE file_id=?";
				return jdbcTemplate.queryForObject(sql, uploadFileBinMapper, fileId);
			}
		
			@Override
			public String getDirectoryName(int fileId) {
				String sql = "SELECT directory_name "
			            + " FROM upload_file "
			            + " WHERE file_id=?";
				return jdbcTemplate.queryForObject(sql, String.class, fileId);
			}
			
			@Override
			public void updateDirectory(HashMap<String, Object> map) {
				String sql = "UPDATE upload_file "
						+ "SET  directory_name=? "
						+ "WHERE file_id=?";
			
				 jdbcTemplate.update(sql, map.get("directoryName"), map.get("fileId"));
			}
			
			@Override
			public void deleteFile(int fileId) {
				String sql = "DELETE FROM upload_file WHERE file_id=?";
				jdbcTemplate.update(sql, fileId);
			}

}

