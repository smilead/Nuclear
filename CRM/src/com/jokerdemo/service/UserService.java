package com.jokerdemo.service;

import java.util.List;

import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;

public interface UserService {
	User login(String username, String password);
	List<User> find(Integer jobno);
	User findById(int userid);
	PageModel<User> findByPage(String searchCustomerId, String searchCustomerName, int currentPage, int pageSize);
}
