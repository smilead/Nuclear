package com.jokerdemo.bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.jokerdemo.bbs.dao.UserDAO;
import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.util.DBUtil;

/**
 * 用户类数据持久实现类
 * @author Administrator
 *
 */
public class UserDAOImpl implements UserDAO{

	/**
	 * 增加用户类
	 */
	@Override
	public int addUser(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "insert into user(username,password,pixname) values(?,?,?)";
		DBUtil dbutil = new DBUtil();
		String pixname = "Joker-";
		Random rand = new Random();
		for(int i=0;i<8;i++){
			char ch = (char) (rand.nextInt(26)+97);
			pixname += ch;
		}
		int rows = dbutil.executOther(sql, new Object[]{username,password,pixname});
		return rows;
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteUser(String uid) {
		// TODO Auto-generated method stub
		String sql = "delete from user where uid = ?";
		DBUtil dbutil = new DBUtil();
		int rows = dbutil.executOther(sql, new Object[]{uid});
		return rows;
	}
	
	/**
	 *更改用户 
	 */
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set username = ?, password = ?, userpic = ?, pixname = ?, sex = ?, age = ?, tel = ?, email = ?, exp = ?, status = ?, level = ?, safequestion = ?, safeanswer = ? where uid = ?";
		DBUtil dbutil = new DBUtil();
		int rows = dbutil.executOther(sql, new Object[]{user.getUsername(), user.getPassword(), user.getUserpic(), user.getPixname(), user.getSex(), user.getAge(), user.getTel(), user.getEmail(), user.getExp(), user.getStatus(), user.getLevel(), user.getSafeques(), user.getSafeanswer(), user.getUid()});
		return rows;
	}

	@Override
	/**
	 * 查询全部用户
	 */
	public ArrayList<User> findAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> al = new ArrayList<User>();
		String sql = "select * from user";
		DBUtil dbutil = new DBUtil();
		ResultSet rs = dbutil.execQuery(sql, new Object[0]);
		try {
			while(rs.next()){
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserpic(rs.getString("userpic"));
				user.setPixname(rs.getString("pixname"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setExp(rs.getInt("exp"));
				user.setStatus(rs.getInt("status"));
				user.setLevel(rs.getString("level"));
				user.setSafeques(rs.getString("safequestion"));
				user.setSafeanswer(rs.getString("safeanswer"));
				al.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbutil.closeConn();
		return al;
	}

	@Override
	/**
	 * 按条件查询
	 */
	public ArrayList<User> findUserBy(String sel, Object obj) {
		// TODO Auto-generated method stub
		ArrayList<User> al = new ArrayList<User>();
		String sql = "select * from user where "+sel+" = ?";
		DBUtil dbutil = new DBUtil();
		ResultSet rs = dbutil.execQuery(sql, new Object[]{obj});
		try {
			while(rs.next()){
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserpic(rs.getString("userpic"));
				user.setPixname(rs.getString("pixname"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setExp(rs.getInt("exp"));
				user.setStatus(rs.getInt("status"));
				user.setLevel(rs.getString("level"));
				user.setSafeques(rs.getString("safequestion"));
				user.setSafeanswer(rs.getString("safeanswer"));
				al.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbutil.closeConn();
		return al;
	}
	/**
	 * 按编号查询
	 */
	@Override
	public User quicklyFind(int uid) {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select * from user where uid = ?";
		DBUtil dbutil = new DBUtil();
		ResultSet rs = dbutil.execQuery(sql, new Object[]{uid});
		try {
			if(rs.next()){
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUserpic(rs.getString("userpic"));
				user.setPixname(rs.getString("pixname"));
				user.setSex(rs.getString("sex"));
				user.setLevel(rs.getString("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbutil.closeConn();
		return user;
	}
	/**
	 * 分页查询
	 */
	@Override
	public ArrayList<User> findByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from user limit ?,?";
		DBUtil dbutil = new DBUtil();
		ResultSet rs = dbutil.execQuery(sql, new Object[] {(currentPage-1)*pageSize,pageSize});
		ArrayList<User> users = new ArrayList<User>();
		try {
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserpic("userpic");
				user.setPixname(rs.getString("pixname"));
				user.setExp(rs.getInt("exp"));
				user.setSex(rs.getString("sex"));
				user.setLevel(rs.getString("level"));
				user.setStatus(rs.getInt("status"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.closeConn();
		}
		
		return users;
	}
	
	/**
	 * 模糊查询
	 */
	@Override
	public ArrayList<User> findUserLike(String str, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		DBUtil dbutil = new DBUtil();
		ArrayList<User> users = new ArrayList<User>();
		str = "%"+str+"%";
		String sql = null;
		ResultSet rs = null;
		if(currentPage==0 && pageSize==0) {
			sql = "select * from user where uid like ? or username like ? or pixname like ?";
			rs = dbutil.execQuery(sql, new Object[] {str,str,str});
		}else {
			sql = "select * from user where uid like ? or username like ? or pixname like ? limit ?,?";
			rs = dbutil.execQuery(sql, new Object[] {str,str,str,(currentPage-1)*pageSize,pageSize});
		}
		try {
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserpic("userpic");
				user.setPixname(rs.getString("pixname"));
				user.setExp(rs.getInt("exp"));
				user.setSex(rs.getString("sex"));
				user.setLevel(rs.getString("level"));
				user.setStatus(rs.getInt("status"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.closeConn();
		}
		
		return users;
	}
	
	
}
