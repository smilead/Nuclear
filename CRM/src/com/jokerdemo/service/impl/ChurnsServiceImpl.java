package com.jokerdemo.service.impl;


import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.ChurnsDao;
import com.jokerdemo.crm.domain.Churns;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.ChurnsService;


public class ChurnsServiceImpl implements ChurnsService{
	private ChurnsDao cd;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setCd(ChurnsDao cd) {
		this.cd = cd;
	}
	
	public ChurnsDao getCd() {
		return cd;
	}
	public HibernateTransactionManager getTx() {
		return tx;
	}
	@Override
	public PageModel<Churns> findByPage(String searchCustomerId, String searchCustomerName, int currentPage, int pageSize) {
		PageModel<Churns> pageModel = null;
		
		String hql = "select new Churns(ch.churnid,c.company,s.statusvalue) from Churns as ch left join ch.customer as c left join ch.status as s";
		if(searchCustomerId!=null && searchCustomerName!=null)
			pageModel = this.cd.listPage(hql+" where c.cuostomerid like '%"+searchCustomerId+"%' and company like '%"+searchCustomerName+"%'", currentPage, pageSize);
		else if(searchCustomerId!=null && searchCustomerName==null)
			pageModel = this.cd.listPage(hql+" where c.cuostomerid like '%"+searchCustomerId+"%'", currentPage, pageSize);
		else if(searchCustomerId==null && searchCustomerName!=null)
			pageModel = this.cd.listPage(hql+" where c.company like '%"+searchCustomerName+"%'", currentPage, pageSize);
		else
			pageModel = this.cd.listPage(hql, currentPage, pageSize);
		return pageModel;
	}
	@Override
	public Churns findById(Integer id) {
		Churns customer = this.cd.get(id);
		return customer;
	}
	@Override
	public boolean update(Churns customer) {
		return this.cd.update(customer);
	}
	

}
