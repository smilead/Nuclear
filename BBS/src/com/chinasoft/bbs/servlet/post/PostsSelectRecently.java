package com.chinasoft.bbs.servlet.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.bbs.po.PostsPage;
import com.chinasoft.bbs.service.PostsService;
import com.chinasoft.bbs.service.impl.PostsServiceImpl;
public class PostsSelectRecently extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostsSelectRecently() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

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
		int date=1;
		String dateStr=request.getParameter("date");
		if(dateStr==null) {
			Object dateObj=session.getAttribute("date");
			if(dateObj!=null) {
				date=(int)dateObj;	
			}
		}else {
			date=Integer.parseInt(dateStr);
			session.setAttribute("date", date);
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
		
		PostsPage postsPage=postsService.selectPostsRecently(date, type, currentPage, pageSize);	
		System.out.println(date+type+currentPage+pageSize);
		if(postsPage==null) {
			request.setAttribute("msg", "你要查询的贴子不存在");
		}
	
		request.setAttribute("postsPage", postsPage);
		//考虑到和管理员通用同一servlet，因此转发方向需要进行判定
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
