package com.saas.dao;

import java.util.List;

import com.saas.dao.base.BaseDAO;
import com.saas.pojo.Comment;


public interface CommentDao extends BaseDAO<Comment> {
	
	//根据首页帖子ID获得该ID下的所有评论
	List<Comment> getCommentBygid(int gid);
	
	// 获得 该ID下的所有评论的数量
	int getCountComment(int gid);
}
