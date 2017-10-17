<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/my.js"></script>
<title>找回密码</title>
<script type="text/javascript">
function showQuestion(btn){
	var username = document.getElementById("username").value;
	var quest = document.getElementById("quest");
	var questcontainer = document.getElementById("questcontainer");
	var alert1 = document.getElementById("alert1");
	var alert2 = document.getElementById("alert2");
	if(username==""){
		alert("用户名不能为空!!!");
		return;
	}
	var XMLHttpRequest=getXMLHttpRequest();
	XMLHttpRequest.open("get","ShowQuestionServlet?username="+username);
	XMLHttpRequest.onreadystatechange=function(){
		if(XMLHttpRequest.readyState==4 && XMLHttpRequest.status==200){
			var question = XMLHttpRequest.responseText;
			if(question!="null"){
				quest.innerHTML = question;
				questcontainer.style.display = "block";
				btn.style.display = "none";
				document.getElementById("realusername").value = username;
				document.getElementById("username").disabled = "disabled";
			}else{
				alert1.style.display="block";
			}
		}
	}
	XMLHttpRequest.send(null);
}
function updatePswd(btn){
	var username = document.getElementById("username").value;
	var answer = document.getElementById("answer").value;
	var updatepswdcontainer = document.getElementById("updatepswdcontainer");
	if(answer==""){
		alert("答案不能为空!!!");
		return;
	}
	var XMLHttpRequest=getXMLHttpRequest();
	XMLHttpRequest.open("get","ShowUpdatePswdServlet?username="+username+"&answer="+answer);
	XMLHttpRequest.onreadystatechange=function(){
		if(XMLHttpRequest.readyState==4 && XMLHttpRequest.status==200){
			var flag = XMLHttpRequest.responseText;
			if(flag=="true"){
				updatepswdcontainer.style.display="block";
				btn.style.display="none";
				document.getElementById("answer").disabled="disabled";
			}else{
				alert2.style.display="block";
			}
		}
	}
	XMLHttpRequest.send(null);
}
function checkPassword(){
	var password = document.getElementById("password").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	if(password==""){
		alert("密码不能为空");
	}else{
		if(password==confirmpassword){
			document.getElementById("ajaxform").submit();	
		}else{
			alert("两次密码不一致！！！");
		}
	}
}
function hiddenAlert(){
	var alert1 = document.getElementById("alert1");
	var alert2 = document.getElementById("alert2");
	alert1.style.display="none";
	alert2.style.display="none";
}

</script>
</head>
<body style="background-color: #eeeeee">
<jsp:include page="/public/header.jsp"></jsp:include>
<div style="width: 80%;margin:auto;">
	<div class="container-fluid">
        <h1></h1>
    </div>
  

    <div class="container-fluid">
        <div class="row">
            <div class="span2  col-xs-12 col-sm-3 col-md-2">
                <ul class="nav nav-pills nav-stacked" style="background-color: white;">
                    <li class="active"><a>安全中心</a></li>
                    <li><a href="#">安全问题找回</a></li>
                    <li><a href="#">邮箱验证找回</a></li>
                    <li><a href="#">手机验证找回</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-9 col-md-10" style="height:550px; background-color: white;padding-bottom: 20px;">
                <div id="byquestion">
                <div id="alert" style="height:100px;">
	                <div class="alert alert-warning alert-dismissible" role="alert" id="alert1" style="display:none">
							<strong>错误!</strong> 您未设置安全问题或者没有该用户！！！
					</div>
					<div class="alert alert-warning alert-dismissible" role="alert" id="alert2" style="display:none">
							<strong>错误!</strong> 安全问题回答错误！！！
					</div>
                
                </div>
                	<form id="ajaxform" action="UpdatePswdServlet" method="post" class="form-horizontal">
                	<div>
                		<div class="form-group">
                			<label class="col-md-4 control-label">用户名</label>
                			<div class="col-md-6">
                				<input id="username" type="text" class="form-contol"  onkeyup="hiddenAlert()"/>
                				<input name="username" type="hidden" id="realusername"/>
                			</div>
                		</div>
                		<div class="col-md-12">
                			<span class="col-md-9"></span>
                			<button class="btn btn-primary" type="button" onclick="showQuestion(this)">下一步</button>
                		</div>
                	</div>
                	<div class="row"></div>
                	<div style="display:none" id="questcontainer">
               			<div class="form-group">
                			<label class="col-md-4 control-label" id="quest"></label>
                			<div class="col-md-6">
                				<input name="answer" id="answer" type="text" class="form-contol" onkeyup="hiddenAlert()"/>
                			</div>
                		</div>
                		<div class="col-md-12">
                			<span class="col-md-9"></span>
                			<button class="btn btn-primary" type="button" onclick="updatePswd(this)">下一步</button>
                		</div>
                	</div>
                	<div style="display:none" id="updatepswdcontainer">
               			<div class="form-group">
                			<label class="col-md-4 control-label" id="">新密码</label>
                			<div class="col-md-6">
                				<input name="password" id="password" type="password" class="form-contol" />
                			</div>
                		</div>
                		<div class="form-group">
                			<label class="col-md-4 control-label" id="">确认密码</label>
                			<div class="col-md-6">
                				<input name="confirmpassword" id="confirmpassword" type="password" class="form-contol" />
                			</div>
                		</div>
                		<div class="col-md-12">
                			<span class="col-md-9"></span>
                			<button class="btn btn-primary" type="button" onclick="checkPassword()">确认修改</button>
                		</div>
                	</div>
                	
                	</form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/public/footer.jsp"></jsp:include>
</body>
</html>