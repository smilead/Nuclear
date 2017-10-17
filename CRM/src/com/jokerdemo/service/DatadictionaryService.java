package com.jokerdemo.service;

import java.util.List;

import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.po.PageModel;

public interface DatadictionaryService {
	List<Datadictionary> findByType(String type);
	Datadictionary findById(int ddid);
	PageModel<Datadictionary> findByPage(String searchDType, String searchDName, int currentPage, int pageSize);
}
