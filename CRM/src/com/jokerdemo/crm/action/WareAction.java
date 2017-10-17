package com.jokerdemo.crm.action;

import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Ware;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.CustomerService;
import com.jokerdemo.service.WareService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WareAction extends ActionSupport implements ModelDriven<Ware> {
	private Ware ware = new Ware();
	private WareService ws;
	private String searchWId;
	private String searchWst;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<Ware> pageModel;

	@Override
	public Ware getModel() {
		// TODO Auto-generated method stub
		return ware;
	}
	public String findWare() {
		if("".equals(searchWId)) searchWId=null;
		if("".equals(searchWst)) searchWst=null;
		System.out.println(searchWId+searchWst+currentPage+pageSize);
		this.pageModel = this.ws.findByPage(searchWId, searchWst, currentPage, pageSize);
		
		return SUCCESS;
		
	}
	public Ware getWare() {
		return ware;
	}
	public void setWare(Ware ware) {
		this.ware = ware;
	}
	public WareService getWs() {
		return ws;
	}
	public void setWs(WareService ws) {
		this.ws = ws;
	}
	public String getSearchWId() {
		return searchWId;
	}
	public void setSearchWId(String searchWId) {
		this.searchWId = searchWId;
	}
	public String getSearchWst() {
		return searchWst;
	}
	public void setSearchWst(String searchWst) {
		this.searchWst = searchWst;
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
	public PageModel<Ware> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Ware> pageModel) {
		this.pageModel = pageModel;
	}

}
