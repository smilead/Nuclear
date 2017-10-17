package com.jokerdemo.service;

import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.po.PageModel;

public interface CustomerService {
	boolean update(Customer customer);
	Customer findById(String cuostomerid);
	PageModel<Customer> findByPage(String searchCustomerId, String searchCustomerName, int currentPage, int pageSize);
}
