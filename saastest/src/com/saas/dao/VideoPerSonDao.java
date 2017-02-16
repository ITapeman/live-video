package com.saas.dao;

import com.saas.dao.base.BaseDAO;
import com.saas.pojo.VideoPerSon;

public interface VideoPerSonDao extends BaseDAO<VideoPerSon>{
	VideoPerSon getStreambyname(String name);
	
	VideoPerSon getInfoByStreamName(String streamName);
}
