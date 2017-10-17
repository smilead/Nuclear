package com.jokerdemo.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.entity.Post;
import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.PostService;
import com.jokerdemo.bbs.service.UserService;
import com.jokerdemo.bbs.service.impl.PostServiceImpl;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class PostingServlet
 */
public class PostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.设置编码
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			UserService us = new UserServiceImpl();
			String article = request.getParameter("article");
			String ptitle=request.getParameter("ptitle");
			String type=request.getParameter("type");
			HttpSession session=request.getSession();
			Object userObj=session.getAttribute("user");
			if(userObj==null) {
				session.setAttribute("msg", "您尚未登陆请重新登陆");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				User user=(User)userObj;
				int uid=user.getUid();
				Post post=new Post();
				post.setArticle(article);
				post.setUid(uid);
				post.setType(type);
				post.setPtitle(ptitle);
				System.out.println(ptitle);
				post.setEnclosure("null");
				PostService postService=new PostServiceImpl();
				post=postService.addPostService(post);
				if(post!=null) {
					request.setAttribute("msg", "发帖成功");
					us.addUserExp(uid, 15);
					user.setExp(user.getExp()+15);
					session.setAttribute("user", user);
					request.setAttribute("post", post);
					request.getRequestDispatcher("showOnePost.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "发帖失败");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}
			
				
	}

}
