package com.jokerdemo.bbs.entity;

import java.util.ArrayList;
import java.util.Date;

public class MiniPost {
	private int pid;
	private String ptitle;
	private int uid;
	private Date ptime;
	private int pageView;
	private int level;
	private String type;
	private int competitive;
	private String pixname;
	private String userLevel;
	private int commentTotal;
	private String  preview;
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public int getCommentTotal() {
		return commentTotal;
	}
	public void setCommentTotal(int commentTotal) {
		this.commentTotal = commentTotal;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public int getPageView() {
		return pageView;
	}
	public void setPageView(int pageView) {
		this.pageView = pageView;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCompetitive() {
		return competitive;
	}
	public void setCompetitive(int competitive) {
		this.competitive = competitive;
	}
	public String getPixname() {
		return pixname;
	}
	public void setPixname(String pixname) {
		this.pixname = pixname;
	}
	
}
