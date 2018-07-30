package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Iservice.ILocationservice;
import com.app.model.Location;
import com.app.util.LocationUtil;

import sun.print.resources.serviceui;

@Controller
public class LocationController {

	@Autowired
	private ILocationservice service;
	@Autowired
	private LocationUtil util;
	@Autowired
	private ServletContext context;

	@RequestMapping("/regloc")
	public String getPage() {

		return "LocationReg";
	}

	@RequestMapping(value = "/insertLocation", method = RequestMethod.POST)
	public String saveLoc(@ModelAttribute("location") Location loc, ModelMap map) {
		int locId = service.saveLocation(loc);
		String m = "location created:" + locId;
		map.addAttribute("message", m);
		return "LocationReg";
	}

	@RequestMapping("/viewAllLocs")
	public String getAllRows(ModelMap map) {
		List<Location> locsList = service.getAllLocation();
		map.addAttribute("locs", locsList);
		return "LocationData";
	}

	@RequestMapping("/deleteLoc")
	public String deleteobj(@RequestParam("locId") int lid) {
		service.deleteLocation(lid);

		return "redirect:viewAllLocs";

	}

	@RequestMapping("/editLoc")
	public String showEdit(@RequestParam("locId") int locID, ModelMap map) {
		Location location = service.getLocationById(locID);
		map.addAttribute("loc", location);
		return "LocationDataEdit";

	}

	@RequestMapping(value = "/updateLoc", method = RequestMethod.POST)
	public String updateData(@ModelAttribute("location") Location loc) {

		service.updateLocation(loc);
		return "redirect:viewAllLocs";
	}

	@RequestMapping("/locExcelExport")
	public String exportToExcel(ModelMap map) {

		map.addAttribute("locs", service.getAllLocation());
		return "LOCExcel";
	}

	@RequestMapping("/locPdfExport")
	public String exportPdf(ModelMap map) {

		map.addAttribute("locs", service.getAllLocation());
		return "LOCPdf";
	}

	@RequestMapping("/locReports")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> data = service.getLocationTypeAndCount();
		util.createPie(data, path);
		util.createBar(data, path);
		return "locationReport";

	}

}
