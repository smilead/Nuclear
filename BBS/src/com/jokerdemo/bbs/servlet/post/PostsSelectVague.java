package com.jokerdemo.bbs.servlet.post;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.entity.MiniPost;
import com.jokerdemo.bbs.po.PostsPage;
import com.jokerdemo.bbs.service.PostsService;
import com.jokerdemo.bbs.service.impl.PostsServiceImpl;

/**
 * Servlet implementation class PostsSelectVague
 */
public class PostsSelectVague extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsSelectVague() {
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
			response.getWriter().print("###");
			System.out.println("###");
		}else {
			ArrayList<MiniPost> miniPosts=postsPage.getMiniPosts();
			MiniPost miniPost=miniPosts.get(0);
			String str="<a href=\"ShowOnePostServlet?pid="+miniPost.getPid()+"\">"+miniPost.getPtitle()+"  "+miniPost.getPreview()+"  "+miniPost.getType()+" "+miniPost.getPixname()+"</a>";
			for(int i=1;i<miniPosts.size();i++) {
				miniPost=miniPosts.get(i);				
				str=str+"??<a href=\"ShowOnePostServlet?pid="+miniPost.getPid()+"\">"+miniPost.getPtitle()+"  "+miniPost.getPreview()+"  "+miniPost.getType()+"  "+miniPost.getPixname()+"</a>";
			}
			response.getWriter().print(str);

		}
		
//		request.getRequestDispatcher("smileTest.jsp").forward(request, response);

	}

}
