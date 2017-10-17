<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/27
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户流失管理</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../css/main.css" />
	<link rel="stylesheet" href="css/custChu.css" />
</head>
<body>
	<div id="main">
		<h1 ><a href="#" id="title1"> 客户流失管理</a></h1>
		<div class="layui-btn-group globalHight">
			<button class="layui-btn">帮助</button>
			<button class="layui-btn"><a href="">查询</a></button>
		</div>

		<div>
			<table class="layui-table">
				<tr>
					<td>客户</td>
					<td>
						<input type="text">
					</td>
					<td>客户经理</td>
					<td>
						<input type="text">
					</td>
					<td>状态</td>
					<td>
						<select>
							<option>全部</option>
						</select>
					</td>
				</tr>
			</table>
			<br/>
			<table class="layui-table">
				<tr>
					<td>编号</td>
					<td>客户</td>
					<td>确认流失时间</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<tbody id="churns">
			
				</tbody>

			</table>
			<div id="page1"></div>
		</div>

	</div>

	<script src="../plugins/layui/layui.js" charset="utf-8"></script>
<script>
$(pagelist());
	
function pagelist(){
    layui.use(['laypage', 'layer'], function(){
    	
        var laypage = layui.laypage
                ,layer = layui.layer;
        	var totalPage;
		totalPage=ajax(1,5,true);
        laypage({
            cont: 'page1'
            ,limit:5
            
            ,jump:function(obj,first){
            	
            	ajax(obj.curr,obj.limit,first);
	            	
  				}
        	,pages:totalPage
        });

    });
} 
    function ajax(curr,limit,first){
    	$.ajax({
			   type: 'post',
			   async: false,//异步锁定，默认为true
			   url: "/CRM/findChurns",
			   data: {searchCustomerId:$("#searchCustomerId").val(),
				   searchCustomerName:$("#searchCustomerName").val(),
				   currentPage:curr,
				   pageSize:limit
				   },
			   dataType:"json",
			   success:function(pageModel){
				   totalPage = pageModel.totalPage;
				   
				   $("#churns").empty();
				   $.each(pageModel.list,function(index,context){
					   $("#churns").append("<tr><td>"+context.churnid+"</td><td>"+context.company+"</td><td></td><td>"+context.statusvalue+"</td><td><a href='/CRM/custManagement/Customer_showInfo?cuostomerid="+context.cuostomerid+"'> <i class='layui-icon'>&#xe620;</i></a>&nbsp;&nbsp;&nbsp;&nbsp; <a href='/CRM/custManagement/Customer_delete?cuostomerid="+context.cuostomerid+"'><i class='layui-icon'>&#xe628;</i></a>"+"</td></tr>");
				   });
				  
			   }
				  
			 });
    	return totalPage;
    }
</script>



</body>
</html>
