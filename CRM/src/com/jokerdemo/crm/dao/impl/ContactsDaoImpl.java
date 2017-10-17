package com.jokerdemo.crm.dao.impl;

import java.io.Serializable;
import java.util.List;


import com.jokerdemo.crm.dao.ContactsDao;
import com.jokerdemo.crm.domain.Contacts;
import com.jokerdemo.crm.domain.User;

public class ContactsDaoImpl extends BaseDaoImpl<Contacts> implements ContactsDao {

	

	@Override
	public List<Contacts> findal(String id) {
		// TODO Auto-generated method stub
		List<Contacts> users =  (List<Contacts>) this.getHibernateTemplate().find("from Contacts where customerid='"+id+"' ");
		System.out.println(users.size()+"56555");
		return users;
	}

	@Override
	public List<Contacts> findByNameQuery(String queryName,
			Serializable username) {
		// TODO Auto-generated method stub
		return (List<Contacts>) this.getHibernateTemplate().findByNamedQuery(queryName,username);
	}

}
