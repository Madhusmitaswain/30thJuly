package com.app.view;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;
public class CustomerExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> map,
			HSSFWorkbook book, 
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		//0.file name
		//res.addHeader("Content-Disposition", "attachment;filename=Location.xls");
		//1.read data from modelmap
		List<Customer> custs=(List<Customer>)map.get("custs");
		//2.create sheet
		HSSFSheet hssfSheet=book.createSheet("cust");
		//3.const Header
		setHead(hssfSheet);
		//4.const body
		 setBody(hssfSheet, custs);
	
	}

	private void setHead(HSSFSheet hssfSheet) {
HSSFRow hssfRow=hssfSheet.createRow(0);
hssfRow.createCell(0).setCellValue("ID");
hssfRow.createCell(1).setCellValue("NAME");
hssfRow.createCell(2).setCellValue("EMAIL");
hssfRow.createCell(3).setCellValue("PASSWORD");
hssfRow.createCell(4).setCellValue("Type");
hssfRow.createCell(5).setCellValue("Address");
	}

	private void setBody(HSSFSheet hssfSheet, List<Customer> custs) {
int rowNum=1;
for(Customer cust:custs){
	HSSFRow hssfRow=hssfSheet.createRow(rowNum++);
	hssfRow.createCell(0).setCellValue(cust.getCustId());
	hssfRow.createCell(1).setCellValue(cust.getCustName());
	hssfRow.createCell(2).setCellValue(cust.getCustEmail());
	hssfRow.createCell(3).setCellValue(cust.getPassword());
	hssfRow.createCell(4).setCellValue(cust.getCustType());
	hssfRow.createCell(5).setCellValue(cust.getCustAddr());
	
	
	
	
}
	}

}
