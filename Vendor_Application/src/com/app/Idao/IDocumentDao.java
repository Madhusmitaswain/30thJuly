package com.app.Idao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {
	
public int saveDocument(Document doc);
public List<Object[]> getDocumentIdAndName();
public Document getDocumentById(int docId);
public void deleteDocumentById(int docId);





}
