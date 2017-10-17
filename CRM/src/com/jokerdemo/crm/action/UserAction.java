package com.jokerdemo.crm.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.JobprivalegeService;
import com.jokerdemo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService us;
	private String searchCustomerId;
	private String searchCustomerName;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<User> pageModel;
	private static ApplicationContext application;
	static {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public void setUs(UserService us) {
		this.us = us;
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

	public PageModel<User> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<User> pageModel) {
		this.pageModel = pageModel;
	}

	public String login() {
		User loginer = this.us.login(user.getUsername(), user.getPassword());
		if(loginer!=null) {
			ServletActionContext.getRequest().getSession().setAttribute("loginer", loginer);
			return "index";
		}
		return LOGIN;
		
	}
	public String findUsers() {
		if("".equals(searchCustomerId)) searchCustomerId=null;
		if("".equals(searchCustomerName)) searchCustomerName=null;
		System.out.println(searchCustomerId+searchCustomerName+currentPage+pageSize);
		this.pageModel = this.us.findByPage(searchCustomerId, searchCustomerName, currentPage, pageSize);
		JobprivalegeService jps = (JobprivalegeService) application.getBean("jobprivalegeService");
		for(User user1:pageModel.getList()) {
			user1.setPrivs(jps.findPrivs(user1.getJobno()));
		}
		System.out.println(pageModel.getTotalPage());
		return SUCCESS;
		
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
