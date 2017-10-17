package com.jokerdemo.service.impl;


import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.UserDao;
import com.jokerdemo.crm.domain.User;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao ud;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	@Override
	public User login(String username, String password) {
		return this.ud.find(username, password);
	}
	@Override
	public List<User> find(Integer jobno) {
		return this.ud.find("from User where jobno = "+jobno);
	}
	@Override
	public User findById(int userid) {
		return this.ud.get(userid);
	}
	@Override
	public PageModel<User> findByPage(String searchCustomerId, String searchCustomerName, int currentPage,
			int pageSize) {
		PageModel<User> pageModel = null;
		
		String hql="select new User(u.userid,u.username,j.jobname,j.jobno,u.entrytime) from User as u left join u.job as j";
		if(searchCustomerId!=null && searchCustomerName!=null)
			pageModel = this.ud.listPage(hql+" where u.username like '%"+searchCustomerId+"%' and j.jobname like '%"+searchCustomerName+"%'", currentPage, pageSize);
		else if(searchCustomerId!=null && searchCustomerName==null)
			pageModel = this.ud.listPage(hql+" where u.username like '%"+searchCustomerId+"%'", currentPage, pageSize);
		else if(searchCustomerId==null && searchCustomerName!=null)
			pageModel = this.ud.listPage(hql+" where j.jobname like '%"+searchCustomerName+"%'", currentPage, pageSize);
		else
			pageModel = this.ud.listPage(hql, currentPage, pageSize);
		return pageModel;
	}

}
