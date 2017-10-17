package com.jokerdemo.bbs.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Comment {
	private int cid;
	private String content;
	private String contentpic;
	private int uid;
	private Date ctime;
	private int pid;
	private int floor;
	
	
	//前台显示需要下列属性
	private String level;
	private String pixname;
	private String userPic;
	private ArrayList<Recomment> recomments=new ArrayList<Recomment>();
	
	
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public ArrayList<Recomment> getRecomments() {
		return recomments;
	}
	public void setRecomments(ArrayList<Recomment> recomments) {
		this.recomments = recomments;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPixname() {
		return pixname;
	}
	public void setPixname(String pixname) {
		this.pixname = pixname;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentpic() {
		return contentpic;
	}
	public void setContentpic(String contentpic) {
		this.contentpic = contentpic;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
}
