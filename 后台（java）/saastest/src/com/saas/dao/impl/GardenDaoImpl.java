package com.saas.dao.impl;

import java.util.List;

import com.puppycrawl.tools.checkstyle.grammars.GeneratedJava14Lexer;
import com.saas.dao.GardenDao;
import com.saas.dao.base.BaseDAOImpl;
import com.saas.pojo.Garden;

public class GardenDaoImpl extends BaseDAOImpl<Garden> implements GardenDao{

	@Override
	public List<Garden> getGardenBytimeASC() {
		String hql = "from Garden order by date DESC";
		List<Garden> gardens1 = getHibernateTemplate().find(hql);
		return gardens1;
	}

	@Override
	public List<Garden> getGardenByhitsASC() {
		String hql = "from Garden order by allhits DESC";
		List<Garden> gardens2 = getHibernateTemplate().find(hql);
		return gardens2;
	}
	
	//按照降序把该用户的点击量相同分类的相加，得到他喜欢的总的排行。
	@Override
	public List getGardenBymyhitmore() {
		String hql = "select garden.garden_Category.cateid ,sum(allhits) from Garden garden group by garden.garden_Category.cateid"; 
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<Garden> getGardenListByCid(int cid) {
		String hql = "from Garden garden where garden.garden_Category.gcid=?";
		Object param = cid;
		List<Garden> gardens = getHibernateTemplate().find(hql, cid);
		return gardens;
	}

	@Override
	public List<Garden> getGardenListBySearch(String ltitle) {
		String hql = "from Garden as garden where garden.title like '%"+ltitle+"%'";
		List<Garden> gardens = getHibernateTemplate().find(hql);
		return gardens;
	}

	@Override
	public List<Garden> getGardenListBykeyword(String keyword) {
		String hql = "from Garden as garden where garden.keyword = ? ";
		Object param = keyword;
		List<Garden> gardens = getHibernateTemplate().find(hql, param);
		return gardens;
	}

	
}
