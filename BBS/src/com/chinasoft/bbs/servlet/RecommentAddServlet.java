package com.chinasoft.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.bbs.entity.User;
import com.chinasoft.bbs.service.PostService;
import com.chinasoft.bbs.service.impl.PostServiceImpl;
import com.chinasoft.bbs.service.impl.RecServiceImpl;

/**
 * Servlet implementation class RecommentAddServlet
 */
public class RecommentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommentAddServlet() {
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
		Object userObj=session.getAttribute("user");
		if(userObj==null) {
			request.setAttribute("msg", "您需要登陆后在进行评论");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			User user=(User)userObj;
			int uid=user.getUid();
			RecServiceImpl recService=new RecServiceImpl();
			String rcotent=request.getParameter("rcoten");
			System.out.println(rcotent);
			System.out.println(request.getParameter("cid"));
			System.out.println(request.getParameter("pid"));
			System.out.println(uid);
			int cid=Integer.parseInt(request.getParameter("cid"));
			int pid=Integer.parseInt(request.getParameter("pid"));
			if(recService.addReco(rcotent, uid, cid)) {
				PostService postService=new PostServiceImpl();
				request.setAttribute("post", postService.selectOnePostService(pid));
				request.getRequestDispatcher("showOnePost.jsp").forward(request, response);
			}else {
				System.out.println("error");
			}		
		}
		
	}

}
