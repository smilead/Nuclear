<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>JokerBBS会员管理</title>
<script type="text/javascript">
function changeStatus(uid){
	var XMLHttpRequest=getXMLHttpRequest();
	XMLHttpRequest.open("get","ChangeStatusServlet?uid="+uid);
	XMLHttpRequest.onreadystatechange=function(){
		if(XMLHttpRequest.readyState==4 && XMLHttpRequest.status==200){
			location.reload();
		}
	}
	XMLHttpRequest.send(null);
	
}
function findUserLike(str){
	var search = document.getElementById("search").value;
	if(search==""){
		window.location="${pageContext.request.contextPath}/FindAllUsersServlet?currentPage=1&pageSize=10";
	}else{
		window.location="${pageContext.request.contextPath}/FindUserLikeServlet?search="+search+"&currentPage=1&pageSize=10";
	}
	
}
</script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<c:set var="page" value="${requestScope.page }"></c:set>
<c:if test="${empty page}">
	<script type="text/javascript">
		window.location="${pageContext.request.contextPath}/FindAllUsersServlet?currentPage=1&pageSize=10";
	</script>
</c:if>
<div id="main">
    <div class="container main-bar">
        <h1>用户管理</h1>
    	<div class="row">
		  	<div class="col-lg-6">
		    	<div class="input-group">
		      		<input type="text" class="form-control" placeholder="输入编号，用户名，或昵称..." id="search">
		      		<span class="input-group-btn">
		        		<button class="btn btn-default" type="button" onclick="findUserLike();">搜索</button>
		      		</span>
		    	</div><!-- /input-group -->
		  	</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
        <table class="table table-bordered">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>昵称</th>
                <th>性别</th>
                <th>经验</th>
                <th>级别</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${page.list}" var="user">
                <tr>
                    <td>${user.uid}</td>
                    <td><a href="/BBS/ShowOneUserServlet?uid=${user.uid}">${user.username}</a></td>
                    <td>${user.password}</td>
                    <td>${user.pixname}</td>
                    <td>${user.sex}</td>
                    <td>${user.exp}</td>
                    <td>${user.level }</td>
                    <td><c:if test="${user.status>0}">正常</c:if><c:if test="${user.status<=0}">封禁</c:if> </td>
                    <td><a href="#" onclick="changeStatus(${user.uid});"><c:if test="${user.status>0}">禁用</c:if><c:if test="${user.status<=0}">解禁</c:if></a> </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="../../public/page.jsp"/>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
