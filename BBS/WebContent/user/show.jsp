<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Joker个人信息</title>
</head>
<body>
<jsp:include page="../public/header.jsp"/>
<div class="content">
    <div class="container">
        <div class="user-show">
            <div class="user-show-top">
                <h4>个人信息</h4>
                <img class="user-show-img" src="<c:url value="/resource/img/photo/${user.userpic}"/>" alt=""/>
                <p>${user.pixname}</p>
            </div>
            <br>
            <ul class="user-show-detail">
                <li>
                    <div>经验:</div>
                    <div>${user.exp}</div>
                </li>
                <li>
                    <div>会员等级:</div>
                    <div>${user.level}</div>
                </li>
            </ul>
            <br>
            <ul class="user-show-detail">
            	<li>
                    <div>性别:</div>
                    <div>${user.sex}</div>
                </li>
                <li>
                    <div>年龄:</div>
                    <div>${user.age}</div>
                </li>
                <li>
                    <div>邮箱:</div>
                    <div>${user.email}</div>
                </li>
                <li>
                    <div>手机号码:</div>
                    <div>${user.tel}</div>
                </li>
            </ul>
            <c:if test="${sessionScope.user != null && sessionScope.user.uid==user.uid}">
            <div class="user-show-bottom">
                <a href="<c:url value="/user/edit.jsp"/>">编辑信息</a>
            </div>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="../public/footer.jsp"/>
</body>
</html>
