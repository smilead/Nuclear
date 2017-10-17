package com.chinasoft.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bbs.entity.Post;
import com.chinasoft.bbs.service.PostService;
import com.chinasoft.bbs.service.impl.PostServiceImpl;

public class ShowOnePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowOnePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		System.out.println(pid);
		PostService postService=new PostServiceImpl();
		Post post=postService.selectOnePostService(Integer.parseInt(pid));
		if(post==null) {
			request.setAttribute("msg", "您要浏览的帖子不存在，请重新选择");
			request.getRequestDispatcher("smileTest.jsp").forward(request, response);
		}else {
			request.setAttribute("post", post);
			request.getRequestDispatcher("showOnePost.jsp").forward(request, response);
		}
	}
}
