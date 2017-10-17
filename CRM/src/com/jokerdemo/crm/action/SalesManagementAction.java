package com.jokerdemo.crm.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokerdemo.crm.dao.ChanceDao;
import com.jokerdemo.crm.domain.Chance;
import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.SaleManagementService;
import com.jokerdemo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class SalesManagementAction extends  ActionSupport implements ModelDriven<Chance>{
	private SaleManagementService saleManagementService=null;
	private Chance chance=new Chance();
	private String searchCustomername;
	private String searchContactsname;
	private String searchOutline;
	private PageModel<Chance> pageModel;
	private Integer userid;
	private int currentPage;
	private int pageSize;
	
	
	
	public String searchChance() {
		if(currentPage==0) {
			currentPage=1;
		}
		if(pageSize==0) {
			pageSize=10;
		}	
		pageModel=saleManagementService.searchChance(searchCustomername, searchContactsname, searchOutline, currentPage, pageSize);
		pageModel.setAction("ManageSaleOpportunity_searchChance");
		return SUCCESS;
	}

	public String delete() {
		System.out.println(chance.getChanceid());
		Integer in=new Integer(44);
		System.out.println(saleManagementService.delete(43));
		System.out.println(saleManagementService.delete(in));
		System.out.println(saleManagementService.delete(chance.getChanceid()));
		
		if(saleManagementService.delete(chance.getChanceid())) {
			System.out.println("删除");
			return "delete";	
		}else {
			System.out.println("error");
			return "error";
		}
		
	}
	
	public String newChance(Chance chance) {
		saleManagementService.addChance(chance);
		return "newChance";
	}
	
	public String compileSaleOpportunity(){
		readyChance();
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService) application.getBean("userService");
		List<User> users = us.find(3);
		ServletActionContext.getRequest().setAttribute("users", users);
		return "compileSaleOpportunity";
	}
	
	public String readyChance() {
		ServletActionContext.getRequest().setAttribute("chance", saleManagementService.getChance(chance.getChanceid()));
		return SUCCESS;
	}
	
	public String SearchChanceById(int chanceid) {
		ServletActionContext.getRequest().setAttribute("chance", saleManagementService.getChance(chanceid));
		return SUCCESS;
	}
	public String assignReady() {
		readyChance();
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService) application.getBean("userService");
		List<User> users = us.find(3);
		ServletActionContext.getRequest().setAttribute("users", users);
		return "assignReady";
	}
	public String assignChance() {
		
		if(saleManagementService.assignChanceService(chance.getChanceid(), userid)) {
		return "assignChance";
		}
		return "error";
	}
	
	public String updatechance() {
		System.out.println(chance.getChanceid());
		System.out.println("------------");
		saleManagementService.updateChanceService(chance);
		return "updateChance";
	}
	
	
	


	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setPageModel(PageModel<Chance> pageModel) {
		this.pageModel = pageModel;
	}
	
	@Override
	public Chance getModel() {
		// TODO Auto-generated method stub
		return chance;
	}
	public void setSearchCustomername(String searchCustomername) {
		this.searchCustomername = searchCustomername;
	}

	public void setSearchContactsname(String searchContactsname) {
		this.searchContactsname = searchContactsname;
	}

	public void setSerchOutline(String serchOutline) {
		this.searchOutline = serchOutline;
	}

	public String getSearchOutline() {
		return searchOutline;
	}
	

	public void setSearchOutline(String searchOutline) {
		this.searchOutline = searchOutline;
	}

	public String getSearchCustomername() {
		return searchCustomername;
	}

	public String getSearchContactsname() {
		return searchContactsname;
	}

	public PageModel<Chance> getPageModel() {
		return pageModel;
	}

	public Chance getChance() {
		return chance;
	}

	public void setChance(Chance chance) {
		this.chance = chance;
	}
	
	

	public void setSaleManagementService(SaleManagementService saleManagementService) {
		this.saleManagementService = saleManagementService;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
