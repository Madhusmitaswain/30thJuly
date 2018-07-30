package com.app.util;
import java.io.File;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class LocationUtil {
	public void createPie(List<Object[]> data,String path){
		//1. data set
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] obs:data){
			dataset.setValue(obs[0].toString(), new Double(obs[1].toString()));
		}
		//2. JFreeChart obj
		JFreeChart chart=ChartFactory.createPieChart3D("LOCATION TYPE WISE REPORT", dataset, true, true, false);
		//3. save as Image 
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportLocA.jpg"), chart, 500, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void createBar(List<Object[]> data,String path){
		//1. data set
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] obs:data){
			dataset.setValue(new Double(obs[1].toString()), obs[0].toString(), "");
		}
		//2. JFreeChart obj
		JFreeChart chart=ChartFactory.createBarChart3D("LOCATION TYPE WISE REPORT", "LOCATION TYPE", "COUNT", dataset);
		//3. save as Image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportLocB.jpg"), chart, 500, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
