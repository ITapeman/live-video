package com.saas.dao.impl;

import java.util.List;

import com.saas.dao.CommentDao;
import com.saas.dao.base.BaseDAOImpl;
import com.saas.pojo.Comment;

public class CommentDaoImpl extends BaseDAOImpl<Comment> implements CommentDao{

	@Override
	public List<Comment> getCommentBygid(int gid) {
		String hql = "from Comment where ccid=?";
		Object param = gid;
		List<Comment> comments = getHibernateTemplate().find(hql, param);
		return comments;
	}
	
	@Override
	public int getCountComment(int gid) {
		String hql = "select count(*) from Comment comment where comment.cUser.uid = 1 and comment.garden.gid = ? group by comment.garden.gid ";
		Object param = gid;
		List comments = getHibernateTemplate().find(hql,param);
		if(comments.size() == 0){
			return 0;
		}
		System.out.println("----------"+comments);
		Number nu = (Number) comments.get(0);
		return ("".equals(comments)? 0 :nu.intValue()) ;
	}
}
