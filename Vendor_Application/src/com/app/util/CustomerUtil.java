package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.Iservice.ILocationservice;
@Component
public class CustomerUtil {
	@Autowired
	private ILocationservice service;
	
	public List<String> getcustType(){
		return Arrays.asList("SELLER","CONSUMER");
	}
	public void addUiComponents(ModelMap map) {
		map.addAttribute("custTypesUi", getcustType());
		map.addAttribute("locsUi",service.getAllLocation());
	}
public void generatePie(String path,List<Object[]> data){
		
		//1. dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//2. JFreeCharts
		JFreeChart chart=ChartFactory.createPieChart3D("LOCATION WISE CUSTOMER", dataset, true, true, false);
		//3. Image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/custReportA.jpg"), chart, 500, 500);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	public void generateBar(String path,List<Object[]> data){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] obs:data){
			dataset.setValue(new Double(obs[1].toString()),obs[0].toString(),"");
		}
		//JFreeChart chart=ChartFactory.createBarChart3D("VENDOR REPORT", "VENDOR TYPE","COUNT",dataset);
		JFreeChart chart=ChartFactory.createBarChart3D("LOCATION WISE CUSTOMER", "CUSTOMER TYPE", "COUNT", dataset);
		
		try{
			ChartUtilities.saveChartAsJPEG(new File(path+"/custReportB.jpg"),chart,500,500);
		}catch(Exception e){
			System.out.println(e);
		}
			
	}

}
