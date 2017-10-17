package com.jokerdemo.crm.dao;

import java.util.List;

import com.jokerdemo.crm.domain.Chance;
import com.jokerdemo.crm.po.PageModel;

public interface ChanceDao extends BaseDao<Chance>{
	public List<Chance> findAll();
}
