package com.jokerdemo.service.impl;


import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.CustomerDao;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.CustomerService;


public class CustomerServiceImpl implements CustomerService{
	private CustomerDao cd;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
	public CustomerDao getCd() {
		return cd;
	}
	public HibernateTransactionManager getTx() {
		return tx;
	}
	@Override
	public PageModel<Customer> findByPage(String searchCustomerId, String searchCustomerName, int currentPage, int pageSize) {
		PageModel<Customer> pageModel = null;
		
		String hql = "select new Customer(c.cuostomerid,c.company,u.username,d.ddname) from Customer as c left join c.user as u left join c.datadictionaryByRelationshiplevel as d";
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
	public Customer findById(String cuostomerid) {
		Customer customer = this.cd.get(cuostomerid);
		return customer;
	}
	@Override
	public boolean update(Customer customer) {
		System.out.println(customer.getCompany());
		return this.cd.update(customer);
	}
	

}
