package com.jokerdemo.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.UserService;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CheckPasswordServlet
 */
public class CheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPasswordServlet() {
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
		String uidStr = request.getParameter("uid");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		int uid = Integer.parseInt(uidStr);
		UserService us = new UserServiceImpl();
		User user = us.findUserById(uid);
		if(user!=null && password.equals(user.getPassword())) {
			out.print(true);
		}else {
			
			out.print(false);
		}
	}

}
