package com.saas.pojo;

import java.util.Set;

public class User {
	private int uid;
	private String uname;
	private String pwd;
	private String telphone;
	private String headicon;
	
	private UserTag userTag;//一个账号仅有一个身份
	private Set<Garden> send_garden;//发布园区信息 一对多关系
	private Set<Garden> cgarden;//用于收藏 多对多关系
	private Set<Comment> comment;//园区评论

	public User(){}

	public User(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getHeadicon() {
		return headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}

	public UserTag getUserTag() {
		return userTag;
	}

	public void setUserTag(UserTag userTag) {
		this.userTag = userTag;
	}

	public Set<Garden> getSend_garden() {
		return send_garden;
	}

	public void setSend_garden(Set<Garden> send_garden) {
		this.send_garden = send_garden;
	}

	public Set<Garden> getCgarden() {
		return cgarden;
	}

	public void setCgarden(Set<Garden> cgarden) {
		this.cgarden = cgarden;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	
}
