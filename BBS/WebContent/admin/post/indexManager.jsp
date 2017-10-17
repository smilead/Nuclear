<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JokerBBS帖子管理</title>
</head>
<body style="background-image: url('/BBS/resource/img/bg.jpg')">
<jsp:include page="../header.jsp"/>
<div style="background-size: 80%;margin: auto;width: 80%; background: #46a3ff;">
<div class="bs-example" data-example-id="split-button-dropdown">
   <!-- /btn-group -->    
    <div class="btn-group">
      <button type="button" name="name" class="btn btn-primary">首页</button>
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="PostsSelectOrderByServlet?parame=ptime&type=index&sourcePath=true">最新</a></li>
        <li><a href="PostsSelectOrderByServlet?parame=pageview&type=index&sourcePath=true">按热度排序</a></li>
        <li><a href="PostsSelectByValue?competitive=1&type=index&sourcePath=true">精品贴</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">更多</a></li>
      </ul>
    </div><!-- /btn-group -->
    <div class="btn-group">
      <button type="button" class="btn btn-success">游戏快讯</button>
      <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="PostsSelectOrderByServlet?parame=ptime&type=游戏快讯">最新</a></li>
        <li><a href="PostsSelectOrderByServlet?parame=pageview&type=游戏快讯">按热度</a></li>
        <li><a href="PostsSelectByValue?competitive=1&type=游戏快讯">精品区</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">查询更多</a></li>
      </ul>
    </div><!-- /btn-group -->
    <div class="btn-group">
      <button type="button" class="btn btn-info">天天军事</button>
      <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="PostsSelectOrderByServlet?parame=ptime&type=天天军事">最新</a></li>
        <li><a href="PostsSelectOrderByServlet?parame=pageview&type=天天军事">按热度</a></li>
        <li><a href="PostsSelectByValue?competitive=1&type=天天军事">精品区</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">查询更多</a></li>
      </ul>
    </div><!-- /btn-group -->
    <div class="btn-group">
      <button type="button" class="btn btn-warning">科技财经</button>
      <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="PostsSelectOrderByServlet?parame=ptime&type=科技财经">最新</a></li>
        <li><a href="PostsSelectOrderByServlet?parame=pageview&type=科技财经">按热度</a></li>
        <li><a href="PostsSelectByValue?competitive=1&type=科技财经">精品区</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">查询更多</a></li>
      </ul>
    </div><!-- /btn-group -->
    <div class="btn-group">
      <button type="button" class="btn btn-danger">七彩生活</button>
      <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="PostsSelectOrderByServlet?parame=ptime&type=七彩生活?">最新</a></li>
        <li><a href="PostsSelectOrderByServlet?parame=pageview&type=七彩生活">按热度</a></li>
        <li><a href="PostsSelectByValue?competitive=1&type=七彩生活">精品区</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">查询更多</a></li>
      </ul>
  	
    </div><!-- /btn-group -->
	
	  	
	<div id="contextDiv" style="border:0px;position: absolute; background-color:#eeeeee;top: 212px" class="form-group" ></div>
	<div>
		<div>
			<form action="PostsSelectOrderByServlet"  method="post" style="width: 30%; float: left;">
			      每页显示<select name="pageSize" onchange="submit();">
			<option value="5">5</option>
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="50">50</option>
			</select>条
	  	</form>
	  	<form name="selectBetweenPageForm"  action="PostsSelectBetweenPageview" method="post" style="width: 70%; float: left;">
			按浏览量:浏览量介于<input type="number" name="min" id="minPageview" >与
			<input type="number" name="max" id="maxPageview">之间的帖子<input type="submit" value="搜索"> 
		</form>
	  </div>
		<div>
		<form action="PostsSelectRecently" method="post" style="width: 30%;float: left;">
		查询近<select onchange="submit()" name="date">
		<option value="3">3</option>
		<option value="7">7</option>
		<option value="30">30</option>
		<option value="180">180</option>
		<option value="365">365</option>
		</select>天的帖子
		</form>
		<br>
		<form action="PostsSelectBetweenTime" method="post" style="width: 70%;float: left;">
		按发布时间:从<input type="date" name="min">到<input type="date" name="max">的帖子<input type="submit" value="搜索">
		</form>	
		<form action="PostsSelectVagueServlet">
		<input type="text" value="请输入要搜索的内容" name="sel"><input type="submit" value="搜索">
		</form>
		</div>
	</div>
</div>
<!-- 帖子展示页面 -->
<div>
<c:if test="${not empty requestScope.postsPage}">

