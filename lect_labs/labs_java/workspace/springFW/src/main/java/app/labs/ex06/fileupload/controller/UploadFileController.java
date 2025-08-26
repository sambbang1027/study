package app.labs.ex06.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.labs.ex06.fileupload.model.UploadFile;
import app.labs.ex06.fileupload.service.IUploadFileService;
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
		
}
