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

import com.app.Iservice.ICustomerService;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.Order;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.util.CustomerUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerUtil util;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CoDecUtil coDecUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//Show Reg Page
	@RequestMapping("/regcust")
	public String showreg(ModelMap map){
		 util.addUiComponents(map);
		return "CustomerReg";
		
	}
	@RequestMapping(value="/insertcust",method = RequestMethod.POST)
	public String saveCust(
			@ModelAttribute("CUSTOMER")Customer cust,ModelMap map){
		
		String msg=null;
	         //GENERATE PASSWORD AND TOCKEN
			String tkn=codeUtil.genTocken();//45df
		
			String pwd=codeUtil.genPwd();
			//do encode
			String encTKn=coDecUtil.doEncode(tkn);
			String encpwd=coDecUtil.doEncode(pwd);
			//set in customer
			cust.setCustaccTock(encTKn);
			cust.setPassword(encpwd);
			int cusId=service.saveCustomer(cust);
			//TODO:email coding
			String txt="Thank you for registration your id is "+cust.getCustId()+" you user name is "+cust.getCustEmail()+" your password is "+pwd+" "+" your token is "+tkn;
			boolean flag=commonUtil.sendEmail(cust.getCustEmail(), "Registration success",txt );
			System.out.println(txt);
			if(flag){
				msg="Email also send ";
			}
			msg+="Registred with Id:"+cusId;
			map.addAttribute("message",msg);
			return "CustomerReg";
			
	}
	@RequestMapping("/viewAllCustomer")
	public String getAllRows(ModelMap map) {
		//all data retraive
		List<Customer> custList = service.getAllCustomer();
		//for(Customer cust:custList){
			
			//System.out.println(coDecUtil.doCode(cust.getCustaccTock()));
			//cust.setCustaccTock(coDecUtil.doCode(cust.getCustaccTock()));
			
		//}
		map.addAttribute("cust", custList);
		return "CustomerData";
	}
	@RequestMapping("/deleteCustomer")
	public String deleteobj(@RequestParam("custId") int cid) {
		service.deleteCustomer(cid);
		return "redirect:viewAllCustomer";

	}
	@RequestMapping("/editCustomer")
	public String showEdit(
			@RequestParam("custId") int cID,ModelMap map) {
		Customer customer=service.getCustomerById(cID);
		map.addAttribute("cID",customer);
		
		util.addUiComponents(map);
		return "CustomerDataEdit";

	}
	@RequestMapping(value="/updatecustomer",method=RequestMethod.POST)
	public String updateData(@ModelAttribute("customer")Customer cust)
	{
		
		service.updateCustomer(cust);
		return "redirect:viewAllCustomer";
	}
	@RequestMapping("/custExcelExport")
	public String exportToExcel(ModelMap map)
	{
		
		map.addAttribute("custs",service.getAllCustomer());
		return "CustomerExcel";
	}
	@RequestMapping("/custPdfExport")
	public String exportPdf(ModelMap map)
	{
		
		map.addAttribute("custs",service.getAllCustomer());
		return "CustomerPdf";
	}
	@RequestMapping("/customerReports")
	public String showVenCharts() {
		String path = context.getRealPath("/");
		List<Object[]> data = service.getCustomerTypeAndCount();
		util.generatePie(path,data);
		util.generateBar(path,data);
		return "CustomerReports";

	}

	/**
	 * 9. Vendor Data in PIE/BAR charts
	 */
	@RequestMapping("/custLocReports")
	public String showCharts(){
		String path=context.getRealPath("/");
		List<Object[]> data=service.getcusCountByLocName();
		util.generatePie(path,data);
		util.generateBar(path,data);
		return "CustomerLocationReport";
		
	}
	@RequestMapping("/getCustItems")
	public String showItems(@RequestParam("custId") int custId, ModelMap map) {
		List<Item> listItem = service.getCustSellerItems(custId);
		map.addAttribute("listItem", listItem);
		return "CustomerItem";
	}
	@RequestMapping("/getCustOrders")
	public String showOrder(@RequestParam("custId") int custId, ModelMap map) {
		List<Order> listOrder = service.getCustOrderByCustId(custId);
		map.addAttribute("listOrder", listOrder);
		return "CustomerOrder";
	}
	
		
	}


