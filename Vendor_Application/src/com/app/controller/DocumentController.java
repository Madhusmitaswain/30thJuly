package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.Iservice.IDocumentService;
import com.app.model.Document;

@Controller
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	
	//1. show Documents Page
	@RequestMapping("/showDocs")
	public String showDocs(ModelMap map){
		List<Object[]> docs=service.getDocumentIdAndName();
		map.addAttribute("docs", docs);
		return "MyDocuments";
	}
	
	
	//2. upload Doc to DB
	@RequestMapping(value="/docUpload",method=RequestMethod.POST)
	public String uploaddocument(
			@RequestParam("docId")int fid,
			@RequestParam("docData")CommonsMultipartFile file)
	{
		
		if(file!=null){
			Document doc=new Document();
			doc.setFileId(fid);
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			service.saveDocument(doc);
		}
		
		return "redirect:showDocs";
	}
	
	//3. download Doc based on Id
	@RequestMapping("/docDownload")
	public void downloadDoc(@RequestParam("docId")int docId,HttpServletResponse resp){
		//get document from DB
		Document doc=service.getDocumentById(docId);
		
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		
		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteDocument")
	public String deleteobj(@RequestParam("docId") int docId) {
		service.deleteDocumentById(docId);
		return "redirect:showDocs";
	
}
}
