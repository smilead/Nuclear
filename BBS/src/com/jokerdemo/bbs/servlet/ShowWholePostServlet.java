package com.jokerdemo.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jokerdemo.bbs.dao.impl.UserDAOImpl;
import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowUserServlet
 */
public class ShowWholePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowWholePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//2.获取参数
		String uidstr =request.getParameter("uid");
		String pidstr =request.getParameter("pid");
		int uid=Integer.parseInt(uidstr);
		UserDAOImpl udi=new UserDAOImpl();
		//传递user
		request.setAttribute("user", udi.quicklyFind(uid));
		//
	}

}
