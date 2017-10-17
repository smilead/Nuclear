package com.jokerdemo.service;

import com.jokerdemo.crm.domain.Job;
import com.jokerdemo.crm.po.PageModel;

public interface JobService {
	PageModel<Job> findByPage(String searchCustomerId, String searchCustomerName, int currentPage, int pageSize);
}
