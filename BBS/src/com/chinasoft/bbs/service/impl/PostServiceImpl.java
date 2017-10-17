package com.chinasoft.bbs.service.impl;

import com.chinasoft.bbs.dao.UserDAO;
import com.chinasoft.bbs.dao.impl.PostDAOImpl;
import com.chinasoft.bbs.dao.impl.UserDAOImpl;
import com.chinasoft.bbs.entity.Post;
import com.chinasoft.bbs.service.PostService;

public class PostServiceImpl implements PostService{
	private PostDAOImpl postDAO=new PostDAOImpl();
	
	@Override
	public Post addPostService(Post post) {
		// TODO Auto-generated method stub
		return postDAO.addPost(post);
	}

	@Override
	public boolean updatePostService(int pid,String[] sels,Object[] objs) {
		// TODO Auto-generated method stub
		return postDAO.updatePost(pid, sels, objs);
	}

	@Override
	public boolean deletePostService(int pid) {
		// TODO Auto-generated method stub
		return postDAO.deletePost(pid);
	}

	@Override
	public Post selectOnePostService(int pid) {
		// TODO Auto-generated method stub
		Post post=postDAO.selectOnePost(pid);
		if(post!=null) {
		UserDAO userDao=new UserDAOImpl();
		post.setUser(userDao.findUserBy("uid", post.getUid()).get(0));
		return post;
		}else {
			return null;
		}
	}

}
