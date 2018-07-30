package com.app.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.Idao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUser(User u) {
		return (Integer)ht.save(u);
	}

	@Override
	public User getUserByNameAndPwd(String un, String pwd) {
		User user=null;
		String hql=" from  " + User.class.getName()
				+ " where (userEmail=? or userContact=?) "
				+ " and userPwd=?";
		List<User> userList=ht.find(hql, un,un,pwd);
		if(userList!=null && userList.size()>0){
			user=userList.get(0);
		}
		return user;
	}

}
