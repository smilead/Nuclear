package com.jokerdemo.bbs.service;

public interface CommentService {
	public int findCommentCounts(int pid);
	/**
	 * 评论业务
	 */
	boolean addComment(String content, int uid, int pid);
}
