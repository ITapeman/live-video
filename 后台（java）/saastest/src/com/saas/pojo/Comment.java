package com.saas.pojo;

import java.sql.Date;

public class Comment {
	private int cid;
	private String matters;//评论内容
	private Date cDate;//评论时间
	private User cUser;//评论人
	
	private Garden garden;//一条评论只对应一个园区的信息
	
	public Comment(){}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getMatters() {
		return matters;
	}

	public void setMatters(String matters) {
		this.matters = matters;
	}

	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public User getcUser() {
		return cUser;
	}
	public void setcUser(User cUser) {
		this.cUser = cUser;
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}
	
	
}
