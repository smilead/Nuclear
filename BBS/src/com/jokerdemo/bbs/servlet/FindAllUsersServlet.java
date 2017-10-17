package com.jokerdemo.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.po.PageModel;
import com.jokerdemo.bbs.service.UserService;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class FindAllUsersServlet
 */
public class FindAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllUsersServlet() {
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
		String currentPageStr = request.getParameter("currentPage");
		String pageSizeStr = request.getParameter("pageSize");
		int currentPage = Integer.parseInt(currentPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")!=null) {
			UserService ud = new UserServiceImpl();
			PageModel<User> userPage = ud.findUsersByPage(currentPage, pageSize);
			request.setAttribute("page", userPage);
			request.getRequestDispatcher("admin/user/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
	
		
		
	}

}
