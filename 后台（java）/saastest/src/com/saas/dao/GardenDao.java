package com.saas.dao;

import java.util.List;

import com.saas.dao.base.BaseDAO;
import com.saas.pojo.Garden;


public interface GardenDao extends BaseDAO<Garden>{
	//按照时间升序获得列表
	List<Garden> getGardenBytimeASC();
	
	//按照点击数量升序来获得列表
	List<Garden> getGardenByhitsASC();
	
	//搜索个人点击数最多的一个分类ID（打印出来看下结果-------------------------------）
	List getGardenBymyhitmore();
	
	//根据分类ID获得对应的garden集合。
	List<Garden> getGardenListByCid(int cid);
	
	//搜索（模糊查询）
	List<Garden> getGardenListBySearch(String ltitle);
	
	//关键字查询
	List<Garden> getGardenListBykeyword(String keyword);
}
