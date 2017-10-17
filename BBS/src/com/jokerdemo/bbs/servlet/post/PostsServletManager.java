package com.jokerdemo.bbs.servlet.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostsServletManager
 */
public class PostsServletManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsServletManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String currentPageStr=(String)request.getParameter("currentPage");
		if(currentPageStr!=null) {
			int currentPage=Integer.parseInt(currentPageStr);
			request.setAttribute("currentPage", currentPage);
		}
	
		Object requestPathObj=session.getAttribute("requestPath");
		if(requestPathObj==null) {
			request.getRequestDispatcher("IndexInitServlet").forward(request, response);
		}else {
			String requestPath=(String)requestPathObj;
			request.getRequestDispatcher(requestPath).forward(request, response);	
		}
	
		
	}

}
