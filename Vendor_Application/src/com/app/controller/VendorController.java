package com.app.controller;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Iservice.IVendorService;
import com.app.model.Vendor;
import com.app.util.LocationUtil;
import com.app.util.VendorUtil;
@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private VendorUtil util;
	@Autowired
	private ServletContext context;

	@RequestMapping("/regven")
	public String getPage(ModelMap map) {

		 util.addUiComponents(map);
		return "VendorReg";
	}

	@RequestMapping(value = "/insertvendor", method = RequestMethod.POST)
	public String saveVen(@ModelAttribute("vendor") Vendor ven, ModelMap map) {
		int venId = service.saveVendor(ven);
		String m = "vendor created:" + venId;
		map.addAttribute("message", m);
		return "VendorReg";
	}

	@RequestMapping("/viewAllvendors")
	public String getAllRows(ModelMap map) {
		List<Vendor> venList = service.getAllVendor();
		map.addAttribute("vens", venList);
		return "VendorData";
	}


	@RequestMapping("/deleteVendor")
	public String deleteobj(@RequestParam("venId") int vid) {
		service.deleteVendor(vid);

		return "redirect:viewAllvendors";

	}
	
	@RequestMapping("/editVendor")
	public String showEdit(
			@RequestParam("venId") int venID ,
			ModelMap map) {
		Vendor vendor=service.getVendorById(venID);
		map.addAttribute("ven",vendor);
		
		util.addUiComponents(map);
		return "VendorDataEdit";

	}
	
	@RequestMapping(value="/updatevendor",method=RequestMethod.POST)
	public String updateData(
			@ModelAttribute("vendor")Vendor ven)
	{
		
		service.updateVendor(ven);
		return "redirect:viewAllvendors";
	}
	
	@RequestMapping("/venExcelExport")
	public String exportToExcel(ModelMap map)
	{
		
		map.addAttribute("vens",service.getAllVendor());
		return "VenExcel";
	}
	@RequestMapping("/venPdfExport")
	public String exportPdf(ModelMap map)
	{
		
		map.addAttribute("vens",service.getAllVendor());
		return "VenPdf";
	}
	@RequestMapping("/vendorReports")
	public String showVenCharts() {
		String path = context.getRealPath("/");
		List<Object[]> data = service.getVendorTypeAndCount();
		util.generatePie(path,data);
		util.generateBar(path,data);
		return "VendorReports";

	}

	/**
	 * 9. Vendor Data in PIE/BAR charts
	 */
	@RequestMapping("/venLocReports")
	public String showCharts(){
		String path=context.getRealPath("/");
		List<Object[]> data=service.getVenCountByLocName();
		util.generatePie(path,data);
		util.generateBar(path,data);
		return "VendorLocationReport";
		
	}
}

