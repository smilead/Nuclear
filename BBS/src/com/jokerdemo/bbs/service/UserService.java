package com.jokerdemo.bbs.service;

import java.util.ArrayList;

import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.po.PageModel;

/**
 * 用户类业务接口
 * @author BlackButterfly
 *
 */
public interface UserService {
	/**
	 * 注册业务接口
	 */
	boolean registerService(String username, String password);
	/**
	 * 登录业务接口
	 */
	User loginService(String sel, String str, String password);
	/**
	 * 
	 */
	ArrayList<User> findUsersByUids(ArrayList<Integer> uids);
	/**
	 * 查找用户名是否存在
	 */
	boolean checkUsername(String username);
	/**
	 * 通过用户名查找安全问题
	 */
	String findQuestionByUsername(String username);
	/**
	 * 检查答案是否正确
	 */
	boolean checkAnswer(String username,String answer);
	/**
	 * 修改密码
	 */
	boolean updatePassword(String username, String password);
	/**
	 * 分页查询业务
	 */
	PageModel<User> findUsersByPage(int currentPage, int pageSize);
	/**
	 * 修改状态
	 */
	boolean changeStatus(int uid);
	/**
	 * 模糊查询
	 */
	PageModel<User> findUsersLike(String str, int currentPage, int pageSize);
	/**
	 * 修改个人信息
	 */
	boolean updateUser(int uid, String pixname, String sex, int age, String email, String tel, String safeQuestion, String safeAnswer);
	/**
	 * 通过id查询User
	 */
	User findUserById(int uid);
	/**
	 * 更改头像
	 */
	boolean updatePhoto(int uid, String userpic);
	/**
	 * 增加经验
	 * @param uid
	 * @param exp
	 * @return
	 */
	boolean addUserExp(int uid, int exp);
}
