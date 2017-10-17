<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="<c:url value="/resource/img/favicon.ico"/>" type="image/x-icon">
<link rel="shortcuticon" href="<c:url value="/resource/img/favicon.ico"/>" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap-table.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/bootstrap-3.3.7/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resource/css/admin.css"/>"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.min.js"></script>
<script src="<c:url value="/resource/js/jquery.cookie.js"/>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap-table.min.js"></script>
<script src="<c:url value="/resource/js/vue.min.js"/>"></script>
<script src="<c:url value="/resource/js/my.js"/>"></script>

<div id="header">
    <nav class="navbar navbar-default">
        <%-- Logo --%>
        <div class="container container-fluid">
            <div class="navbar-header">
            <div style="width:58px;height:52px;float:left;background-image: url('${pageContext.request.contextPath}/resource/img/logo.png');background-size:cover;margin-right:10px;"></div>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                </button>
                <a class="navbar-brand" href="<c:url value="/admin/"/>">Joker BBS Admin</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/admin/post/indexManager.jsp"/>">帖子管理</a></li>
                <li><a href="<c:url value="/admin/user/index.jsp"/>">用户管理</a></li>
                <!--<li><a href="<c:url value="/admin/collect/"/>">登录信息</a></li> -->
            </ul>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/" />">BBS</a></li>
                    <c:if test="${not empty sessionScope.admin}">
                        <li><a href="/BBS/ShowOneUserServlet?uid=${sessionScope.admin.uid}">${sessionScope.admin.username}</a></li>
                        <li><a href="/BBS/DeleteSessionServlet">退出登录</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</div>
