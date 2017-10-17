package com.jokerdemo.bbs.service;

import com.jokerdemo.bbs.entity.Post;

public interface PostService {
	public Post addPostService(Post post);
	public boolean updatePostService(int pid,String[] sels,Object[] objs);
	public boolean deletePostService(int pid);
	public Post selectOnePostService(int pid);

}
