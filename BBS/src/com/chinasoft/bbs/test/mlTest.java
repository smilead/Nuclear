package com.chinasoft.bbs.test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.chinasoft.bbs.entity.User;
import com.chinasoft.bbs.service.UserService;
import com.chinasoft.bbs.service.impl.UserServiceImpl;

public class mlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//批量注册
		UserService us = new UserServiceImpl();
		for(int j=0;j<500;j++){
			String username = "Joker-";
			String password = "";
			Random rand = new Random();
			for(int i=0;i<8;i++){
				char ch = (char) (rand.nextInt(26)+97);
				username += ch;
				password += ch;
			}
			boolean flag = us.registerService(username, password);
			
		}
		System.out.println("写入成功");
		//注册
//		UserService us = new UserServiceImpl();
//		boolean flag = us.registerService("liyalong", "123");
//		if(flag){
//			System.out.println("注册成功");
//		}else{
//			System.out.println("用户名已被占用");
//		}
		//登录
//		ArrayList al = new ArrayList();
//		System.out.println(al.size());
//		Calendar cl = Calendar.getInstance();
//		System.out.println(cl.getTime());
//		User user = us.loginService("username", "李亚龙", "111");
//		if(user!=null){
//			System.out.println(user.getUsername()+"登录成功，经验值："+user.getExp()+",级别："+user.getLevel());			
//		}
//		//修改
//		user.setAge(20);
//		user.setEmail("82312@qq.com");
//		user.setLevel("高级会员");
//		user.setPassword("111");
//		user.setPixname("ML");
		
//		user.setSafeanswer("0812");
//		user.setSafeques("你的生日是");
//		user.setSex("男");
//		user.setStatus(2);
//		user.setTel("13191772385");
//		user.setUsername("李亚龙");
//		user.setUserpic("liyalong.jpg");
//		boolean flag = us.upadateUserService(user);
//		if(flag){
//			System.out.println("修改成功！！！");
//		}else{
//			System.out.println("修改失败！！！");
//		}
	}

}
