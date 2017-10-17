package com.jokerdemo.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.CommentService;
import com.jokerdemo.bbs.service.UserService;
import com.jokerdemo.bbs.service.impl.CommentServiceImpl;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		PrintWriter out = response.getWriter();
		UserService us = new UserServiceImpl();
		String content = request.getParameter("content");
		String uidStr = request.getParameter("uid");
		String pidStr = request.getParameter("pid");
		int uid = Integer.parseInt(uidStr);
		int pid = Integer.parseInt(pidStr);
		CommentService cs = new CommentServiceImpl();
		boolean flag = cs.addComment(content, uid, pid);
		if(flag) {
			us.addUserExp(uid, 10);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			user.setExp(user.getExp()+10);
			session.setAttribute("user", user);
			out.print("<script type='text/javascript'>alert('评论成功,增加10经验')</script>");
		}else {
			out.print("<script type='text/javascript'>alert('评论失败')</script>");
		}
		response.sendRedirect("/BBS/ShowOnePostServlet?pid="+pid);
	}

}
