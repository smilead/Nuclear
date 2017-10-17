package com.chinasoft.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bbs.entity.Post;
import com.chinasoft.bbs.service.impl.PostServiceImpl;

/**
 * Servlet implementation class PreCheckPost
 */
public class PreCheckPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreCheckPost() {
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
		//2.获取参数
		int pid= Integer.parseInt(request.getParameter("pid"));
		//3.业务调用
		PostServiceImpl psi=new PostServiceImpl();
		Post post=psi.selectOnePostService(pid);
		if(post!=null){
			System.out.println("存在该pid");
			response.sendRedirect("ShowOnePostServlet");
		}else{
			System.out.println("不存在该ID");
			request.setAttribute("msg", "此贴已不存在！");
			response.sendRedirect("index.jsp");
		}
	}

}
