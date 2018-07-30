package com.app.Iservice;

import com.app.model.User;

public interface IUserService {

	public int saveUser(User u);
	public User getUserByNameAndPwd(String un,String pwd);
}
