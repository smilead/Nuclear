package com.chinasoft.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.bbs.entity.User;
import com.chinasoft.bbs.service.UserService;
import com.chinasoft.bbs.service.impl.UserServiceImpl;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UpdatePhotoServlet
 */
public class UpdatePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePhotoServlet() {
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
		PrintWriter out = response.getWriter();
		//1.创建smartupload对象
		SmartUpload su = new SmartUpload("utf-8");
		//2.初始化smartupload组件
		su.initialize(getServletConfig(), request, response);
		//设置上传类型
		su.setAllowedFilesList("jpg,gif,png");
		//设置大小为100M
		su.setMaxFileSize(100*1000*1024);
		try {
			//3.上传到临时文件中
			su.upload();
			//4.提取上传文件
			SmartFile smartFile  = su.getFiles().getFile(0);
			//提取尾缀jsp，txt
			String servletExt = smartFile.getFileExt();
			String servletPath = request.getRealPath("/")+"resource/img/photo";
			//5.准备上传路径和文件名 smartFile.isMissing()是否提取成功
			if(!smartFile.isMissing()){
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("user");
				String userpic = user.getUid()+"."+servletExt;
				smartFile.saveAs(servletPath+"/"+userpic);
				UserService us = new UserServiceImpl();
				boolean flag = us.updatePhoto(user.getUid(), userpic);
				if(flag) {
					user.setUserpic(userpic);
					session.setAttribute("user", user);
					request.getRequestDispatcher("/user/show.jsp").forward(request, response);
				}else {
					out.print("<script>alert('上传失败！');location='/user/edit-photo.jsp'</script>");
				}
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
			out.print("<script>alert('上传失败！');location='/user/edit-photo.jsp'</script>");
		}catch (SecurityException e) {
			e.printStackTrace();
			out.print("<script>alert('上传文件不能超过100M,而且只能上传jpg,gif,png文件')</script>");
		}
	}

}
