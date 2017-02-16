package com.saas.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {
	
	private Class<T> entityClass ;

	@SuppressWarnings("unchecked")
	public BaseDAOImpl(){
		try{
			Type[] typeArr = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
			if(typeArr!=null && typeArr.length>0){
				entityClass = (Class<T>) typeArr[0];
			}
		}catch(Exception ex){
			throw new RuntimeException("没有给T指定类型");
		}
	}
	
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	public void del(T t) {
		getHibernateTemplate().delete(t);
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

}