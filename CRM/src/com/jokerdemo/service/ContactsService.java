package com.jokerdemo.service;

import java.io.Serializable;
import java.util.List;


import com.jokerdemo.crm.domain.Contacts;

public interface ContactsService {
	

	public List<Contacts> findByNameQuery(String queryName,Serializable username);
	List<Contacts> gind(String id);
	boolean add(Contacts contacts);
	Contacts get(Serializable id);
	boolean updata(Contacts contacts);

}
