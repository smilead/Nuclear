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
 * Servlet implementation class PostsSelectBetweenTime
 */
public class PostsSelectBetweenTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostsSelectBetweenTime() {
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
			}
		}else {
			type=new String(type.getBytes("iso-8859-1"),"utf-8");
			session.setAttribute("type", type);
		}
		System.out.println(type);
		String min=request.getParameter("min");
		if(min==null) {
			Object minObj=session.getAttribute("min");
			if(minObj!=null) {
				min=(String)minObj;
			}
		}else {
			session.setAttribute("min", min);
		}
		String max=request.getParameter("max");
		if(max==null) {
			Object maxObj=session.getAttribute("max");
			if(maxObj!=null) {
				max=(String)maxObj;
			}
		}else {
			session.setAttribute("max", max);
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
		
		PostsPage postsPage=postsService.selectPostsBetween("ptime", type, min, max, currentPage, pageSize);
		if(postsPage==null) {
			request.setAttribute("msg", "您查询的时间短内不存在帖子");
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
