<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改密码</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/my.js"></script>
</head>
<body>
<jsp:include page="../public/header.jsp"/>
<script type="text/javascript">
function updatePassword(){
	var uid = document.getElementById("uid").value;
	var oldPassword = document.getElementById("oldPassword").value;
	var ajaxForm = document.getElementById("ajaxForm");
	if(oldPassword==""){
		alert("密码不能为空!!!");
		return;
	}
	var XMLHttpRequest=getXMLHttpRequest();
	XMLHttpRequest.open("get","/BBS/CheckPasswordServlet?uid="+uid+"&password="+oldPassword);
	XMLHttpRequest.onreadystatechange=function(){
		if(XMLHttpRequest.readyState==4 && XMLHttpRequest.status==200){
			var flag = XMLHttpRequest.responseText;
			if(flag=="true"){
				ajaxForm.submit();
			}else{
				alert("密码验证错误！！！");
			}
		}
	}
	XMLHttpRequest.send(null);
}	
</script>
<div class="content">
    <div class="container">
        <div class="user-show">
            <jsp:include page="../public/user-edit-nav.jsp"/>
            <div class="user-show-main">
                <div class="user-show-top">
                    <h4>个人信息</h4>
                </div>
                <form id="ajaxForm" action="${pageContext.request.contextPath }/UpdatePswdServlet" method="post" class="form-horizontal">
                    <input type="hidden" name="_method" value="put">
                    <input type="hidden" name="uid" id="uid" value="${user.uid}">
                    <input type="hidden" name="username" value="${user.username}">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户名</label>
                        <div class="col-md-6">
                            <input name="" type="text" class="form-control" disabled value="${user.username}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">旧密码</label>
                        <div class="col-md-6">
                            <input id="oldPassword" name="oldPassword" type="password" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">新密码</label>
                        <div class="col-md-6">
                            <input name="password" type="password" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">确认密码</label>
                        <div class="col-md-6">
                            <input name="confimpassword" type="password" class="form-control" value=""/>
                        </div>
                    </div>
                    <div id="formAlert" class="alert hidden" role="alert"></div>
                    <div class="col-md-12">
                        <span class="col-md-9"></span>
                        <button class="btn btn-default" type="button" onclick="updatePassword()">更改密码</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../public/footer.jsp"/>
</body>
</html>
