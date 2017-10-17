package com.chinasoft.bbs.test;

import java.util.ArrayList;

import com.chinasoft.bbs.dao.CommentDao;
import com.chinasoft.bbs.dao.impl.CommentDaoImpl;
import com.chinasoft.bbs.entity.Comment;
import com.chinasoft.bbs.po.CommentPage;

public class CommentTest {
	public static void main(String[] args) {
		int pid=10;
		CommentDao cd=new CommentDaoImpl();
	//	cd.deletComment(pid);
		CommentPage commentPage=cd.selectCommentPage("pid", 10, 1, 5);
		ArrayList<Comment> comments=commentPage.getComments();
		for(Comment comment:comments) {
			System.out.println("---------------");
			System.out.println(comment.getCid());
			System.out.println(comment.getContent());
			System.out.println(comment.getContentpic());
			System.out.println(comment.getCid());
		}
	}
}
