package com.jokerdemo.service;

import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Ware;
import com.jokerdemo.crm.po.PageModel;

public interface WareService {
	PageModel<Ware> findByPage(String searchWId, String searchWSt, int currentPage, int pageSize);

}
