package com.jokerdemo.service;

import java.io.Serializable;
import java.util.List;

import com.jokerdemo.crm.domain.Association;



public interface AssociationService {
	public List<Association> findByNameQuery(String queryName,Serializable username);
	boolean save(Association association);
}
