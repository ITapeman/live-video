package com.saas.biz.impl;

import java.util.List;

import com.saas.biz.UserTagBiz;
import com.saas.dao.UserTagDao;
import com.saas.pojo.UserTag;

public class UserTagBizImpl implements UserTagBiz{
	private UserTagDao userTagDao;
		
	public void setUserTagDao(UserTagDao userTagDao) {
		this.userTagDao = userTagDao;
	}

	@Override
	public List<UserTag> getUserTagList() {
		return userTagDao.getAll();
	}

	@Override
	public UserTag geUserTag(int utid) {
		return userTagDao.get(utid);
	}

}
