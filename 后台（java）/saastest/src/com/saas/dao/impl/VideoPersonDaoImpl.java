package com.saas.dao.impl;

import java.util.List;

import com.saas.dao.VideoPerSonDao;
import com.saas.dao.base.BaseDAOImpl;
import com.saas.pojo.VideoPerSon;

public class VideoPersonDaoImpl extends BaseDAOImpl<VideoPerSon> implements VideoPerSonDao{

	@Override
	public VideoPerSon getStreambyname(String name) {
		String hql = "from VideoPerSon vperson where vperson.personname = ?";
		Object param = name;
		List<VideoPerSon> videoPerSons = null;
		try {
			videoPerSons = getHibernateTemplate().find(hql, param);
			System.out.println("--------"+videoPerSons.size());
		} catch (Exception e) {
		}
		return videoPerSons.size() != 0 ? videoPerSons.get(0) : null;
	}

	@Override
	public VideoPerSon getInfoByStreamName(String streamName) {
		String hql = "from VideoPerSon vperson where vperson.streamname = ?";
		Object param = streamName;
		List<VideoPerSon> videoPerSons = null;
		try {
			videoPerSons = getHibernateTemplate().find(hql, param);
			System.out.println("--------"+videoPerSons.size());
		} catch (Exception e) {
		}
		return videoPerSons.size() != 0 ? videoPerSons.get(0) : null;
	}
}
