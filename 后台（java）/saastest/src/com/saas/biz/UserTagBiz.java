package com.saas.biz;

import java.util.List;

import com.saas.pojo.UserTag;

public interface UserTagBiz {
	/**
	 * 获得所有的身份名称
	 * @return
	 */
	List<UserTag> getUserTagList();
	/**
	 * 根据Id获得一个身份名称
	 * @param utid 身份ID
	 * @return 一个UserTag对象
	 */
	UserTag geUserTag(int utid);
}
