package com.jokerdemo.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.UserService;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AdminIndexServlet
 */
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService us = new UserServiceImpl();
		HttpSession session = request.getSession();
		User user = us.loginService("username", username, password);
		
		if(user!=null&&user.getStatus()>100) {
			session.setAttribute("admin", user);
			request.getRequestDispatcher("/admin/post/indexManager.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "验证无效，请重新登录");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
			
		}
		
	}

}
