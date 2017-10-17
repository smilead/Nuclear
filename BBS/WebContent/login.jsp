<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/loginRegister.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/my.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/varcode.js"></script>
<title>Joker账号登录</title>
<script type="text/javascript">  
function checkLogin(){
	var color = document.getElementById("msg").style.color;
	if(color=="green"){
		var str = document.getElementById("str").value;
		var password = document.getElementById("pswd").value;
		var select = document.getElementById("select").value;
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(str==""){
			if(select=="tel"){
			alert("手机不能为空！！！");
			}else if(select=="email"){
			alert("邮箱不能为空！！！");
			}else{
			alert("用户名不能为空！！！");
			}
		}else if(password==""){
			alert("密码不能为空");
		}else if(select=="email" && !filter.test(str)){
			 alert('您的电子邮件格式不正确');
		}else if(select=="tel" && !(/^1[34578]\d{9}$/.test(str))){
			 alert("您的手机格式不正确"); 
		}else{
			document.getElementById("loginform").submit();
		}
	}else{
		document.getElementById("msg").innerHTML="请输入正确的验证码！！！";
	}
}
</script>
</head>
<body style="background-image: url('/BBS/resource/img/login.jpg');background-size: cover;">
<%String str = null;
	String password = null;
	String sel = null;
	String msg = (String)request.getAttribute("msg");
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("sel")){
				sel = cookie.getValue();
			}
			if(cookie.getName().equals("str")){
				str = cookie.getValue();
			}
			if(cookie.getName().equals("password")){
				password = cookie.getValue();
			}
			if(sel!=null&&str!=null&&password!=null&&msg==null){
			request.getRequestDispatcher ("LoginServlet?select="+sel+"&str="+str+"&password="+password).forward(request, response);
			}
		}
		
	}%>
<!-- ${pageContext.request.contextPath} -->
	<div class="login" style="background: white;width:393px;margin: auto;margin-top:200px">
		<div class="login-title">
			<div class="login-title-logo" style="background-image: url('${pageContext.request.contextPath}/resource/img/logo.png');"></div>
			<div class="login-title-text">
				登录Joker账号
			</div>
		</div>
		<div class="login-bottom">
			<div id="msg" style="height: 20px;padding-left:30px;padding-top:18px;color:red;font-size: 14px;">${requestScope.msg }</div>
			<form action="${pageContext.request.contextPath}/LoginServlet" method="post" id="loginform">
				<div class="text" id="username">
					<div class="text-left1">
						<select name="select" id="select">
							<option value="username" selected="selected" >用户名</option>
							<option value="email">邮箱</option>
							<option value="tel">手机</option>
						</select>
					</div>
					<input type="text" name="str" id="str" onfocus="clearMsg()">
				</div>
				<div class="text" id="password">
					<div class="text-left2">密码：</div>
					<input type="password" name="password" id="pswd" onfocus="clearMsg()">
				</div>
				<div style="float:left;width:120px; padding-left:17px;font-size:14px;color: #666666;margin-bottom: 10px;">
					<label style="cursor:pointer;"><input type="checkbox" name="auto" value="true">下次自动登录</label>
				</div>
				<div id="auth">
					<div style="width:86px;float:left;">
						<input id="varcode" type="text" name="varcode"  onkeyup="checkVarcode()" onfocus="clearMsg()"/>
					</div>
					<img id="authimg" style="cursor:pointer;margin-bottom: 0px;" alt="下一张" onclick="refresh();" src="/BBS/AuthImgServlet">
				</div>
				<div style="width: 351px;margin: auto;margin-bottom: 10px;">
					<input style="cursor:pointer;" type="button" value="登录" class="login-btn" onclick="checkLogin();">
				</div>
				<div style="text-align: left;margin-left: 30px;float:left;width:60px;"> <a href="findpassword.jsp">找回密码</a></div>
				<div style="text-align: right;margin-right: 30px;float:right;width:60px;"> <a href="register.jsp">立即注册</a></div>
			</form>
		</div>
	</div>
</body>

</html>