package com.chinasoft.bbs.service;

import com.chinasoft.bbs.po.PostsPage;

public interface PostsService {
	//按时间或热度分板块查询
	public PostsPage selectPostsorderBy(String sel, String type, int currentPage, int pageSize);
	//查询近多少天的帖子
	public PostsPage selectPostsRecently(int date, String type,int currentPage, int pageSize) ;
	//定值查询，可定位是否为精品贴等
	public PostsPage selectPostsByValue(String sel, Object obj,String type, int currentPage, int pageSize);
	//模糊查询
	public PostsPage selectPostsVague(String sel, String type,int currentPage, int pageSize);
	//查询某区间可按时间、浏览亮等排序
	public PostsPage selectPostsBetween(String sel,String type, Object min, Object max, int currentPage, int pageSize);
}
