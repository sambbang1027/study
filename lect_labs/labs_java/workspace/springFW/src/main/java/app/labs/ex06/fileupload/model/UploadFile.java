package app.labs.ex06.fileupload.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"fileData"}) // fileDate 제외 
@Getter @Setter
public class UploadFile {
	
			private int fileId;
		    private String directoryName;
		    private String fileName;
		    private long fileSize;
		    private String fileContentType;
		    private Timestamp fileUploadDate;
		    private byte[] fileData;
}
