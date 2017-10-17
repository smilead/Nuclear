package com.jokerdemo.bbs.dao;


import java.util.ArrayList;

import com.jokerdemo.bbs.entity.LoginTime;

/**
 * 登录时间数据访问接口
 * @author Administrator
 *
 */
public interface LoginTimeDAO {
	/**
	 * 增加信息
	 */
	int addLoginTime(int uid);
	/**
	 * 删除信息
	 */
	int deleteLoginTime(LoginTime lt);
	/**
	 * 修改信息
	 */
	int upadateLoginTime(LoginTime lt);
	/**
	 * 查询全部
	 */
	ArrayList<LoginTime> findAllLoginTimes();
	/**
	 * 按条件查
	 */
	ArrayList<LoginTime> findLoginTimeBy(String sel,Object obj);
}
