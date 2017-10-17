package com.jokerdemo.crm.action;



import java.util.List;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.dao.CustomerDao;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.AreaService;
import com.jokerdemo.service.CustomerService;
import com.jokerdemo.service.DatadictionaryService;
import com.jokerdemo.service.UserService;
import com.jokerdemo.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer();
	private CustomerService cs;
	private String searchCustomerId;
	private String searchCustomerName;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<Customer> pageModel;
	private static ApplicationContext application;
	static {
			application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public PageModel<Customer> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Customer> pageModel) {
		this.pageModel = pageModel;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getSearchCustomerId() {
		return searchCustomerId;
	}
	public void setSearchCustomerId(String searchCustomerId) {
		this.searchCustomerId = searchCustomerId;
	}
	public String getSearchCustomerName() {
		return searchCustomerName;
	}
	public void setSearchCustomerName(String searchCustomerName) {
		this.searchCustomerName = searchCustomerName;
	}
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	public String findCustomers() {
		if("".equals(searchCustomerId)) searchCustomerId=null;
		if("".equals(searchCustomerName)) searchCustomerName=null;
		System.out.println(searchCustomerId+searchCustomerName+currentPage+pageSize);
		this.pageModel = this.cs.findByPage(searchCustomerId, searchCustomerName, currentPage, pageSize);
		
		return SUCCESS;
		
	}
	public String showInfo() {
		Customer cust = this.cs.findById(customer.getCuostomerid());
		ServletActionContext.getRequest().getSession().setAttribute("customer", cust);
		UserService us = (UserService) application.getBean("userService");
		List<User> users = us.find(3); 
		ServletActionContext.getRequest().getSession().setAttribute("users", users);
		DatadictionaryService ds = (DatadictionaryService) application.getBean("datadictionaryService");
		List<Datadictionary> relationships = ds.findByType("客户关系");
		ServletActionContext.getRequest().getSession().setAttribute("rela", relationships);
		List<Datadictionary> satisfactions = ds.findByType("客户满意度");
		ServletActionContext.getRequest().getSession().setAttribute("sati", satisfactions);
		List<Datadictionary> credits = ds.findByType("客户信用");
		ServletActionContext.getRequest().getSession().setAttribute("cred", credits);
		return "custInfo";
	}
	public String update() {
		CustomerDao cd = (CustomerDao) application.getBean("customerDao");
		Customer cust = cd.get(customer.getCuostomerid());
		DatadictionaryService ds = (DatadictionaryService) application.getBean("datadictionaryService");
		cust.setDatadictionaryByRelationshiplevel(ds.findById(customer.getDatadictionaryByRelationshiplevel().getDdid()));
		cust.setDatadictionaryByCredit(ds.findById(customer.getDatadictionaryByCredit().getDdid()));
		cust.setDatadictionaryBySatisfaction(ds.findById(customer.getDatadictionaryBySatisfaction().getDdid()));
		AreaService as = (AreaService) application.getBean("areaService");
		cust.setArea(as.findById(customer.getArea().getAreaid()));
		UserService us = (UserService) application.getBean("userService");
		cust.setUser(us.findById(customer.getUser().getUserid()));
		cust.setCompany(customer.getCompany());
		cust.setAddress(customer.getAddress());
		cust.setBank(customer.getBank());
		cust.setBankaccount(customer.getBankaccount());
		cust.setPhone(customer.getPhone());
		cust.setPostalcode(customer.getPostalcode());
		cust.setFax(customer.getFax());
		cust.setUrl(customer.getUrl());
		cust.setLicenseno(customer.getLicenseno());
		cust.setCorporation(customer.getCorporation());
		cust.setCapital(customer.getCapital());
		cust.setTurnover(customer.getTurnover());
		cust.setLandtax(customer.getLandtax());
		cust.setNationaltax(customer.getNationaltax());
		cd.update(cust);
		ServletActionContext.getRequest().getSession().setAttribute("customer", cust);
		return "custInfo";
		
	}
	public String delete() {
		CustomerDao cd = (CustomerDao) application.getBean("customerDao");
		cd.delete(customer.getCuostomerid());
		
		return "custManage";
		
	}
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
}
