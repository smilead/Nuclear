package com.jokerdemo.crm.dao;

import java.io.Serializable;
import java.util.List;
import com.jokerdemo.crm.po.PageModel;

public interface BaseDao<T> {
	public boolean add(T t);
	public boolean delete(Serializable id);
	public boolean update(T t);
	public T get(Serializable id);
	
	public List<T> find();
	public PageModel<T> listPage(String query,int currentPage,int pageSize);
	public List<T> find(String realquery);
}
