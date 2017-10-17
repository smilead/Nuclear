package com.jokerdemo.service.impl;


import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.JobDao;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Job;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.JobService;

public class JobServiceImpl implements JobService{
	private JobDao jd;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setJd(JobDao jd) {
		this.jd = jd;
	}
	@Override
	public PageModel<Job> findByPage(String searchCustomerId, String searchCustomerName, int currentPage,
			int pageSize) {
		PageModel<Job> pageModel = null;
		
		String hql = "select new Job(j.jobno,j.jobname) from Job as j";
		if(searchCustomerId!=null && searchCustomerName!=null)
			pageModel = this.jd.listPage(hql+" where c.cuostomerid like '%"+searchCustomerId+"%' and company like '%"+searchCustomerName+"%'", currentPage, pageSize);
		else if(searchCustomerId!=null && searchCustomerName==null)
			pageModel = this.jd.listPage(hql+" where c.cuostomerid like '%"+searchCustomerId+"%'", currentPage, pageSize);
		else if(searchCustomerId==null && searchCustomerName!=null)
			pageModel = this.jd.listPage(hql+" where c.company like '%"+searchCustomerName+"%'", currentPage, pageSize);
		else
			pageModel = this.jd.listPage(hql, currentPage, pageSize);
		return pageModel;
	}
}
