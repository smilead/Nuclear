<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑信息</title>
    <script type="text/javascript">
    function checkNotEmpty(){
    	var inputs = document.getElementsByClassName("form-control");
    	var form = document.getElementById("ajaxForm");
    	for(var i=0;i<inputs.length;i++){
    		if(inputs[i].value==""){
    			alert("不能为空");
    			return;
    		}
    	}
    	form.submit();
    }
    </script>
</head>
<body>
<jsp:include page="../public/header.jsp"/>

<div class="content">
    <div class="container">
        <div class="user-show">
            <jsp:include page="../public/user-edit-nav.jsp"/>
            <div class="user-show-main">
                <div class="user-show-top">
                    <h4>个人信息</h4>
                </div>
                <form id="ajaxForm" action="${pageContext.request.contextPath }/UpdateUserServlet" method="post" class="form-horizontal">
                    <input type="hidden" name="_method" value="put">
                    <input type="hidden" name="uid" value="${user.uid}">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户名</label>
                        <div class="col-md-6">
                            <input name="" type="text" class="form-control" disabled value="${user.username}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">昵称</label>
                        <div class="col-md-6">
                            <input name="pixname" type="text" class="form-control" value="${user.pixname}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">性别</label>
                        <div class="radio">
                        	<label>
                            	<input name="sex" type="radio" value="男" <c:if test="${user.sex=='男'}">checked</c:if> />男&nbsp;&nbsp;&nbsp;&nbsp;
                            </label>
                            <label>
                            	<input name="sex" type="radio" value="女" <c:if test="${user.sex=='女'}">checked</c:if>/>女
                            </label>
                        </div>
                        
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">年龄</label>
                        <div class="col-md-6">
                            <input name="age" type="text" class="form-control" value="${user.age}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">邮箱</label>
                        <div class="col-md-6">
                            <input name="email" type="text" class="form-control" value="${user.email}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">电话号码</label>
                        <div class="col-md-6">
                            <input name="tel" type="text" class="form-control" value="${user.tel}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">安全回答</label>
                        <div class="col-md-6">
                            <input name="safeQuestion" type="text" class="form-control" value="${user.safeques}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">安全答案</label>
                        <div class="col-md-6">
                            <input name="safeAnswer" type="text" class="form-control" value="${user.safeanswer}"/>
                        </div>
                    </div>
                    
                    <div id="formAlert" class="alert hidden" role="alert"></div>
                    <div class="col-md-12">
                        <span class="col-md-9"></span>
                        <button class="btn btn-default" type="button" onclick="checkNotEmpty();">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../public/footer.jsp"/>
</body>
</html>
