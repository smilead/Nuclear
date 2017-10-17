package com.chinasoft.bbs.po;

import java.util.ArrayList;

import com.chinasoft.bbs.entity.MiniPost;

public class PostsPage {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	public ArrayList<MiniPost> MiniPosts;
	
	public ArrayList<MiniPost> getMiniPosts() {
		return MiniPosts;
	}
	public void setMiniPosts(ArrayList<MiniPost> miniPosts) {
		MiniPosts = miniPosts;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
