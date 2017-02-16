package com.saas.dao.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {
	
	void save(T t) ;
	void del(T t) ;
	void update(T t);
	T get(Serializable id) ;
	List<T> getAll();

}