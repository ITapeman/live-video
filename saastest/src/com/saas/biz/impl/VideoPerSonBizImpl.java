package com.saas.biz.impl;

import java.util.List;

import com.saas.biz.VideoPerSonBiz;
import com.saas.dao.VideoPerSonDao;
import com.saas.pojo.VideoPerSon;

public class VideoPerSonBizImpl implements VideoPerSonBiz{
	private VideoPerSonDao videoPerSonDao;
	
	public void setVideoPerSonDao(VideoPerSonDao videoPerSonDao) {
		this.videoPerSonDao = videoPerSonDao;
	}

	@Override
	public VideoPerSon getStreamByname(String name) {
		VideoPerSon videoPerSon = videoPerSonDao.getStreambyname(name);
		return videoPerSon != null ? videoPerSon : null;
	}

	@Override
	public void addInfo(VideoPerSon videoPerSon) {
		videoPerSonDao.save(videoPerSon);
	}

	@Override
	public void update(VideoPerSon videoPerSon) {
		videoPerSonDao.update(videoPerSon);
	}

	@Override
	public List<VideoPerSon> getallInfo() {
		return videoPerSonDao.getAll();
	}

	@Override
	public VideoPerSon getInfoBySname(String sname) {
		return videoPerSonDao.getInfoByStreamName(sname);
	}
	
}
