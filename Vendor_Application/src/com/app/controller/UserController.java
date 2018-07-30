package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Iservice.IUserService;
import com.app.model.User;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class UserController {
	
	private Log log=LogFactory.getLog(UserController.class);
			
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private IUserService service;
	
	//1. show Reg Page
	@RequestMapping("/userReg")
	public String showRegister(){
		log.info("Welcome to User");
		return "UserRegister";
		
	}
	
	//2. save data
	@RequestMapping(value="/userInsert",method=RequestMethod.POST)
	public String saveUser(
			//1. read model attribute
			@ModelAttribute("user")User u,ModelMap map){
		//2. generate password
		String pwd=codeUtil.genPwd();
		//3. set password to model object
		u.setUserPwd(pwd);
		//4. save user
		int userId=service.saveUser(u);
		//5. send email
		String text="welcome to User!! "+
		 ", your id:"+u.getUserEmail()+" (or) "+u.getUserContact()
		 +" , password is : "+u.getUserPwd();
		commonUtil.sendEmail(u.getUserEmail(), "User", text);
		//6. send message to Ui
		map.addAttribute("message", "User '"+userId+"' created ");
		return "UserRegister";
	}

	//3. show user login Page
	@RequestMapping(value="/login")
	public String showLoginPage(){
		return "Login";
	}
	//4. do login
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginUsrChk(
			@RequestParam("userName")String un,
			@RequestParam("password")String pwd,
			ModelMap map,
			HttpServletRequest req
			) {
		
		String page=null;
		
		User user=service.getUserByNameAndPwd(un, pwd);
		if(user==null){
			map.addAttribute("message", "Username/password invalid..!!");
			page="Login";
		}else{
			//create one Session
			HttpSession ses=req.getSession();
			ses.setAttribute("un", user.getUserName());
			page="LocationReg";
		}
		
		return page;
	}
	
	//5. logout process
	@RequestMapping("/logout")
	public String doLogoutUsr(HttpServletRequest req,ModelMap map){
		HttpSession ses=req.getSession(false);
		ses.setAttribute("un", null);
		ses.invalidate();
		map.addAttribute("message", "Logout successful");
		return "Login";
	}
	
}