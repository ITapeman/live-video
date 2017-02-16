package com.saas.dao.impl;

import java.util.List;

import com.saas.dao.UserDao;
import com.saas.dao.base.BaseDAOImpl;
import com.saas.pojo.User;

public class UserDaoImpl extends BaseDAOImpl<User> implements UserDao{

	public User getUser(String uname, String pwd) {
		String hql = "from User where uname = ? and pwd = ? " ;
		Object[] params = {uname , pwd };
		List<User> userList = getHibernateTemplate().find(hql, params);
		return userList!=null && userList.size()>0 ? userList.get(0) : null ;
	}
}
