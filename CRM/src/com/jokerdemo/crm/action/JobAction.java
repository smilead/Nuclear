package com.jokerdemo.crm.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.domain.Job;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.JobService;
import com.jokerdemo.service.JobprivalegeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JobAction extends ActionSupport implements ModelDriven<Job>{
	private Job job = new Job();
	private JobService js;
	private String searchCustomerId;
	private String searchCustomerName;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<Job> pageModel;
	private static ApplicationContext application;
	static {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public void setJs(JobService js) {
		this.js = js;
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

	public PageModel<Job> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<Job> pageModel) {
		this.pageModel = pageModel;
	}

	public String findJobs() {
		if("".equals(searchCustomerId)) searchCustomerId=null;
		if("".equals(searchCustomerName)) searchCustomerName=null;
		System.out.println(searchCustomerId+searchCustomerName+currentPage+pageSize);
		this.pageModel = this.js.findByPage(searchCustomerId, searchCustomerName, currentPage, pageSize);
		JobprivalegeService jps = (JobprivalegeService) application.getBean("jobprivalegeService");
		for(Job job1:pageModel.getList()) {
			job1.setPrivs(jps.findPrivs(job1.getJobno()));
		}
		System.out.println(pageModel.getTotalPage());
		return SUCCESS;
		
	}
	@Override
	public Job getModel() {
		// TODO Auto-generated method stub
		return job;
	}

}
