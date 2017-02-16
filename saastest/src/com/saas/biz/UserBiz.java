package com.saas.biz;

import com.saas.pojo.User;

public interface UserBiz {
	
	User login(String uname,String pwd);
	
	void register(User user);

}
