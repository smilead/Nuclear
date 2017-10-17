package com.jokerdemo.bbs.dao;

import java.util.ArrayList;

import com.jokerdemo.bbs.entity.MiniPost;
import com.jokerdemo.bbs.entity.Post;
import com.jokerdemo.bbs.po.PostsPage;

public interface PostDAO {
	public Post addPost(Post post);//发帖
	public boolean deletePost(int pid);//删帖
	public boolean updatePost(int pid,String[] sels,Object[] objs);//更新
	public Post selectOnePost(int pid);//查看帖子
	public PostsPage selectPostsOrderBy(String sel,String type,int currentPage,int pageSize);
	public PostsPage selectPostsRecently(int date,String type,int currentPage,int pageSize);
	public PostsPage selectPostsByValue(String sel,Object obj,String type,int currentPage,int pageSize);
	public PostsPage selectPostsVague(String sel,String type,int currentPage,int pageSize);
	public PostsPage selectPostsBetween(String sel,String type,Object min,Object max,int currentPage,int pageSize);
	public PostsPage construction(ArrayList<MiniPost> miniPosts,int totalCount,int currentPage,int pagesize);
}
