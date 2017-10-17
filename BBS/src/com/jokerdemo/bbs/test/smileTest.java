package com.jokerdemo.bbs.test;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jokerdemo.bbs.entity.Post;
import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.po.PostsPage;
import com.jokerdemo.bbs.service.PostService;
import com.jokerdemo.bbs.service.PostsService;
import com.jokerdemo.bbs.service.impl.PostServiceImpl;
import com.jokerdemo.bbs.service.impl.PostsServiceImpl;
import com.jokerdemo.bbs.util.DBUtil;

public class smileTest {
	public static void main(String[] args) throws SQLException {
		DBUtil db=new DBUtil();
		ResultSet rs=db.execQuery("select * from user",new Object[]{});
		while(rs.next()) {
			System.out.println(rs.getString("username"));
		}
		
		//	Connection conn=DBUtil2.getConnection();
	
		//DBUtil2.releaseConnection(conn);
		//PostService postService=new PostServiceImpl();
	//	PostsService postsService=new PostsServiceImpl();
		//Post post=new Post();
		//System.out.println("发帖");
		//setNoId(post);
		//post=postService.addPostService(post);
		//show(post);
//		System.out.println("删帖");
//		postService.deletePostService(21);
//		
//		System.out.println("贴子更新");
//		
//		postService.updatePostService(18, new String[] {"article","pageview"}, new Object[] {"sdfasd",4});
//		show(post);
//		
//		System.out.println("查看帖子");
//		post=postService.selectOnePostService(23);
//		show(post);
//		PostsService postsService=new PostsServiceImpl();
//		System.out.println("查询所有按浏览量查询");
//		PostsPage postsPage=postsService.selectPostsBetween("pageview","灌水区", -1, 5, 0, 5);
//		show(postsPage);
//		
//		System.out.println("精品贴");
//		System.out.println("灌水区");
//		System.out.println("按照日期排序查询");
	//	PostsPage postsPage=postsService.selectPostsorderBy("type", "灌水区", 0, 5);
		//show(postsPage);
		
//		System.out.println("按浏览量排序查询");
//		System.out.println("查询浏览量多少到多少");
//		System.out.println("按标题查询");
//		System.out.println("按照内容查询");
//		System.out.println("查询某年某月到某年某月");
//		System.out.println("灌水区");
//		System.out.println("按照日期排序查询");
//		System.out.println("按浏览量排序查询");
		
	}
	public static void show(Post post) {
		System.out.println("pid"+post.getPid());
		System.out.println("标题"+post.getPtitle());
		System.out.println("主题"+post.getArticle());
		System.out.println("附件"+post.getEnclosure());
		System.out.println("level"+post.getLevel());
		System.out.println("浏览量"+post.getPageView());
		System.out.println("uid"+post.getUid());
		System.out.println("时间"+post.getPtime());
		System.out.println("板块"+post.getType());
		System.out.println("---------------");
	}
	public static void setNoId(Post post) {
		post.setArticle("这2222");
		post.setPtitle("这是22222lklkjl22");
		post.setType("天天军事");
		post.setUid(999);
		post.setEnclosure("无");
		
	}
	public static void show(PostsPage postsPage){
		if(postsPage==null) {
			System.out.println("null");
		}else {
			System.out.println("分页大小"+postsPage.getPageSize());
			System.out.println("总页数"+postsPage.getTotalPage());
			System.out.println("总条数"+postsPage.getTotalCount());
			System.out.println("当前页码"+postsPage.getCurrentPage());		
		}
	}
	
}
