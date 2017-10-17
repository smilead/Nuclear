package com.jokerdemo.crm.dao;

import java.util.List;

import com.jokerdemo.crm.domain.Area;

public interface AreaDao extends BaseDao<Area>{
	List<Area> findArea(int pid);
}
