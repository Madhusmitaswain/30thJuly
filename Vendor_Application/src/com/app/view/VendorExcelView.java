package com.app.view;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;


public class VendorExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> map,
			HSSFWorkbook book, 
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		//0.file name
		//res.addHeader("Content-Disposition", "attachment;filename=Location.xls");
		//1.read data from modelmap
		List<Vendor> vens=(List<Vendor>)map.get("vens");
		//2.create sheet
		HSSFSheet hssfSheet=book.createSheet("ven");
		//3.const Header
		setHead(hssfSheet);
		//4.const body
		 setBody(hssfSheet, vens);
	
	}

	private void setHead(HSSFSheet hssfSheet) {
HSSFRow hssfRow=hssfSheet.createRow(0);
hssfRow.createCell(0).setCellValue("ID");
hssfRow.createCell(1).setCellValue("CODE");
hssfRow.createCell(2).setCellValue("NAME");
hssfRow.createCell(3).setCellValue("TYPE");
hssfRow.createCell(4).setCellValue("ADDRESS");
hssfRow.createCell(5).setCellValue("IDPROOF");
hssfRow.createCell(6).setCellValue("IDNUM");
hssfRow.createCell(7).setCellValue("NOTE");

	}

	private void setBody(HSSFSheet hssfSheet, List<Vendor> vens) {
int rowNum=1;
for(Vendor ven:vens){
	HSSFRow hssfRow=hssfSheet.createRow(rowNum++);
	hssfRow.createCell(0).setCellValue(ven.getVenId());
	hssfRow.createCell(1).setCellValue(ven.getVenCode());
	hssfRow.createCell(2).setCellValue(ven.getVenName());
	hssfRow.createCell(3).setCellValue(ven.getVenType());
	hssfRow.createCell(4).setCellValue(ven.getAddr());
	
	hssfRow.createCell(5).setCellValue(ven.getIdNum());
	hssfRow.createCell(6).setCellValue(ven.getIdType());
	hssfRow.createCell(7).setCellValue(ven.getDsc());
	
	
	
	
}
	}

}
