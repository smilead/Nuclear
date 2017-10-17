package com.jokerdemo.bbs.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jokerdemo.bbs.dao.LoginTimeDAO;
import com.jokerdemo.bbs.dao.UserDAO;
import com.jokerdemo.bbs.dao.impl.LoginTimeDAOImpl;
import com.jokerdemo.bbs.dao.impl.UserDAOImpl;
import com.jokerdemo.bbs.entity.LoginTime;
import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.po.PageModel;
import com.jokerdemo.bbs.service.UserService;

/**
 * 用户类业务实现
 * @author BlackButterfly
 *
 */
public class UserServiceImpl implements UserService{
	/**
	 * 注册业务
	 */
	@Override
	public boolean registerService(String username, String password) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		int rows = ud.addUser(username, password);
		if(rows>0){
			return true;
		}
		return false;
	}
	/**
	 * 登录业务
	 */
	@Override
	public User loginService(String sel, String str, String password) {
		// TODO Auto-generated method stub
		User user = null;
		UserDAO ud = new UserDAOImpl();
		LoginTimeDAO ltd = new LoginTimeDAOImpl();
		ArrayList<User> al = ud.findUserBy(sel, str);
		if(al.size()==1 && password.equals(al.get(0).getPassword())){
			user = al.get(0);
			Date date = new Date(System.currentTimeMillis());
			ArrayList<LoginTime> lts =ltd.findLoginTimeBy("uid", user.getUid());
			ltd.addLoginTime(user.getUid());
			if(lts.size()==0 || !date.toString().equals(lts.get(0).getLogintime().toString())){
				addUserExp(user.getUid(), 10);
				user.setExp(user.getExp()+10);
			}
		}
		return user;
	}
	/**
	 * 增加经验业务
	 */
	@Override
	public boolean addUserExp(int uid,int exp){
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> al = ud.findUserBy("uid", uid);
		if(al.size()==1){
			User user = al.get(0);
			user.setExp(user.getExp()+exp);
			int rows = ud.updateUser(user);
			if(rows>0){
				return true;
			}
		}
		return false;
	}
	/**
	 * 通过uids集合找user
	 */
	@Override
	public ArrayList<User> findUsersByUids(ArrayList<Integer> uids) {
		// TODO Auto-generated method stub
		ArrayList<User> al = new ArrayList<User>();
		User user = null;
		UserDAO ud = new UserDAOImpl();
		for(int uid:uids){
			user = ud.quicklyFind(uid);
			if(user!=null){
				al.add(user);
			}else{
				al.add(null);
			}
		}
		return al;
	}
	/**
	 * 判断用户名是否存在
	 */
	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> al = ud.findUserBy("username", username);
		if(al.size()==1){
			return true;
		}
		return false;
	}
	/**
	 * 安全问题
	 */
	@Override
	public String findQuestionByUsername(String username) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> users = ud.findUserBy("username", username);
		String question = null;
		if(users.size()==1) {
			question = users.get(0).getSafeques();
		}
		return question;
	}
	/**
	 * 判断答案是否正确
	 */
	@Override
	public boolean checkAnswer(String username, String answer) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> users = ud.findUserBy("username", username);
		if(users.size()==1 && answer.equals(users.get(0).getSafeanswer())) {
			return true;
		}
		return false;
	}
	/**
	 * 修改密码
	 */
	@Override
	public boolean updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> al = ud.findUserBy("username", username);
		if(al.size()==1) {
			User user = al.get(0);
			user.setPassword(password);
			int rows = ud.updateUser(user);
			if(rows==1) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageModel<User> findUsersByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		List<User> users = ud.findByPage(currentPage, pageSize);
		PageModel<User> userPage = new PageModel<User>();
		ArrayList<User> al = ud.findAllUsers();
		userPage.setTotalCount(al.size());
		userPage.setCurrentPage(currentPage);
		userPage.setList(users);
		userPage.setPageSize(pageSize);
		userPage.setTotalPage((int)Math.ceil((double)userPage.getTotalCount()/userPage.getPageSize()));
		userPage.setServlet("FindAllUsersServlet");
		return userPage;
	}
	/**
	 * 修改状态
	 */
	@Override
	public boolean changeStatus(int uid) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> al = ud.findUserBy("uid", uid);
		if(al.size()==1) {
			User user = al.get(0);
			if(user.getStatus()>0) {
				user.setStatus(-1);
			}else {
				user.setStatus(1);
			}
			int rows = ud.updateUser(user);
			if(rows == 1)
			return true;
		}
		return false;
	}
	/**
	 * 模糊查询
	 */
	@Override
	public PageModel<User> findUsersLike(String str, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		List<User> users= ud.findUserLike(str, currentPage, pageSize);
		PageModel<User> userPage = new PageModel<User>();
		ArrayList<User> al = ud.findUserLike(str, 0, 0);
		userPage.setTotalCount(al.size());
		userPage.setCurrentPage(currentPage);
		userPage.setList(users);
		userPage.setPageSize(pageSize);
		userPage.setTotalPage((int)Math.ceil((double)userPage.getTotalCount()/userPage.getPageSize()));
		userPage.setSearch(str);
		userPage.setServlet("FindUserLikeServlet");
		return userPage;
	}
	/**
	 * 修改个人信息
	 */
	@Override
	public boolean updateUser(int uid, String pixname, String sex, int age, String email, String tel,
			String safeQuestion, String safeAnswer) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> users = ud.findUserBy("uid", uid);
		if(users.size()==1) {
			User user = users.get(0);
			user.setPixname(pixname);
			user.setSex(sex);
			user.setAge(age);
			user.setEmail(email);
			user.setTel(tel);
			user.setSafeques(safeQuestion);
			user.setSafeanswer(safeAnswer);
			int rows = ud.updateUser(user);
			if(rows==1) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 通过ID查询
	 */
	@Override
	public User findUserById(int uid) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		ArrayList<User> users = ud.findUserBy("uid", uid);
		User user = null;
		if(users.size()==1) {
			user = users.get(0);
		}
		return user;
	}
	/**
	 * 修改头像
	 */
	@Override
	public boolean updatePhoto(int uid, String userpic) {
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAOImpl();
		User user = findUserById(uid);
		if(user!=null) {
			user.setUserpic(userpic);
			int rows = ud.updateUser(user);
			if(rows==1) {
				return true;
			}
		}
		return false;
	}
	
}
