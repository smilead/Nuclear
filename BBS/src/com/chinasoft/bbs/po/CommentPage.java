package com.chinasoft.bbs.po;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.chinasoft.bbs.entity.Comment;
import com.chinasoft.bbs.entity.User;

public class CommentPage {
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private int currentPage;
	private ArrayList<Comment> comments;
	private ArrayList<User> users;
	//private ArrayList<Recomment> recomments;
	
	public ArrayList<User> getUsers() {
		
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
