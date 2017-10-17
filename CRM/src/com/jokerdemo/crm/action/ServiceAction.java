package com.jokerdemo.crm.action;


import org.springframework.orm.hibernate3.HibernateTransactionManager;


import com.jokerdemo.crm.dao.CustomerDao;
import com.jokerdemo.crm.domain.Service;
import com.jokerdemo.service.ServiceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ServiceAction extends ActionSupport implements ModelDriven<Service>{
	private Service service=new Service();
	private ServiceService serviceService;
	
	@Override
	public Service getModel() {
		return service;
	}
	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}
       public String add(){
		
		serviceService.addService(service);
		
		return SUCCESS;
	}

}