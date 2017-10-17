package com.jokerdemo.bbs.servlet.post;

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
 * Servlet implementation class PostsSelectVaguePtitle
 */
public class PostsSelectVaguePtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsSelectVaguePtitle() {
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
		System.out.println("servlet");
		HttpSession session=request.getSession();
		session.setAttribute("requestPath", request.getServletPath());
		System.out.println(request.getServletPath());
		PostsService postsService=new PostsServiceImpl();	
		//获取板块信息
		String type=request.getParameter("type");
		System.out.println(type);
		if(type==null) {
			Object typeObj=session.getAttribute("type");
			if(typeObj!=null) {
				type=(String)typeObj;
			}else {
				type="index";
				session.setAttribute("type", type);
			}
		}else {
			type=new String(type.getBytes("iso-8859-1"),"utf-8");
			System.out.println(type);
			session.setAttribute("type", type);
		}
		System.out.println(type);
		String var=request.getParameter("ptitle");
		if(var==null) {
			Object ptitleObj=session.getAttribute("ptitle");
			if(ptitleObj!=null) {
				var=(String)ptitleObj;	
			}
		}else {
			session.setAttribute("ptitle", var);
		}
		System.out.println(var);
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
		System.out.println(session.getId());
		int currentPage=1;
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr!=null) {
			currentPage=Integer.parseInt(currentPageStr);
		}
		
		PostsPage postsPage=postsService.selectPostsVague( var, type, currentPage, pageSize);
		System.out.println(var+type+currentPage+pageSize);
		if(postsPage==null) {
			request.setAttribute("msg", "您搜索的标题不存在");
		}
		request.setAttribute("postsPage", postsPage);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
