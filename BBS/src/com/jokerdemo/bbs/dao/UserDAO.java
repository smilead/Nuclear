package com.jokerdemo.bbs.dao;

import java.util.ArrayList;

import com.jokerdemo.bbs.entity.User;

/**
 * 用户数据持久接口
 * @author Administrator
 *
 */
public interface UserDAO {
	
	/**
	 * 增加用户
	 * @param username
	 * @param password
	 * @return
	 */
	int addUser(String username, String password);
	
	/**
	 * 删除用户
	 * @param uid
	 * @return
	 */
	int deleteUser(String uid);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 查询全部
	 * @return
	 */
	ArrayList<User> findAllUsers();
	/**
	 * 分页查询
	 */
	ArrayList<User> findByPage(int currentPage, int pageSize);
	/**
	 * 按条件查询
	 * @param sel
	 * @param obj
	 * @return
	 */
	ArrayList<User> findUserBy(String sel, Object obj);
	/**
	 * 按id查询
	 * @param uid
	 * @return
	 */
	User quicklyFind(int uid);
	/**
	 * 模糊查询分页
	 */
	ArrayList<User> findUserLike(String str, int currentPage, int pageSize);

}
