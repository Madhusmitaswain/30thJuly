package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.app.model.Location;
import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//0.file name
			//	res.addHeader("Content-Disposition", "attachment;filename=Location.pdf");
		//1.read data from modelmap
				List<Customer> custs=(List<Customer>)map.get("custs");
		//3.create element:paragraph,table
				Paragraph paragraph=new Paragraph("Welcometo Customer pdf File");
				Paragraph dte=new Paragraph( new  Date().toString());
				PdfPTable table=new PdfPTable(6);
				table.addCell("ID");
				table.addCell("NAME");
				table.addCell("TYPE");
				table.addCell("EMAIL");
				table.addCell("PASSWORD");
				table.addCell("ADDRESS");
				
				
				
				
				
				//ADDING list  data to table
				for(Customer cust:custs){
					table.addCell(cust.getCustId()+"");
					table.addCell(cust.getCustName());
					table.addCell(cust.getCustType());
					table.addCell(cust.getCustEmail());
					table.addCell(cust.getPassword());
					table.addCell(cust.getCustAddr());
				}
				//add element to Document
				doc.add(paragraph);
				doc.add(table);;
				doc.add(dte);
				
				
				
				
	}

}
