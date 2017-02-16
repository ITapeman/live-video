package com.saas.biz.impl;

import com.saas.biz.UserBiz;
import com.saas.dao.UserDao;
import com.saas.pojo.User;


public class UserBizImpl implements UserBiz{
	
	private UserDao userDao ;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public User login(String uname,String pwd){
		return userDao.getUser(uname, pwd);
	}


	@Override
	public void register(User user) {
		userDao.save(user);
	}

}
