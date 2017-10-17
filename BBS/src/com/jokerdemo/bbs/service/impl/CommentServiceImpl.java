package com.jokerdemo.bbs.service.impl;

import java.util.ArrayList;

import com.jokerdemo.bbs.dao.CommentDao;
import com.jokerdemo.bbs.dao.IRecDao;
import com.jokerdemo.bbs.dao.impl.CommentDaoImpl;
import com.jokerdemo.bbs.dao.impl.RecDaoImpl;
import com.jokerdemo.bbs.entity.Comment;
import com.jokerdemo.bbs.entity.Recomment;
import com.jokerdemo.bbs.service.CommentService;

public class CommentServiceImpl implements CommentService{

	@Override
	public int findCommentCounts(int pid) {
		// TODO Auto-generated method stub
		CommentDao cd = new CommentDaoImpl();
		IRecDao rd = new RecDaoImpl();
		ArrayList<Comment> comments = cd.findCommentBy("pid", pid);
		int nums = comments.size();
		for(Comment c:comments) {
			ArrayList<Recomment> recommends = rd.findByParam("cid", c.getCid());
			if(recommends!=null) {
				nums += recommends.size();
			}
		}
		return nums;
	}
	/**
	 * 发表评论业务
	 */
	@Override
	public boolean addComment(String content, int uid, int pid) {
		// TODO Auto-generated method stub
		CommentDao cd = new CommentDaoImpl();
		ArrayList<Comment> comments =  cd.findCommentBy("pid", pid);
		int floor = 0;
		if(comments.size()!=0) {
			Comment comment = comments.get(0);
			floor = comment.getFloor();
		}
		floor++;
		int rows = cd.addComment(content, uid, pid, floor);
		if(rows==1) {
			return true;
		}
		return false;
	}

}
