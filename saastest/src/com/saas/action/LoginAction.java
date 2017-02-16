package com.saas.action;

import com.saas.biz.UserBiz;
import com.saas.pojo.User;

public class LoginAction {
	private UserBiz userBiz;
	private String lname;
	private String lpwd;
	
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setLpwd(String lpwd) {
		this.lpwd = lpwd;
	}


	public String loginin(){
		User user = userBiz.login(lname, lpwd);
		
		if(user != null){
			return "success";
		}
		
		return "fail";
	}
}
