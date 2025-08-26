package app.labs.ex06.fileupload.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.labs.ex06.fileupload.model.UploadFile;
import app.labs.ex06.fileupload.service.IUploadFileService;
import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadFileController {

	
		@Autowired
		IUploadFileService uploadFileService;


		@GetMapping(value={"/upload/", "/upload"})
		public String getIndex(Model model) {
			return "index";
		}
		
		
		@GetMapping(value={"/upload/new"})
		public String uploadFile(Model model) {
			return "form";
		}
		
		@PostMapping(value={"/upload/new"})	// requestParam = default value가 필요할 때 사용한다 
		public String uploadFile(@RequestParam(value = "dir", required = false, defaultValue = "/") String dir  
												   ,@RequestParam MultipartFile file , RedirectAttributes redirectAttr) {
		
			//log.debug(file.getOriginalFilename());

			try {
				uploadFileService.uploadFile(UploadFile.builder()
						.directoryName(dir)
						.fileName(file.getOriginalFilename())
						.fileSize(file.getSize())
						.fileContentType(file.getContentType())
						.fileData(file.getBytes())
						.build());
				
			} catch (Exception e) {
				log.debug(e.getMessage());
				redirectAttr.addFlashAttribute("message", e.getMessage());
			}
			
			return "redirect:/upload/list";
		}
		
		@GetMapping(value = "/upload/list")
		public String getFileList(Model model) {

			model.addAttribute("fileList", uploadFileService.getAllFileList());	
			
			return "list";
		}
		
		@GetMapping(value = "/file/{fileId}")
		public ResponseEntity<byte[]> getBinaryFile(@PathVariable int fileId ) {
				final HttpHeaders headers = new HttpHeaders();
				
				UploadFile file = uploadFileService.getFile(fileId);
				
				if(file != null) {
					//파일 다운로드를 위한 최소셋팅 
					String[] mtypes = file.getFileContentType().split("/");
					headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
					headers.setContentLength(file.getFileSize());
					
					try {
						String fileName = URLEncoder.encode(file.getFileName(), "UTF-8");
						headers.setContentDispositionFormData("attachment", fileName);
						
					} catch (UnsupportedEncodingException e) {
						throw new RuntimeException();
					}
					
					return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
					
				}else {
					return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
				}
		}
		
		@GetMapping(value = "/upload/delete/{fileId}")
		public String deleteFile(@PathVariable int fileId) {
			uploadFileService.deleteFile(fileId);
			return "redirect:/upload/list";
		}
		
		@PostMapping(value = "/upload/updateDir")
		public String updateDirectory( @RequestParam int[] fileIds, @RequestParam String directoryName) {
			uploadFileService.updateDirectory(fileIds, directoryName);
			return "redirect:/upload/list";
		}
		
		
		@GetMapping(value = "/upload/list/{dir}")
		public String getFileListByDir(@PathVariable String dir, Model model) {

			model.addAttribute("fileList", uploadFileService.getFileList("/"+dir));	
			
			return "list";
		}
		
		@GetMapping(value = "/upload/gallery")
		public String getImageList(@RequestParam(value = "dir", required = false, defaultValue = "/images")  String dir
														,Model model) {

			model.addAttribute("fileList", uploadFileService.getFileList(dir));	
			
			return "list";
		}
		
}
