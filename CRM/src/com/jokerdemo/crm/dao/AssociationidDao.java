package com.jokerdemo.crm.dao;

import java.io.Serializable;
import java.util.List;

import com.jokerdemo.crm.domain.Association;


public interface AssociationidDao extends BaseDao<Association> {
	public List<Association> findByNameQuery(String queryName,Serializable username);
}
