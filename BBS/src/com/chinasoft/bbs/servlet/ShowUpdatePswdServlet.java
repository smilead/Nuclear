package com.chinasoft.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bbs.service.UserService;
import com.chinasoft.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowUpdatePswdServlet
 */
public class ShowUpdatePswdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdatePswdServlet() {
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
		String username = request.getParameter("username");
		String answer = request.getParameter("answer");
		username = new String(username.getBytes("iso-8859-1"),"utf-8");
		answer = new String(answer.getBytes("iso-8859-1"),"utf-8");
		UserService us =new UserServiceImpl();
		boolean flag = us.checkAnswer(username, answer);
		response.getWriter().print(flag);

	}

}
