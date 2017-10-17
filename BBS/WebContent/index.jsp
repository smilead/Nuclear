<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="com.chinasoft.bbs.entity.User,java.util.ArrayList,com.chinasoft.bbs.entity.Post,com.chinasoft.bbs.po.PostsPage" %>
 
<!DOCTYPE html
>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JokerBBS首页</title>
</head>
  <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/ueditor1_4_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/ueditor1_4_3/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
  
<script type="text/javascript">
function addMore(){
	//动态创建input
	var textFile = document.createElement("input");
	textFile.type="file";
	textFile.name="file";
	//动态创建删除按钮
	var btnDelete = document.createElement("input");
	btnDelete.type="button";
	btnDelete.value="删除";
	//创建个换行<br>
	var br = document.createElement("br");
	//动态添加到div
	//获得div
	var divAddMore = document.getElementById("divAddMore");
	//向div中添加
	divAddMore.appendChild(textFile);
	divAddMore.appendChild(btnDelete);
	divAddMore.appendChild(br);
	
	//定义删除的事件
	btnDelete.onclick = function(){
		divAddMore.removeChild(textFile);
		divAddMore.removeChild(btnDelete);
		divAddMore.removeChild(br);
	}
} 

//实例化编辑器  
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例  
  
	    var ue = UE.getEditor('editor');  
  
    function getContent() {   
        var article = UE.getEditor('editor').getContent(); 
        var form = document.getElementById("addPostForm");
        var newinput = document.createElement("input");
        newinput.type="hidden";
        newinput.name="article";
        newinput.value=article;
		form.appendChild(newinput);
		form.submit();
        
    }  
  
</script>

<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/my.js"></script>
<script type="text/javascript">
	//绑定onload事件
	window.onload=function(){
		//1.获取搜索框的内容
		var search =document.getElementById("search");
		//2.子div
		var divMessage =document.getElementById("contextDiv");
		//再次绑定事件onkeyup
		search.onkeyup=function(){
			var name=this.value;
			if(name==""){
				//隐藏div，当name为空
				divMessage.style.display="null";
				return;
			}
			//1.获得对象    重点
			var req=getXMLHttpRequest();
			//2.建立连接
			req.open("get","PostsSelectVague?sel="+name);
			//3.发送请求
			req.send(null);		
			//4.处理请求 
			req.onreadystatechange=function(){
				if(req.readyState==4){
					if(req.status==200){
						var data = req.responseText;//使用req.responseText接收返回的响应文本
						if(data=="###"){
							var childDivs="您要搜索的帖子不存在";
							divMessage.innerHTML=childDivs;
						}else{
							
							var ss = data.split("??");//切割字符串，存到字符串
							var childDivs ="";
							//循环把数据放到小的div
						for(var i=0;i<ss.length;i++){
								childDivs+="<div onclick='writeText(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"+ss[i]+"</div>";							
							}
							divMessage.innerHTML=childDivs;
							//把多个小div的数据放到大的div中
						}
						divMessage.style.display="block";
					}
				}
			}
				
		}
	}
	function changeBackground_over(div){
		div.style.backgroundColor="gray";
	}
	function changeBackground_out(div){
		div.style.backgroundColor="";
	}
</script>

<body>
	<jsp:include page="/public/header.jsp"></jsp:include>
<div style="width:80%;margin:auto;">
<div class="bs-example" data-example-id="split-button-dropdown">
   <!-- /btn-group -->    
    <div class="btn-group">
      <button type="button" name="name" class="btn btn-primary">首页</button>
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only">Toggle Dropdown</span>
      </button>
      <ul class="dropdown-menu">
        <li><a href="PostsSelectOrderByServlet?parame=ptime&type=index">最新</a></li>
        <li><a href="PostsSelectOrderByServlet?parame=pageview&type=index">按热度排序</a></li>
        <li><a href="PostsSelectByValue?competitive=1&type=index">精品贴</a></li>
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
	<div>
		<div>
		<form action="PostsSelectOrderByServlet"  method="post" style="width:30%;float: left;">
			 每页显示
			<select name="pageSize" onchange="submit();">
				<option ></option>
				<option value="5">5</option>
				<option value="10" >10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="50">50</option>
			</select>条
	 		 </form>
			<form name="selectBetweenPageForm"  action="PostsSelectBetweenPageview" method="post" style="width: 70%;float: left;">
				按浏览量查询:查询介于<input type="number" name="min" id="minPageview" >到
				<input type="number" name="max" id="maxPageview">之间的帖子<input type="submit" value="Go"> 
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
			<form action="PostsSelectBetweenTime" method="post" style="width: 70%;float: left;">
				从<input type="date" name="min">到<input type="date" name="max">的帖子<input type="submit"value="搜">
			</form>
	  	</div>
		
	  </div>
	 <div>
		<form action="PostsSelectVagueServlet">
			<div class="input-group">
			  <input type="text" id="search" class="form-control" placeholder="请输入贴名" aria-describedby="basic-addon2" >
			  <span  class="input-group-addon" id="basic-addon2" >搜索</span>
			 </div>
		</form>
		<div id="contextDiv" style="border:0px;position: absolute; background-color:#eeeeee;top: 212px" class="form-group" ></div>
	</div>
</div>


<%if (request.getAttribute("postsPage")!=null){ %>
<table  class="table">
 <thead>
    <tr>
      <th>标题</th>
      <th>发帖人</th>
      <th>板块</th>
      <th>访问量</th>
      <th>发帖时间</th>
      <th>评论总数</th>
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
		<td>${miniPost.commentTotal }</td>
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
		<td>${miniPost.commentTotal }</td>
	</tr>
	</c:if>
	<c:if test="${miniPost.level==0 }">
		<tr> 
		<td><a href="ShowOnePostServlet?pid=${miniPost.pid }">${miniPost.ptitle }</a><c:if test="${miniPost.competitive==1}" ><font color="green">【精】</font></c:if></td>
		<td >
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
		<td>${miniPost.commentTotal }</td>
	</tr>
	</c:if>
	</c:forEach>
	</table>
<%}else if(request.getAttribute("msg")!=null){%>
	<font color="red">${requestScope.msg }</font>
	<script type="text/javascript">
		location="index.jsp";
	</script>
<% 	}else{
		request.getRequestDispatcher("IndexInitServlet").forward(request, response);
	}%>
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

	当前访问量：<font color="aqual">${applicationScope.count}</font>
<div>
<form id="addPostForm" action="${pageContext.request.contextPath}/PostingServlet" method="post">	

	请输入文章标题：<input type="text" name="ptitle">	请选择要发表的板块：<select name="type">
					<option value="天天军事" selected="selected">天天军事</option>
					<option value="七彩生活">七彩生活</option>
					<option value="科技财经">科技财经</option>
					<option value="游戏快讯">游戏快讯</option>
				</select>
<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
<div id="btns">
	<input type="button" value="发表" onclick="getContent();">
</div>
</form>
</div>
</div>
<jsp:include page="/public/footer.jsp"></jsp:include>
</body>
</html>