package com.app.Provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.Iservice.ICustomerService;
import com.app.Iservice.IOrderService;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/order")
public class OrderServiceProvider {
	//private static final String orderJsoon = null;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private ICustomerService customerServie;
	@Autowired
	private CustomerValidator custValidator;

	@Path("/saveOrder")
	@POST
	public String saveOrder(@HeaderParam("user") String email, String orderJson) {
		if(email==null && "".equals(email.trim())){
			return "Invalid username provided";
			
		}
		if(orderJson==null && "".equals(orderJson.trim())){
			return "Empty order detail(Json) provided";
		}
		// read customer based on emailId
		Customer cust = customerServie.getCustomerByEmail(email);
		if (cust == null) {
			return "User not exit in application";
		}
		// isType consumer
		if (!custValidator.isCustTypeConsumer(cust)) {
			return "Customer cannot this opearation(has no authority)";
		}
		// convert json object, order save process
		Object ob = jsonUtil.convertjJsonToObject(orderJson, Order.class);
		if (ob == null) {
			return "invalid order-json is provided";
		}
		// if valid continue
		Order ord = null;
		if (ob instanceof Order) {
			ord = (Order) ob;
		}
		// set custId to order(custId)
		ord.setCost(cust.getCustId());
		int ordId=orderService.saveOrder(ord);
		return "Order save successfully "+ordId;
	}
}
