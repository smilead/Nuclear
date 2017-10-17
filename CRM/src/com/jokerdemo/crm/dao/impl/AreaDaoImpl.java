package com.jokerdemo.crm.dao.impl;

import java.util.List;

import com.jokerdemo.crm.dao.AreaDao;
import com.jokerdemo.crm.domain.Area;

public class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDao{

	@Override
	public List<Area> findArea(int pid) {
		List<Area> areas = (List<Area>) this.getHibernateTemplate().find("from Area where pid="+pid);
		return areas;
	}
	
}
