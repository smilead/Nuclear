package com.jokerdemo.bbs.dao;

import java.util.ArrayList;

import com.jokerdemo.bbs.entity.Comment;
import com.jokerdemo.bbs.po.CommentPage;


public interface CommentDao {
	public int addComment(String content, int uid, int pid, int floor);
	public boolean deletComment(int cid);
	public Comment updateComment(Comment comment);
	ArrayList<Comment> findCommentBy(String sel, Object obj);
	public CommentPage selectCommentPage(String sel, Object obj, int currentPage, int pageSize);
}
