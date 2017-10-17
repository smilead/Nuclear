<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JokerBBS管理系统</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="container jumbotron">
    <h1>Joker BBS Admin</h1>   
</div>

<div class="container jumbotron" style="background-image: url('${pageContext.request.contextPath}/resource/img/timg.jpg');">
<form action="${pageContext.request.contextPath}/AdminIndexServlet" method="post">
	<div style="color:red;">
	<c:out value="${requestScope.msg }"></c:out>
    </div>
			<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
			</table>
		</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
