package com.app.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Idao.IDocumentDao;
import com.app.Iservice.IDocumentService;
import com.app.model.Document;
@Service
public class DocumentServiceImpl implements IDocumentService{
@Autowired
	IDocumentDao dao;
	//@Override
	public int saveDocument(Document doc) {
		// TODO Auto-generated method stub
		return dao.saveDocument(doc);
	
	}
	//@Override
	public List<Object[]> getDocumentIdAndName() {
		// TODO Auto-generated method stub
		return dao.getDocumentIdAndName();
	}
	//@Override
	public Document getDocumentById(int docId) {
		// TODO Auto-generated method stub
		return dao.getDocumentById(docId);
	}
	//@Override
	public void deleteDocumentById(int docId) {
		dao.deleteDocumentById(docId);
		
	}

}
