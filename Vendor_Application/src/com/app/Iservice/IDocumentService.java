package com.app.Iservice;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {

public int saveDocument(Document doc);
public List<Object[]> getDocumentIdAndName();
public Document getDocumentById(int docId);
public void deleteDocumentById(int docId);

}
