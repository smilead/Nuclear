package com.jokerdemo.crm.dao;


import com.jokerdemo.crm.domain.User;

public interface UserDao extends BaseDao<User>{
	public User find(String username,String password);

}
