package com.saas.hibernate.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListUtil {
	
	private static ListUtil instance = null ;
	private ListUtil(){}
	
	static{
		if(instance==null){
			instance = new ListUtil();
		}
	}
	
	public static ListUtil getInstance(){
		return instance;
	}
	
	public List setToList(Set set){
		List list = new ArrayList(set.size());
		for(Object obj : set){
			list.add(obj);
		}
		return list ;
	}
}
