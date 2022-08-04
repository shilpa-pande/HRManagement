package com.hr_management.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hr_management.entity.HrDocuments;
import com.hr_management.service.HrDocsService;

@RestController
public class HrDocRestController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/hrDoc";
	
	
	@Autowired
	private HrDocsService hrService;
	
	
	@PostMapping(value = "/hr/hrDoc")
	public void empProfile( @RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("hrdoc") MultipartFile hrdoc) {
		try {
			
			HrDocuments hrdocs = new HrDocuments();
		
			hrdocs.setName(name);
			hrdocs.setDescription(description);
		

			String imageUUID;

			// for storing image in project folder
			if (!hrdoc.isEmpty()) {
				imageUUID = hrdoc.getOriginalFilename();
				Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
				Files.write(fileNameAndPath, hrdoc.getBytes());
			} else {
				imageUUID = name;
			}
			hrdocs.setDocName(imageUUID);
			
		hrService.saveHrDocs(hrdocs);
		}catch (Exception e) {
			System.out.println("please fill all the fields properly");
		
}
}
	
	
	
		@GetMapping("/hr/hrDocs")
		private List<HrDocuments> getdoc(@RequestParam String keyword) {
			
			if(keyword == null) {		
				List<HrDocuments> hrdocs = hrService.gethrDocs();
	     		return hrdocs;
			}else {	
	     		List<HrDocuments> hrdoc = hrService.gethrDocByKeyword(keyword);
				return hrdoc;
			}
		
		
		
		}
		
	
		@RequestMapping(method = RequestMethod.DELETE, value = "/hr/deleteDoc/{pid}")
		public void deleteDocById(@PathVariable int pid) {
			hrService.deleteDocById(pid);
		}
		
		
}
	
