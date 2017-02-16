package com.saas.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.saas.biz.CommentBiz;
import com.saas.biz.GardenBiz;
import com.saas.pojo.Garden;

public class IndexAction {
	private GardenBiz gardenBiz;
	private CommentBiz commentBiz;
	private int typeid;
	private String searchgarden;
	
	
	public void setGardenBiz(GardenBiz gardenBiz) {
		this.gardenBiz = gardenBiz;
	}

	public void setCommentBiz(CommentBiz commentBiz) {
		this.commentBiz = commentBiz;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public void setSearchgarden(String searchgarden) {
		this.searchgarden = searchgarden;
	}

	public String gardeninfo(){
		
		Map<Integer, Integer> comnumber = new HashMap<Integer, Integer>();
		//获得所有园区的帖子
		List<Garden> gardenList = gardenBiz.getGardenList();
		//遍历该帖子 ，用每个ID获取到他的回复总数，以key-value形式保存到MAP中，并存放进session。
		for(Garden gd:gardenList){
			gd.getSend_user().getUname();
			System.out.println("----indexAction"+gd.getGid());
			int cnumber = commentBiz.getCommentNumber(gd.getGid());
			 comnumber.put(gd.getGid(), cnumber);
		}
		ActionContext.getContext().getSession().put("cnum", comnumber);
		ActionContext.getContext().getSession().put("gardenList", gardenList);
		return "success";
	}
	public String gardenTime(){
		//根据时间远近获得帖子
		List<Garden> gardenListBytime = gardenBiz.getGardenByTime();
		//解决懒加载问题
		for(Garden gd:gardenListBytime){
			gd.getSend_user().getUname();
		}
		ActionContext.getContext().getSession().put("gardenList", gardenListBytime);
		return "success";
	}
	
	public String gardenhits(){
		//根据点击数获得帖子
		List<Garden> gardenListByhits = gardenBiz.getGardenByHits();
		//解决懒加载问题
		for(Garden gd:gardenListByhits){
			gd.getSend_user().getUname();
		}
		ActionContext.getContext().getSession().put("gardenList", gardenListByhits);
		return "success";
	}
	
	//根据园区类型获得帖子
	public String gardenBytype(){
		List<Garden> gardens = gardenBiz.getGardenByType(typeid);
		//解决懒加载问题
		for(Garden gd:gardens){
			gd.getSend_user().getUname();
		}
		ActionContext.getContext().getSession().put("gardenList", gardens);
		return "success";
	}
	
	//根据题目模糊查询
	public String searchtitle(){
		List<Garden> gardens2 = gardenBiz.getGardenBySearch(searchgarden);
		//解决懒加载问题
		for(Garden gd:gardens2){
			gd.getSend_user().getUname();
		}
		ActionContext.getContext().getSession().put("gardenList", gardens2);
		return "success";
	}
	//根据关键字查询
	public String searchkeyword(){
		List<Garden> gardens = gardenBiz.getGardenByKeyword(searchgarden);
		for(Garden gd:gardens){
			gd.getSend_user().getUname();
		}
		ActionContext.getContext().getSession().put("gardenList", gardens);
		return "success";
	}
}
