package com.jokerdemo.crm.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.CustomerService;
import com.jokerdemo.service.DatadictionaryService;
import com.jokerdemo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DictionariesAction  extends ActionSupport implements ModelDriven<Datadictionary>{
	private Datadictionary datadictionary = new Datadictionary();
	private DatadictionaryService dt;
	private String searchDType;
	private String searchDName;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<Datadictionary> pageModel;
	
	
	public String findDatadictionary() {
		if("".equals(searchDType)) searchDType=null;
		if("".equals(searchDName)) searchDName=null;
		System.out.println(searchDType+searchDName+currentPage+pageSize);
		this.pageModel = this.dt.findByPage(searchDType, searchDName, currentPage, pageSize);
		
		return SUCCESS;
		
	}
	
	@Override
	public Datadictionary getModel() {
		// TODO Auto-generated method stub
		return datadictionary;
	}
	public Datadictionary getDatadictionary() {
		return datadictionary;
	}
	public void setDatadictionary(Datadictionary datadictionary) {
		this.datadictionary = datadictionary;
	}
	public DatadictionaryService getDt() {
		return dt;
	}
	public void setDt(DatadictionaryService dt) {
		this.dt = dt;
	}
	public String getSearchDType() {
		return searchDType;
	}
	public void setSearchDType(String searchDType) {
		this.searchDType = searchDType;
	}
	public String getSearchDName() {
		return searchDName;
	}
	public void setSearchDName(String searchDName) {
		this.searchDName = searchDName;
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
	public PageModel<Datadictionary> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Datadictionary> pageModel) {
		this.pageModel = pageModel;
	}
	
}
