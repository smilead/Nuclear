package com.jokerdemo.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.po.PostsPage;
import com.jokerdemo.bbs.service.PostsService;
import com.jokerdemo.bbs.service.impl.PostsServiceImpl;

/**
 * Servlet implementation class IndexInitServlet
 */
public class IndexInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostsService postsService=new PostsServiceImpl();
		HttpSession session=request.getSession();
		String type="index";
		Object typeObj=session.getAttribute("type");
		if(typeObj!=null) {
			type=(String)typeObj;
		}else {
			session.setAttribute("type", type);
		}
		
		String parame="ptime";
		Object parameObj=session.getAttribute("parame");
		if(parameObj!=null) {
			parame=(String)parameObj;	
		}else {
			session.setAttribute("parame", parame);
		}
		int currentPage=1;
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr!=null) {
			currentPage=Integer.parseInt(currentPageStr);
		}
		
		int pageSize=10;
		String pageSizeStr=request.getParameter("pageSize");
		if(pageSizeStr==null) {
			Object pageSizeObj=session.getAttribute("pageSize");
			if(pageSizeObj==null) {
				session.setAttribute("pageSize", pageSize);
			}else {
				pageSize=(int)pageSizeObj;
			}
		}else {
			pageSize=Integer.parseInt(pageSizeStr);
			session.setAttribute("pageSize", pageSize);
		}
		
		PostsPage postsPage=postsService.selectPostsorderBy(parame, type, currentPage, pageSize);
		request.setAttribute("postsPage", postsPage);
		String var=request.getParameter("sourcePath");
		if(var==null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("admin/post/indexManager.jsp").forward(request, response);
		}
	}

}
