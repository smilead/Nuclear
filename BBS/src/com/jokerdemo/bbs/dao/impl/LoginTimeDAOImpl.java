package com.jokerdemo.bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jokerdemo.bbs.dao.LoginTimeDAO;
import com.jokerdemo.bbs.entity.LoginTime;
import com.jokerdemo.bbs.util.DBUtil;

/**
 * 登录时间数据访问实现
 * @author Administrator
 *
 */
public class LoginTimeDAOImpl implements LoginTimeDAO{
	@Override
	public int addLoginTime(int uid) {
		// TODO Auto-generated method stub
		String sql = "insert into logintime values(now(),?);";
		DBUtil dbutil = new DBUtil();
		int rows = dbutil.executOther(sql, new Object[]{uid});
		return rows;
	}

	@Override
	public int deleteLoginTime(LoginTime lt) {
		// TODO Auto-generated method stub
		String sql = "delete from logintime where logintime = ? and uid = ?";
		DBUtil dbutil = new DBUtil();
		int rows = dbutil.executOther(sql, new Object[]{lt.getLogintime(),lt.getUid()});
		return rows;
	}

	@Override
	public int upadateLoginTime(LoginTime lt) {
		// TODO Auto-generated method stub
		String sql = "upadate logintime set logintime = ? where uid = ?";
		DBUtil dbutil = new DBUtil();
		int rows = dbutil.executOther(sql, new Object[]{lt.getLogintime(),lt.getUid()});
		return rows;
	}

	@Override
	public ArrayList<LoginTime> findAllLoginTimes() {
		// TODO Auto-generated method stub
		ArrayList<LoginTime> al = new ArrayList<LoginTime>();
		String sql = "select * from logintime order by logintime desc";
		DBUtil dbutil = new DBUtil();
		ResultSet rs = dbutil.execQuery(sql, new Object[0]);
		try {
			while(rs.next()){
				LoginTime lt = new LoginTime();
				lt.setLogintime(rs.getDate("logintime"));
				lt.setUid(rs.getInt("uid"));
				al.add(lt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbutil.closeConn();
		return al;
	}

	@Override
	public ArrayList<LoginTime> findLoginTimeBy(String sel, Object obj) {
		// TODO Auto-generated method stub
		ArrayList<LoginTime> al = new ArrayList<LoginTime>();
		String sql = "select * from logintime where "+sel+" =? order by logintime";
		DBUtil dbutil = new DBUtil();
		ResultSet rs = dbutil.execQuery(sql, new Object[]{obj});
		try {
			while(rs.next()){
				LoginTime lt = new LoginTime();
				lt.setLogintime(rs.getDate("logintime"));
				lt.setUid(rs.getInt("uid"));
				al.add(lt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbutil.closeConn();
		return al;
	}
	
}
