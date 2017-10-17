package com.jokerdemo.crm.dao.impl;

import java.util.List;

import com.jokerdemo.crm.dao.ChanceDao;
import com.jokerdemo.crm.domain.Chance;

public class ChanceDaoImpl extends BaseDaoImpl<Chance> implements ChanceDao{

	@Override
	public List<Chance> findAll() {
		// TODO Auto-generated method stub
		List<Chance> find = (List<Chance>)this.find();
		return find;
	}
}
