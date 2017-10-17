package com.jokerdemo.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jokerdemo.crm.dao.DatadictionaryDao;
import com.jokerdemo.crm.domain.Customer;
import com.jokerdemo.crm.domain.Datadictionary;
import com.jokerdemo.crm.po.PageModel;
import com.jokerdemo.service.DatadictionaryService;

public class DatadictionaryServiceImpl implements DatadictionaryService{
	private DatadictionaryDao dd;
	private HibernateTransactionManager tx;

	public void setTx(HibernateTransactionManager tx) {
		this.tx = tx;
	}
	public void setDd(DatadictionaryDao dd) {
		this.dd = dd;
	}
	@Override
	public List<Datadictionary> findByType(String type) {
		return this.dd.find("from Datadictionary where ddtype='"+type+"'");
	}
	@Override
	public PageModel<Datadictionary> findByPage(String searchDType,
		String searchDName, int currentPage, int pageSize) {
		PageModel<Datadictionary> pageModel = null;
		String hql ="select new Datadictionary(ddid,ddtype,ddname,ddvalue,editorable) from Datadictionary";
		if(searchDType!=null && searchDName!=null)
			pageModel = this.dd.listPage(hql+" where ddtype like '%"+searchDType+"%' and ddname like '%"+searchDName+"%'", currentPage, pageSize);
		else if(searchDType!=null && searchDName==null)
			pageModel = this.dd.listPage(hql+" where ddtype like '%"+searchDType+"%'", currentPage, pageSize);
		else if(searchDType==null && searchDName!=null)
			pageModel = this.dd.listPage(hql+" where ddname like '%"+searchDName+"%'", currentPage, pageSize);
		else
			pageModel = this.dd.listPage(hql, currentPage, pageSize);
	;
		return pageModel;
		
	}
	@Override
	public Datadictionary findById(int ddid) {
		
		return this.dd.get(ddid);
	}
	

}
