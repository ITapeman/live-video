package com.saas.pojo;

import java.sql.Date;
import java.util.Set;

public class Garden {
	private int gid;
	private String title;
	private String img;//图片或者视频
	private String content;
	private Date date;//发布时间
	private int hits;//个人点击数（用于推送相近类型的信息）
	private int allhits;//所有用户的点击数（用作标签（最多浏览）的搜索）
	private String keyword;//关键词
	private Garden_Category garden_Category; //分类
	private Set<Comment> comments;//评论一对多
	private User send_user;//发布者多对一
	private Set<User> cUsers;//收藏多对多
	
	public Garden(){}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getAllhits() {
		return allhits;
	}

	public void setAllhits(int allhits) {
		this.allhits = allhits;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Garden_Category getGarden_Category() {
		return garden_Category;
	}

	public void setGarden_Category(Garden_Category garden_Category) {
		this.garden_Category = garden_Category;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public User getSend_user() {
		return send_user;
	}

	public void setSend_user(User send_user) {
		this.send_user = send_user;
	}

	public Set<User> getcUsers() {
		return cUsers;
	}

	public void setcUsers(Set<User> cUsers) {
		this.cUsers = cUsers;
	}
	
}
