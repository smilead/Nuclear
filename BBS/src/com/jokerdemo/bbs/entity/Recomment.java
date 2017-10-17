package com.jokerdemo.bbs.entity;

import java.util.Date;

public class Recomment {
	private int rid;
	private String recontent;
	private int uid;
	private Date ctime;
	private int cid;
	//前台页面显示需要下列属性
	private String pixname;
	private String level;
	
	
	public String getPixname() {
		return pixname;
	}
	public void setPixname(String pixname) {
		this.pixname = pixname;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
}
