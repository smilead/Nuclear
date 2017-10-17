package com.chinasoft.bbs.service.impl;

import com.chinasoft.bbs.dao.PostDAO;
import com.chinasoft.bbs.dao.impl.PostDAOImpl;
import com.chinasoft.bbs.po.PostsPage;
import com.chinasoft.bbs.service.PostsService;

public class PostsServiceImpl implements PostsService{
	private PostDAO postDAO=new PostDAOImpl();
	@Override
	public PostsPage selectPostsorderBy(String sel, String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		currentPage=currentPage-1;
		return postDAO.selectPostsOrderBy(sel, type, currentPage, pageSize);
	}

	@Override
	public PostsPage selectPostsRecently(int date,String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		currentPage=currentPage-1;
		return postDAO.selectPostsRecently(date, type,currentPage, pageSize);
	}

	@Override
	public PostsPage selectPostsByValue(String sel, Object obj,String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		currentPage=currentPage-1;
		return postDAO.selectPostsByValue(sel, obj, type,currentPage, pageSize);
	}

	@Override
	public PostsPage selectPostsVague(String sel,String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		currentPage=currentPage-1;
		return postDAO.selectPostsVague(sel, type, currentPage, pageSize);
	}

	@Override
	public PostsPage selectPostsBetween(String sel, String type,Object min, Object max, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		currentPage=currentPage-1;
		return postDAO.selectPostsBetween(sel,type, min, max, currentPage, pageSize);
	}

}
