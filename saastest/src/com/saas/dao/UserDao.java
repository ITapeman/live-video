package com.saas.dao;

import com.saas.dao.base.BaseDAO;
import com.saas.pojo.User;



public interface UserDao extends BaseDAO<User>{
	
	
	User getUser(String uname , String pwd );

	/*User register(User user);*/
}
