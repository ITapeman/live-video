package com.saas.biz;

import java.util.List;

import com.saas.pojo.Garden;

public interface GardenBiz {
	/**
	 * 默认情况下按自己点击多的类型进行推荐
	 * @return 自己点击多的类型的帖子
	 */
	List<Garden> getGardenByMyHits();
	
	/**
	 * 获得所有的园区帖子
	 * @return 所有的园区帖子
	 */
	List<Garden> getGardenList();
	
	/**
	 * 通过最近时间获得所有帖子。
	 * @return 较近时间的所有帖子
	 */
	List<Garden> getGardenByTime();
	
	/**
	 * 通过点击数来获得帖子。
	 * @return 点击数较高的帖子。
	 */
	List<Garden> getGardenByHits();
	
	/**
	 * 发布新的内容。
	 * @param garden 一个对象
	 */
	void issueGarden(Garden garden);
	
	/**
	 * 根据分类活得园区的首页帖子
	 * @param typeid 分类的ID
	 * @return 某个分类的所有帖子
	 */
	List<Garden> getGardenByType(int typeid);
	
	/**
	 * 根据title进行模糊查询
	 * @param liketitle
	 * @return 模糊查询的结果
	 */
	List<Garden> getGardenBySearch(String liketitle);
	
	/**
	 * 根据关键字搜索
	 * @param keyword
	 * @return 返回根据关键字搜索到的内容
	 */
	List<Garden> getGardenByKeyword(String keyword);
}
