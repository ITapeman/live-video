package com.saas.biz.impl;

import java.util.List;

import com.saas.biz.CommentBiz;
import com.saas.dao.CommentDao;
import com.saas.pojo.Comment;

public class CommentBizImpl implements CommentBiz{
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getCommentByGid(int gid) {
		commentDao.getCommentBygid(gid);
		return commentDao.getCommentBygid(gid);
	}

	@Override
	public int getCommentNumber(int gid) {
		Number num = (Number)commentDao.getCountComment(gid);
		return num.equals("") ? 0 : num.intValue();
	}
	
}
