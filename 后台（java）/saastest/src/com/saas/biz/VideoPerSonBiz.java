package com.saas.biz;

import java.util.List;

import com.saas.pojo.VideoPerSon;

public interface VideoPerSonBiz {
	//根据传入的用户来获取该用户的流
	VideoPerSon getStreamByname(String name);
	
	//添加新的流名称
	void addInfo(VideoPerSon videoPerSon);
	
	//更新
	void update(VideoPerSon videoPerSon);
	
	//获取所有信息
	List<VideoPerSon> getallInfo();
	
	//根据流名称获取一整条信息
	VideoPerSon getInfoBySname(String sname);
}
