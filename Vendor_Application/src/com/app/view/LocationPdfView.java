package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//0.file name
			//	res.addHeader("Content-Disposition", "attachment;filename=Location.pdf");
		//1.read data from modelmap
				List<Location> locs=(List<Location>)map.get("locs");
		//3.create element:paragraph,table
				Paragraph paragraph=new Paragraph("WelcometoLocation pdf File");
				Paragraph dte=new Paragraph( new  Date().toString());
				PdfPTable table=new PdfPTable(5);
				table.addCell("ID");
				table.addCell("NAME");
				table.addCell("TYPE");
				table.addCell("CODE");
				table.addCell("NOTE");
				//ADDING list  data to table
				for(Location loc:locs){
					table.addCell(loc.getLocId()+"");
					table.addCell(loc.getLocName());
					table.addCell(loc.getLocType());
					table.addCell(loc.getLocCode());
					table.addCell(loc.getLocDsc());
					
				}
				//add element to Document
				doc.add(paragraph);
				doc.add(table);;
				doc.add(dte);
				
				
				
				
	}

}
