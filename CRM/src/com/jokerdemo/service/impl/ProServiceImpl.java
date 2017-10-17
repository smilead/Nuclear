package com.jokerdemo.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.DatadictionaryDao;
import com.jokerdemo.crm.dao.ProDao;
import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.domain.Product;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.ProService;

public class ProServiceImpl implements ProService{
	private ProDao pd;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setPd(ProDao pd) {
		this.pd = pd;
	}

	
	@Override
	public List<Product> findByType(String type) {
		return this.pd.find("from Datadictionary where ddtype='"+type+"'");
	}
	@Override
	public PageModel<Product> findByPage(String searchPType,
		String searchPName, int currentPage, int pageSize) {
		PageModel<Product> pageModel = null;
		String hql ="select new Product(productid,productname,producttype,productprice,productonce,productunit,productoutline) from Product";
		if(searchPType!=null && searchPName!=null)
			pageModel = this.pd.listPage(hql+" where productname like '%"+searchPName+"%' and producttype like '%"+searchPType+"%'", currentPage, pageSize);
		else if(searchPType!=null && searchPName==null)
			pageModel = this.pd.listPage(hql+" where producttype like '%"+searchPType+"%'", currentPage, pageSize);
		else if(searchPType==null && searchPName!=null)
			pageModel = this.pd.listPage(hql+" where productname like '%"+searchPName+"%'", currentPage, pageSize);
		else
			pageModel = this.pd.listPage(hql, currentPage, pageSize);
	
		return pageModel;
		
	}
	

}
