package com.jokerdemo.crm.dao;

import java.io.Serializable;
import java.util.List;


import com.jokerdemo.crm.domain.Contacts;

public interface ContactsDao extends BaseDao<Contacts> {
	public List<Contacts> findByNameQuery(String queryName,Serializable username);
	List<Contacts> findal(String id);

}
