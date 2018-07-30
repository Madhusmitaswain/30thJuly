package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocationExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> map,
			HSSFWorkbook book, 
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		//0.file name
		res.addHeader("Content-Disposition", "attachment;filename=Location.xls");
		//1.read data from modelmap
		List<Location> locs=(List<Location>)map.get("locs");
		//2.create sheet
		HSSFSheet hssfSheet=book.createSheet("loc");
		//3.const Header
		setHead(hssfSheet);
		//4.const body
		setBody(hssfSheet,locs);
	
	}

	private void setHead(HSSFSheet hssfSheet) {
HSSFRow hssfRow=hssfSheet.createRow(0);
hssfRow.createCell(0).setCellValue("ID");
hssfRow.createCell(1).setCellValue("NAME");
hssfRow.createCell(2).setCellValue("TYPE");
hssfRow.createCell(3).setCellValue("CODE");
hssfRow.createCell(4).setCellValue("NOTE");

	}

	private void setBody(HSSFSheet hssfSheet, List<Location> locs) {
int rowNum=1;
for(Location loc:locs){
	HSSFRow hssfRow=hssfSheet.createRow(rowNum++);
	hssfRow.createCell(0).setCellValue(loc.getLocId());
	hssfRow.createCell(1).setCellValue(loc.getLocType());
	hssfRow.createCell(2).setCellValue(loc.getLocName());
	hssfRow.createCell(3).setCellValue(loc.getLocCode());
	hssfRow.createCell(4).setCellValue(loc.getLocDsc());
	
	
	
}
	}

}
