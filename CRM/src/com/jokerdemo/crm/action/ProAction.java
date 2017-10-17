package com.jokerdemo.crm.action;

import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.domain.Product;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.DatadictionaryService;
import com.jokerdemo.service.ProService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	private ProService pr;
	private String searchPType;
	private String searchPName;
	private int currentPage = 1;
	private int pageSize = 5;
	private PageModel<Product> pageModel;
	
	
	public String findProduct() {
		if("".equals(searchPType)) searchPType=null;
		if("".equals(searchPName)) searchPName=null;
		System.out.println(searchPType+searchPName+currentPage+pageSize);
		this.pageModel = this.pr.findByPage(searchPType, searchPName, currentPage, pageSize);
		System.out.println(pageModel.getList().get(0).getProductname());
		return SUCCESS;
		
	}


	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setPr(ProService pr) {
		this.pr = pr;
	}


	public void setSearchPType(String searchPType) {
		this.searchPType = searchPType;
	}


	public void setSearchPName(String searchPName) {
		this.searchPName = searchPName;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public void setPageModel(PageModel<Product> pageModel) {
		this.pageModel = pageModel;
	}


	public Product getProduct() {
		return product;
	}


	public ProService getPr() {
		return pr;
	}


	public String getSearchPType() {
		return searchPType;
	}


	public String getSearchPName() {
		return searchPName;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public PageModel<Product> getPageModel() {
		return pageModel;
	}
	
}
