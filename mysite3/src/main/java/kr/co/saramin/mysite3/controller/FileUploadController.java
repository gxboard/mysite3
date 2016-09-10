package kr.co.saramin.mysite3.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.saramin.mysite3.service.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	
	private static final Log LOG = LogFactory.getLog( FileUploadController.class );
	private static final String SAVE_PATH = "/temp";
	
	@Autowired
	private FileUploadService fileUploadService;
	  
	@RequestMapping( "/form" )
	public String form() {
		return "fileupload/form";
	}
	
	@RequestMapping( "/upload" )
	public String upload( 
			@RequestParam String email,
			@RequestParam( "file1" ) MultipartFile file1, 
			@RequestParam( "file2" ) MultipartFile file2,
			Model model ) {
        
		// 보통 파라미터의 값
		LOG.debug( " ######## email : " + email );
		
		String saveFileName = fileUploadService.saveFile(file1);
		String url = "/upload-image/" + saveFileName;
		model.addAttribute("urlImage1", url);

		System.out.println(saveFileName);
		System.out.println(url);

		
        String saveFileName2 = fileUploadService.saveFile(file2);
        String url2 = "/upload-image/" + saveFileName2;
        model.addAttribute("urlImage2", url2);
		
		
		return "fileupload/result";

		
	}
	
	
	
	
}