<table  class="table">
 <thead>
    <tr>
      <th>标题</th>
      <th>发帖人</th>
      <th>板块</th>
      <th>访问量</th>
      <th>发帖时间</th>
      <th>评论总数</th>
      <th>状态</th>
      <th>操作</th>
      </tr>
  </thead>
	<c:forEach items="${requestScope.postsPage.miniPosts }" var ="miniPost" >
	<c:if test="${miniPost.level==255}">
	<tr class="danger"> 
		<td><b><a href="ShowOnePostServlet?pid=${miniPost.pid }">${miniPost.ptitle }<font color="red">论坛公告</font></a></b><c:if test="${miniPost.competitive==1}" ><font color="green">【精】</font></c:if></td>
		<td>
			<c:if test="${miniPost.userLevel=='高级会员' }">
			<font color="red">${miniPost.pixname}	</font>	
			</c:if>
			<c:if test="${miniPost.userLevel=='普通会员' }">
			${miniPost.pixname}
			</c:if>
		</td>	
		<td>${miniPost.type }</td>
		<td>${miniPost.pageView }</td>
		<td>${miniPost.ptime }</td>
		<td>${miniPost.commentTotal}</td>
		<td>全区置顶
			<c:if test="${miniPost.competitive==1}" >精品帖</c:if>
			<c:if test="${miniPost.competitive==0}">普通贴</c:if>
		</td>
		<td>
			<a href="PostLevelSetServlet?pid=${miniPost.pid}&level=254">板块置顶</a><a href="PostLevelSetServlet?pid=${miniPost.pid}&level=0"> 取消置顶</a>
			<a href="PostLevelSetServlet?pid=${miniPost.pid}&level=-1">关闭帖子</a>
			<c:if test="${miniPost.competitive==1}"><a href="PostCompetitiveSetServlet?pid=${miniPost.pid}&competitive=0">精品取消</a></c:if>
			<c:if test="${miniPost.competitive==0}"><a href="PostCompetitiveSetServlet?pid=${miniPost.pid}&competitive=1">加精</a></c:if>
		</td>
		
		</tr>
	</c:if>
	<c:if test="${miniPost.level==254}">
		<tr class="warning"> 
			<td><a href="ShowOnePostServlet?pid=${miniPost.pid }">${miniPost.ptitle }<font color="green">板块公告</font></a><c:if test="${miniPost.competitive==1}" ><font color="green">【精】</font></c:if></td>
			<td >
			<c:if test="${miniPost.userLevel=='高级会员'}">
			<font color="red">${miniPost.pixname}</font>	
			</c:if>
			<c:if test="${miniPost.userLevel=='普通会员' }">
			${miniPost.pixname}
			</c:if>
		</td>	
		<td>${miniPost.type }</td>
		<td>${miniPost.pageView }</td>
		<td>${miniPost.ptime }</td>
		<td>${miniPost.commentTotal}</td>
		<td>板块置顶
			<c:if test="${miniPost.competitive==1}" >精品帖</c:if>
			<c:if test="${miniPost.competitive==0}">普通贴</c:if>
		</td>
		<td>
			<a href="PostLevelSetServlet?pid=${miniPost.pid}&level=255">全区置顶</a><a href="PostLevelSetServlet?pid=${miniPost.pid}&level=0"> 取消置顶</a>
			<a href="PostLevelSetServlet?pid=${miniPost.pid}&level=-1">关闭帖子</a>
			<c:if test="${miniPost.competitive==1}">
			<a href="PostCompetitiveSetServlet?pid=${miniPost.pid}&competitive=0">精品取消</a>
			</c:if>
			<c:if test="${miniPost.competitive==0}">
			<a href="PostCompetitiveSetServlet?pid=${miniPost.pid}&competitive=1">加精</a>
			</c:if>
		</td>		
	</tr>
	</c:if>
	<c:if test="${miniPost.level==0 }">
		<tr class="active"> 
		<td>
			<a href="ShowOnePostServlet?pid=${miniPost.pid }">${miniPost.ptitle }</a>
			<c:if test="${miniPost.competitive==1}" ><font color="green">【精】</font></c:if></td>
		<td >
			<c:if test="${miniPost.userLevel=='高级会员' }">
			<font color="red">${miniPost.pixname}</font>	
			</c:if>
			<c:if test="${miniPost.userLevel=='普通会员' }">
			${miniPost.pixname}
			</c:if>
		</td>	
		<td>${miniPost.type }</td>
		<td>${miniPost.pageView }</td>
		<td>${miniPost.ptime }</td>
		<td>${miniPost.commentTotal }</td>
		<td>未置顶
			<c:if test="${miniPost.competitive==1}" >精品帖</c:if>
			<c:if test="${miniPost.competitive==0}">普通贴</c:if>
		</td>
		<td>
			<a href="PostLevelSetServlet?pid=${miniPost.pid}&level=255">全区置顶</a><a href="PostLevelSetServlet?pid=${miniPost.pid}&level=254"> 板块置顶</a>
			<a href="PostLevelSetServlet?pid=${miniPost.pid}&level=-1">关闭帖子</a>		
			<c:if test="${miniPost.competitive==1}"><a href="PostCompetitiveSetServlet?pid=${miniPost.pid}&competitive=0">精品取消</a></c:if>
			<c:if test="${miniPost.competitive==0}"><a href="PostCompetitiveSetServlet?pid=${miniPost.pid}&competitive=1">加精</a></c:if>
		</td>
		</tr>
	</c:if>
	</c:forEach>
	</table>
	<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <c:forEach begin="1" end="${requestScope.postsPage.totalPage}" var="i">
    <li><a href="PostsServletManager?currentPage=${i}">${i}</a></li>
    </c:forEach>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</c:if>
<c:if test="${not empty requestScope.msg }">
	<font color="red">${requestScope.msg }</font>
	<script type="text/javascript">
		alert(msg);
		location="smileTest.jsp";
	</script>
</c:if>
<c:if test="${empty requestScope.postsPage && empty requestScope.msg }">
<jsp:forward page="../../IndexInitServlet?sourcePath=true"></jsp:forward>	
</c:if>

</div>

</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
