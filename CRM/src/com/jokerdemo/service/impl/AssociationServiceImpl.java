package com.jokerdemo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.AssociationidDao;
import com.jokerdemo.crm.domain.Association;
import com.jokerdemo.service.AssociationService;

public class AssociationServiceImpl implements AssociationService {
	private HibernateTransactionManager tx;
	private AssociationidDao associationidDao;
	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setAssociationidDao(AssociationidDao associationidDao) {
		this.associationidDao = associationidDao;
	}
	@Override
	public List<Association> findByNameQuery(String queryName,
			Serializable username) {
		// TODO Auto-generated method stub
		return associationidDao.findByNameQuery(queryName, username);
	}
	@Override
	public boolean save(Association association) {
		// TODO Auto-generated method stub
		return associationidDao.add(association);
	}

}
