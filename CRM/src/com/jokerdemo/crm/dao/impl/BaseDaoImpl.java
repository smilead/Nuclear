package com.jokerdemo.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.transform.Result;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jokerdemo.crm.dao.BaseDao;
import com.jokerdemo.crm.po.PageModel;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class<T> clazs;
	
	

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		this.clazs = (Class<T>) types[0];
	}
	@Override
	public boolean add(T t) {
		if(this.getHibernateTemplate().save(t)!=null)
			return true;
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		T t = this.get(id);
		this.getHibernateTemplate().delete(t);
		if(t!=null)
			return true;
		return false;
	}

	@Override
	public boolean update(T t) {
		System.out.println("修改中");
		this.getHibernateTemplate().update(t);
		return true;
	}

	@Override
	public T get(Serializable id) {
		return this.getHibernateTemplate().get(this.clazs, id);
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+this.clazs.getSimpleName());
	}

	@SuppressWarnings("deprecation")
	@Override
	public PageModel<T> listPage(final String realquery, final int currentPage, final int pageSize) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(realquery);
				query.list().size();
				query.setMaxResults(pageSize);
				query.setFirstResult((currentPage-1)*pageSize);
				return query.list();
				
			}
		});
		int totalCount = this.find(realquery).size();
		PageModel<T> pageModel = new PageModel<T>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setPageSize(pageSize);
		pageModel.setList(list);
		pageModel.setTotalCount(totalCount);
		pageModel.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
		return pageModel;
	}
	public List<T> find(String realquery) {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find(realquery);
	}
	

}
