package com.saas.biz.impl;

import java.util.List;

import com.saas.biz.GardenBiz;
import com.saas.dao.GardenDao;
import com.saas.pojo.Garden;

public class GardenBizImpl implements GardenBiz {

	private GardenDao gardenDao;
	
	public void setGardenDao(GardenDao gardenDao) {
		this.gardenDao = gardenDao;
	}
	
	/**
	 * 按照点击多的多推荐
	 */
	@Override
	public List<Garden> getGardenByMyHits() {
		List hitnum = gardenDao.getGardenBymyhitmore();
		for(int i = 0; i<hitnum.size();i++){
			System.out.println(hitnum);
		}
		return null;
	}

	@Override
	public List<Garden> getGardenList() {
		return gardenDao.getAll();
	}

	@Override
	public List<Garden> getGardenByTime() {
		return gardenDao.getGardenBytimeASC();
	}

	@Override
	public List<Garden> getGardenByHits() {
		return gardenDao.getGardenByhitsASC();
	}

	@Override
	public void issueGarden(Garden garden) {
		gardenDao.save(garden);
	}

	@Override
	public List<Garden> getGardenByType(int typeid) {
		return gardenDao.getGardenListByCid(typeid);
	}

	@Override
	public List<Garden> getGardenBySearch(String liketitle) {
		return gardenDao.getGardenListBySearch(liketitle);
	}

	@Override
	public List<Garden> getGardenByKeyword(String keyword) {
		return gardenDao.getGardenListBykeyword(keyword);
	}

}
