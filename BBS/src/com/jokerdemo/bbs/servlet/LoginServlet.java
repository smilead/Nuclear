package com.jokerdemo.bbs.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;


/**
 * 登录Servlet
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String sel = request.getParameter("select");
		String str = request.getParameter("str");
		String password = request.getParameter("password");
		String[] autos = request.getParameterValues("auto");
		boolean auto = false;
		if(autos!=null) {
			auto = true;
		}
		
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.loginService(sel, str, password);
		if(user!=null && user.getStatus()>=0){
			ServletContext application = this.getServletContext();
			int count = 0;
			Object countObj = application.getAttribute("count");
			if(countObj==null){
				count = 1;
			}else{
				count = Integer.parseInt(countObj.toString());
				count++;
			}
			application.setAttribute("count", count);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("user", user);
			if(auto){
				Cookie cookieSel = new Cookie("sel",sel);
				Cookie cookieStr = new Cookie("str",URLEncoder.encode(str,"utf-8"));
				Cookie cookiePassword = new Cookie("password",password);
				cookieSel.setMaxAge(10*360*24*3600);
				cookieStr.setMaxAge(10*360*24*3600);
				cookiePassword.setMaxAge(10*360*24*3600);
				response.addCookie(cookieSel);
				response.addCookie(cookieStr);
				response.addCookie(cookiePassword);
			}
			request.getRequestDispatcher("IndexInitServlet").forward(request, response);
		}else{
			if(user!=null && user.getStatus()<0) {
				request.setAttribute("msg", "该用户已被封禁！！！");
			}
			else if("username".equals(sel)){
				request.setAttribute("msg", "用户名或密码错误！！！");
			}else if("tel".equals(sel)){
				request.setAttribute("msg", "手机号或密码错误！！！");
			}else if("email".equals(sel)){
				request.setAttribute("msg", "邮箱或密码错误！！！");
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
