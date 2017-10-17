package com.jokerdemo.crm.action;




import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.domain.Churns;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.AreaService;
import com.jokerdemo.service.ChurnsService;
import com.jokerdemo.service.DatadictionaryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChurnsAction extends ActionSupport implements ModelDriven<Churns>{
	private Churns churns = new Churns();
	private ChurnsService cs;
	private String searchCustomerId;
	private String searchCustomerName;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<Churns> pageModel;
	private static ApplicationContext application;
	static {
			application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public PageModel<Churns> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Churns> pageModel) {
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
	public Churns getChurns() {
		return churns;
	}
	public void setChurns(Churns churns) {
		this.churns = churns;
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
	public void setCs(ChurnsService cs) {
		this.cs = cs;
	}
	public String findChurns() {
		if("".equals(searchCustomerId)) searchCustomerId=null;
		if("".equals(searchCustomerName)) searchCustomerName=null;
		this.pageModel = this.cs.findByPage(searchCustomerId, searchCustomerName, currentPage, pageSize);
		
		return SUCCESS;
		
	}
//	public String showInfo() {
//		Customer cust = this.cs.findById(customer.getCuostomerid());
//		ServletActionContext.getRequest().getSession().setAttribute("customer", cust);
//		UserService us = (UserService) application.getBean("userService");
//		List<User> users = us.find(3); 
//		ServletActionContext.getRequest().getSession().setAttribute("users", users);
//		DatadictionaryService ds = (DatadictionaryService) application.getBean("datadictionaryService");
//		List<Datadictionary> relationships = ds.findByType("客户关系");
//		ServletActionContext.getRequest().getSession().setAttribute("rela", relationships);
//		List<Datadictionary> satisfactions = ds.findByType("客户满意度");
//		ServletActionContext.getRequest().getSession().setAttribute("sati", satisfactions);
//		List<Datadictionary> credits = ds.findByType("客户信用");
//		ServletActionContext.getRequest().getSession().setAttribute("cred", credits);
//		return "custInfo";
//	}
//	public String update() {
//		CustomerDao cd = (CustomerDao) application.getBean("customerDao");
//		Customer cust = cd.get(customer.getCuostomerid());
//		DatadictionaryService ds = (DatadictionaryService) application.getBean("datadictionaryService");
//		cust.setDatadictionaryByRelationshiplevel(ds.findById(customer.getDatadictionaryByRelationshiplevel().getDdid()));
//		cust.setDatadictionaryByCredit(ds.findById(customer.getDatadictionaryByCredit().getDdid()));
//		cust.setDatadictionaryBySatisfaction(ds.findById(customer.getDatadictionaryBySatisfaction().getDdid()));
//		AreaService as = (AreaService) application.getBean("areaService");
//		cust.setArea(as.findById(customer.getArea().getAreaid()));
//		UserService us = (UserService) application.getBean("userService");
//		cust.setUser(us.findById(customer.getUser().getUserid()));
//		cust.setCompany(customer.getCompany());
//		cust.setAddress(customer.getAddress());
//		cust.setBank(customer.getBank());
//		cust.setBankaccount(customer.getBankaccount());
//		cust.setPhone(customer.getPhone());
//		cust.setPostalcode(customer.getPostalcode());
//		cust.setFax(customer.getFax());
//		cust.setUrl(customer.getUrl());
//		cust.setLicenseno(customer.getLicenseno());
//		cust.setCorporation(customer.getCorporation());
//		cust.setCapital(customer.getCapital());
//		cust.setTurnover(customer.getTurnover());
//		cust.setLandtax(customer.getLandtax());
//		cust.setNationaltax(customer.getNationaltax());
//		cd.update(cust);
//		ServletActionContext.getRequest().getSession().setAttribute("customer", cust);
//		return "custInfo";
//		
//	}
//	public String delete() {
//		CustomerDao cd = (CustomerDao) application.getBean("customerDao");
//		cd.delete(customer.getCuostomerid());
//		
//		return "custManage";
//		
//	}
	@Override
	public Churns getModel() {
		// TODO Auto-generated method stub
		return churns;
	}
	
}
