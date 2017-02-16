package com.saas.pojo;

import java.util.Set;

public class UserTag {
	private int tid;
	private String tag;
	
	private Set<User> user;//一个身份可以有多个用户
	
	public UserTag(){}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
}
