package com.chinasoft.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.bbs.entity.User;
import com.chinasoft.bbs.service.UserService;
import com.chinasoft.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		String pixname = request.getParameter("pixname");
		String sex = request.getParameter("sex");
		String ageStr = request.getParameter("age");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String safeQuestion = request.getParameter("safeQuestion");
		String safeAnswer = request.getParameter("safeAnswer");
		int uid = Integer.parseInt(uidStr);
		int age = Integer.parseInt(ageStr);
		UserService us = new UserServiceImpl();
		boolean flag = us.updateUser(uid, pixname, sex, age, email, tel, safeQuestion, safeAnswer);
		if(flag) {
			User user = us.findUserById(uid);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("/user/show.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
		}
		
	}

}
