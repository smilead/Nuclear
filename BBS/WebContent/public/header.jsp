<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
		
    	#header{width:80%;height: 93px;border: 0px ;margin: auto;border-bottom:3px groove deepskyblue;background-image: url("${pageContext.request.contextPath }/resource/img/head.jpg");}
    	
</style>
<link rel="icon" href="${pageContext.request.contextPath}/resource/img/favicon.ico" type="image/x-icon">
<link rel="shortcuticon" href="${pageContext.request.contextPath}/resource/img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/bootstrap-3.3.7/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bbs.js"></script>
<div id="header">
    		<img id="logo" src="${pageContext.request.contextPath }/resource/img/logo.png" height="86px" width="93px" style="margin-left: 90px;float: left;">
			<span id="biaoyu" style="line-height: 93px;padding-left: 14px;font-size: 12px;color: #217BA6;float: left;margin-top: 22px;">Jocker论坛      你的羁绊</span>
			<div id="headercentre" style="float: left;width:320px;border: 0px;margin-left: 70px;"><h1>Joker BBS</h1></div>
    		
    		<span id="el" style="margin-top: 10px;font-size: 16px">
	    		<c:if test="${empty sessionScope.user}">
					请<a href="${pageContext.request.contextPath }/login.jsp">登录</a>或者<a href="${pageContext.request.contextPath }/register.jsp ">注册</a>
				</c:if>
				<c:if test="${not empty sessionScope.user}">
				<div id="show" style="width:12%;border: 0px  ;float: right;margin-top: 1px;font-size: 13px;">
				<label>用户名：</label><a href="${pageContext.request.contextPath }/user/show.jsp">${user.username}</a><br>
				<label>等级：</label>${user.level}<br>
				<label>经验：</label>${user.exp}<br>
				<a href="DeleteSessionServlet">退出</a>
				</div>
				<div style="float:right;padding-right:10px;">
				<img src="${pageContext.request.contextPath }/resource/img/photo/${user.userpic}" style="width:90px;height:90px; border-radius: 45px;"/>
				</div>
				</c:if> 
				
			</span>
    	</div>