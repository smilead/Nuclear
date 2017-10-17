<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/my.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/j
s/varcode.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/loginRegister.css"/>
<title>注册Joker账号</title>
<script type="text/javascript">
function checkUsername(){
	var input = document.getElementById("username");
	var username = input.value;
	var divmsg = document.getElementById("msg");
	var XMLHttpRequest = getXMLHttpRequest();
	XMLHttpRequest.open("get","CheckUsernameServlet?username="+username);
	XMLHttpRequest.onreadystatechange=function(){
		if(XMLHttpRequest.readyState==4 && XMLHttpRequest.status==200){
			var flag = XMLHttpRequest.responseText;
			if(flag=="false"){
				input.style.backgroundImage="url('${pageContext.request.contextPath}/resource/img/yes.gif')";
				input.style.backgroundRepeat="no-repeat";
				input.style.backgroundPosition="right";
			}else{
				input.style.backgroundImage="url('${pageContext.request.contextPath}/resource/img/no.gif')"
				input.style.backgroundRepeat="no-repeat";
				input.style.backgroundPosition="right";
			}			
		}	
	}
	XMLHttpRequest.send(null);
}
function checkRegister(){
	var color = document.getElementById("msg").style.color;
	var pic = document.getElementById("username").style.backgroundImage;
	if(color=="green"){
		var username = document.getElementById("username").value;
		var password = document.getElementById("pswd").value;
		var confirmpassword = document.getElementById("confirmpswd").value;
		if(username==""){
			alert("用户名不能为空！！！");
		}else if(password==""){
			alert("密码不能为空");
		}else{
			if(password==confirmpassword){
				document.getElementById("registerform").submit();	
			}else{
				alert("两次密码不一致！！！");
			}
		}
	}else{
		document.getElementById("msg").innerHTML="请输入正确的验证码！！！";
	}
}
</script>
</head>
<body style="background-image: url('/BBS/resource/img/login.jpg');background-size: cover;">
	<div style="background: white;width:393px;height: 410px;margin: auto;margin-top:150px;">
		<div class="login-title">
			<div class="login-title-logo" style="background-image: url('${pageContext.request.contextPath}/resource/img/logo.png');"></div>
			<div class="login-title-text">
				注册Joker账号
			</div>
		</div>
		<div class="login-bottom">
			<div id="msg" style="height: 20px;padding-left:30px;padding-top:18px;color:red;font-size: 14px;">${requestScope.msg }</div>
			<form action="${pageContext.request.contextPath}/RegisterServlet" method="post" id="registerform">
				<div class="text" id="">
					<div class="text-left1">
						<div class="text-left2">账号：</div>
					</div>
					<input type="text" name="username" id="username" onkeyup="checkUsername()" onfocus="clearMsg()">
				</div>
				<div class="text" id="">
					<div class="text-left2">密码：</div>
					<input type="password" name="password" id="pswd" onfocus="clearMsg()">
				</div>
				<div class="text" id="confirmpassword">
					<div class="text-left2" style="height:43px;padding-top:3px;" onfocus="clearMsg()">确认<br>密码：</div>
					<input type="password" name="confirmpassword" id="confirmpswd">
				</div>
				<div style="float:left;width:120px; padding-left:30px;font-size:14px;color: #666666;margin-bottom: 10px;">
					请输入验证码：
				</div>
				<div id="auth">
					<div style="width:86px;float:left;">
						<input id="varcode" type="text" name="varcode"  onkeyup="checkVarcode()" onfocus="clearMsg()"/>
					</div>
					<img id="authimg" style="cursor:pointer;margin-bottom: 0px;" alt="下一张" onclick="refresh();" src="AuthImgServlet">
				</div>
				<div style="width: 351px;margin: auto;margin-bottom: 10px;">
					<input style="cursor:pointer;" type="button" value="注册" class="login-btn" onclick="checkRegister();">
				</div>
				<div style="text-align: left;margin-left: 30px;float:left;width:60px;"> <a href="findpassword.jsp">找回密码</a></div>
				<div style="text-align: right;margin-right: 30px;float:right;width:60px;"> <a href="login.jsp">已有账号</a></div>
			</form>
			
		</div>
	</div>
</body>
</html>