package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//0.file name
			//	res.addHeader("Content-Disposition", "attachment;filename=Location.pdf");
		//1.read data from modelmap
				List<Vendor> vens=(List<Vendor>)map.get("vens");
		//3.create element:paragraph,table
				Paragraph paragraph=new Paragraph("Welcometo Vendor pdf File");
				Paragraph dte=new Paragraph( new  Date().toString());
				PdfPTable table=new PdfPTable(8);
				table.addCell("ID");
				table.addCell("CODE");
				table.addCell("NAME");
				table.addCell("TYPE");
				table.addCell("ADDRESS");
				table.addCell("IDPROOF");
				table.addCell("IDNUM");
				table.addCell("NOTE");
				
				
				
				
				
				//ADDING list  data to table
				for(Vendor ven:vens){
					table.addCell(ven.getVenId()+"");
					table.addCell(ven.getVenCode());
					table.addCell(ven.getVenName());
					table.addCell(ven.getVenType());
					table.addCell(ven.getAddr());
					table.addCell(ven.getIdType());
					table.addCell(ven.getIdNum());
					table.addCell(ven.getDsc());
				}
				//add element to Document
				doc.add(paragraph);
				doc.add(table);;
				doc.add(dte);
				
				
				
				
	}

}
