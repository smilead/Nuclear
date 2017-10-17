package com.chinasoft.bbs.servlet.post;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.bbs.entity.MiniPost;
import com.chinasoft.bbs.po.PostsPage;
import com.chinasoft.bbs.service.PostsService;
import com.chinasoft.bbs.service.impl.PostsServiceImpl;

/**
 * Servlet implementation class PostsSelectVagueServlet
 */
public class PostsSelectVagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsSelectVagueServlet() {
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
		HttpSession session=request.getSession();
		session.setAttribute("requestPath", request.getServletPath());
		PostsService postsService=new PostsServiceImpl();	
		//获取板块信息
		String type=request.getParameter("type");
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
			session.setAttribute("type", type);
		}
		String sel=request.getParameter("sel");
		if(sel==null) {
			Object selObj=session.getAttribute("sel");
			if(selObj!=null) {
				sel=(String)selObj;	
			}
		}else {
			sel=new String(sel.getBytes("iso-8859-1"),"utf-8");
			session.setAttribute("sel", sel);
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
		int currentPage=1;
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr!=null) {
			currentPage=Integer.parseInt(currentPageStr);
		}
		PostsPage postsPage=postsService.selectPostsVague( sel, type, currentPage, pageSize);
		if(postsPage==null) {
			request.setAttribute("msg", "您搜索的帖子不存在");
		}else {
			request.setAttribute("postsPage", postsPage);
			
		}
		String sourcePath=request.getParameter("sourcePath");
		if(sourcePath!=null) {
			session.setAttribute("sourcePath", sourcePath);
			request.getRequestDispatcher("admin/post/indexManager.jsp").forward(request, response);						
		}else {
			Object sourcePathObj=session.getAttribute("sourcePath");
			if(sourcePathObj!=null) {
				request.getRequestDispatcher("admin/post/indexManager.jsp").forward(request, response);			
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response);					
			}
		}
	}

}
