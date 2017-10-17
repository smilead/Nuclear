package com.jokerdemo.crm.dao.impl;

import java.util.List;

import com.jokerdemo.crm.dao.UserDao;
import com.jokerdemo.crm.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	@Override
	public User find(String username, String password) {
		
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where username='"+username+"' and password='"+password+"'");
		if(users.size()==1)
			return users.get(0);
		return null;
	}

}
