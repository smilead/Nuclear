package com.jokerdemo.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.jokerdemo.crm.dao.AssociationidDao;
import com.jokerdemo.crm.domain.Association;

public class AssociationDaoImpl extends BaseDaoImpl<Association> implements AssociationidDao {

	@Override
	public List<Association> findByNameQuery(String queryName,
			Serializable username) {
		// TODO Auto-generated method stub
		return (List<Association>) this.getHibernateTemplate().findByNamedQuery(queryName,username);
	}

	

}
