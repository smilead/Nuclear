package com.jokerdemo.service;

import java.util.List;

import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.domain.Product;
import com.jokerdemo.crm.po.PageModel;

public interface ProService{
	List<Product> findByType(String type);
	PageModel<Product> findByPage(String searchPType, String searchPName, int currentPage, int pageSize);
}
