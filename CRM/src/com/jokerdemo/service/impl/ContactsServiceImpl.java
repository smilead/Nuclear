package com.jokerdemo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.ContactsDao;
import com.jokerdemo.crm.domain.Contacts;
import com.jokerdemo.service.ContactsService;

public class ContactsServiceImpl implements ContactsService {
	private ContactsDao contactsDao;
	private HibernateTransactionManager tx;
	public void setContactsDao(ContactsDao contactsDao) {
		this.contactsDao = contactsDao;
	}
	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	
	@Override
	public List<Contacts> gind(String id) {
		// TODO Auto-generated method stub
		return contactsDao.findal(id);
	}
	@Override
	public List<Contacts> findByNameQuery(String queryName,
			Serializable username) {
		// TODO Auto-generated method stub
		return contactsDao.findByNameQuery(queryName, username);
	}
	@Override
	public boolean add(Contacts contacts) {
		// TODO Auto-generated method stub
		return contactsDao.add(contacts);
	}
	@Override
	public Contacts get(Serializable id) {
		// TODO Auto-generated method stub
		return contactsDao.get(id);
	}
	@Override
	public boolean updata(Contacts contacts) {
		// TODO Auto-generated method stub
		return contactsDao.update(contacts);
	}

}
