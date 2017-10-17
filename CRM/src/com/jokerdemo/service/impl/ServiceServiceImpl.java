package com.jokerdemo.service.impl;

import com.jokerdemo.crm.dao.ServiceDao;
import com.jokerdemo.crm.domain.Service;
import com.jokerdemo.service.ServiceService;


public class ServiceServiceImpl implements ServiceService {
 private ServiceDao serviceDao;
	@Override
	public String addService(Service service) {
		// TODO Auto-generated method stub
		serviceDao.add(service);
		return "success";
	}
	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

}
