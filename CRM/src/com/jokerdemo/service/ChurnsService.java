package com.jokerdemo.service;

import com.jokerdemo.crm.domain.Churns;
import com.jokerdemo.crm.po.PageModel;

public interface ChurnsService {
	boolean update(Churns churns);
	Churns findById(Integer churnsid);
	PageModel<Churns> findByPage(String searchCustomerId, String searchCustomerName, int currentPage, int pageSize);
}
