<%@page import="com.chinasoft.bbs.entity.Post"%>
<%@page import="com.chinasoft.bbs.entity.Comment"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单帖展示页</title>
<style type="text/css">
		a:link{color: ;text-decoration: none;}
		a:hover{color: red;text-decoration: none;}
    	#header{width:82%;height: 93px;border: 0px ;margin-left: 10%;background-color: ;}
    	#footer{width:82%;height: 120px;border: 0px ;margin-left: 10%;background-color: ;}
    	ul{list-style: none;font-size: 13px;}
    	li{float: left;padding-left: 20px;}
</style>
</head>
<body style="width: 100%;background-image: url('/BBS/resource/img/bg.jpg'); background-repeat: no-repeat;background-attachment: fixed;background-size: cover;">
<jsp:include page="/public/header.jsp"></jsp:include>
<div >
<div Style="width:80%;align-content: center; margin:auto; background-color: #46a3ff; background-image: url('${pageContext.request.contextPath}/resource/img/0.jpg');">

<c:if test="${empty requestScope.post }">
<script type="text/javascript">
alert("您搜索的帖子不存在或者以删除！");
location="smileTest.jsp";
</script>
</c:if>
<c:if test="${ not empty requestScope.post }">
<h2>${requestScope.post.ptitle}</h2>	
	${requestScope.post.article }

<hr style="height:3px;border:none;border-top:3px groove deepskyblue;" />
    <c:forEach items="${requestScope.post.commentPage.comments}" var="comment">
    	<div style="float: left; width: 100%;border:3px groove deepskyblue; background-image: url('${pageContext.request.contextPath}/resource/img/timg.jpg;');"">
    		<div style="width: 20%; float:left; text-align: center;">
    		<div style="text-align: left;"><font color="#888800" style="font-size: 18px;font-weight: bolder;">${comment.floor }楼</font></div>
    		<img src="${pageContext.request.contextPath }/resource/img/photo/${comment.userPic}" style="width: 150px;height: 150px;border-radius: 75px;"><br>		
			<a href="ShowOneUserServlet?uid=${comment.uid }">
			<c:if test="${comment.level =='普通会员'}">
			<font style="font-size:20px;">${comment.pixname}</font>
			</c:if>
			<c:if test="${comment.level =='高级会员'}">
			<font color="red" style="font-size:20px;">${comment.pixname}</font>
			</c:if>
			</a>
			</div>
			
			<div style="width:80%;float:right; " >
				<div>
					<div>${comment.content}</div>				
					<div style="height: 100px;">${comment.ctime}</div>
					<input type="button" value="评论" onclick="show(${comment.cid})" style="margin-left: 95%;">	
					
					<script type="text/javascript">
					function show(cid) {
						var name="form"+cid;
						var form=document.getElementById(name);
						form.style.display="block";	
					}			
					</script>
					<div><form id="form${comment.cid}" style="display:none" method="post" action="RecommentAddServlet">
					<input type="hidden" name="cid" value="${comment.cid}">	
					<input type="hidden" name="pid" value="${comment.pid}">
					<input type="text" value="请输入您的评论" name="rcoten"> 
					<input type="submit" value="提交">
					
					</form></div>
				</div>
							
				<div>
				<c:if test="${comment.recomments==null }">
				该楼层暂时没有评论
				</c:if>
				<c:if test="${comment.recomments!=null }">
					<table class="table" style="background-color: #eeeeee">
					
					<c:forEach items="${comment.recomments}" var="recomment">
						<tr ><td>${recomment.pixname}:${recomment.recontent}</td></tr>
					</c:forEach>	
					</table>
				</c:if>
	
				</div>
					
			</div>	
		</div>			
    </c:forEach>
    <div align="center">
    	评论
    	<c:if test="${not empty sessionScope.user }" >
    	<form action="AddCommentServlet" method="post">
    	<input type="hidden" name="pid" value="${requestScope.post.pid }">
 		<input type="hidden" name="uid" value="${sessionScope.user.uid }">
    	<textarea rows="10" cols="100" name="content" >请评论</textarea>
    	<input type="submit" value="提交">
    	</form>
    	</c:if>
    	<c:if test="${empty sessionScope.user }">登录之后才可评论，请先<a href="login.jsp">登录</a></c:if>
    	
    
    
    
    
    </div>
    
    
</c:if>


</div>

</div>
<jsp:include page="/public/footer.jsp"></jsp:include>
</body>
</html>