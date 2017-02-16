package com.saas.biz;

import java.util.List;

import com.saas.pojo.Comment;

public interface CommentBiz {
	/**
	 * 通过每个帖子的ID获取他下面的所有评论
	 * @return 此ID下面的所有评论
	 */
	List<Comment> getCommentByGid(int gid);
	
	int getCommentNumber(int gid);
}
