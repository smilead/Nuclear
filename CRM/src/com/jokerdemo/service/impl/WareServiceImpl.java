package com.jokerdemo.service.impl;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.CustomerDao;
import com.jokerdemo.crm.dao.WareDao;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Ware;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.WareService;

public class WareServiceImpl implements WareService {
private WareDao wd;
private HibernateTransactionManager tx;

public void setTx(HibernateTransactionManager tx) {
	this.tx = tx;
}
public void setWd(WareDao wd) {
	this.wd = wd;
}
@Override
public PageModel<Ware> findByPage(String searchWId, String searchWst, int currentPage, int pageSize) {
	PageModel<Ware> pageModel = null;
	String hql = "from Ware";
	if(searchWId!=null && searchWst!=null)
		pageModel = this.wd.listPage(hql+" where wareproduct like '%"+searchWId+"%' and ware like '%"+searchWst+"%'", currentPage, pageSize);
	else if(searchWId!=null && searchWst==null)
		pageModel = this.wd.listPage(hql+" where wareproduct like '%"+searchWId+"%'", currentPage, pageSize);
	else if(searchWId==null && searchWst!=null)
		pageModel = this.wd.listPage(hql+" where ware like '%"+searchWst+"%'", currentPage, pageSize);
	else
		pageModel = this.wd.listPage(hql, currentPage, pageSize);
	return pageModel;
}



}