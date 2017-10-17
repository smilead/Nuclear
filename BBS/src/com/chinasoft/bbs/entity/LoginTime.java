package com.chinasoft.bbs.entity;

import java.sql.Date;

/**
 * 登录记录
 * @author Administrator
 *
 */
public class LoginTime {
	private Date logintime;//登录时间
	private int uid;//用户编号
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
