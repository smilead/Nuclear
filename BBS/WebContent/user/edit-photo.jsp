<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改头像</title>
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
                <form id="ajaxForm" action="${pageContext.request.contextPath }/UpdatePhotoServlet" method="post" class="form-horizontal" enctype="multipart/form-data">
                    <div class="col-md-12">
                        <img class="user-show-img" src="<c:url value="/resource/img/photo/${user.userpic}"/>"
                             alt=""/>
                    </div>
                    <div class="col-md-12">
                        <input type="file" name="userpic">
                    </div>
                    <div id="formAlert" class="alert hidden" role="alert"></div>
                    <br>
                    <div class="col-md-12">
                        <span class="col-md-9"></span>
                        <button class="btn btn-default" type="submit" onclick="">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../public/footer.jsp"/>
</body>
</html>
