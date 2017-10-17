package com.jokerdemo.bbs.entity;


import java.sql.Date;

import com.jokerdemo.bbs.po.CommentPage;

public class Post {
	private int pid;
	private String ptitle;
	private String article;
	private String enclosure;
	private int uid;
	private Date ptime;
	private int pageView;
	private int level;
	private String type;
	private int competitive;
	private User user;
	private int commentCount;
	private	CommentPage commentPage;
	
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public CommentPage getCommentPage() {
		return commentPage;
	}
	public void setCommentPage(CommentPage commentPage) {
		this.commentPage = commentPage;
	}
	public int getCompetitive() {
		return competitive;
	}
	public void setCompetitive(int competitive) {
		this.competitive = competitive;
	}
	public int getLevel() {
		return level;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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

	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
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


}
