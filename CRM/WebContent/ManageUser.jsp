<%--
  Created by IntelliJ IDEA.
  User: Amily
  Date: 2017/8/5
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script src="plugins/layui/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="css/main.css" />
    <link rel="stylesheet" href="css/ManageUser.css">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript">

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
			   url: "/CRM/findUsers",
			   data: {searchCustomerId:$("#searchCustomerId").val(),
				   searchCustomerName:$("#searchCustomerName").val(),
				   currentPage:curr,
				   pageSize:limit
				   },
			   dataType:"json",
			   success:function(pageModel){
				   totalPage = pageModel.totalPage;
				   
				   $("#users").empty();
				   $.each(pageModel.list,function(index,context){
					   $("#users").append("<tr><td>"+context.userid+"</td><td>"+context.username+"</td><td>"+context.privs+"</td><td>"+context.jobname+"</td><td>"+context.jobno+"</td><td>"+context.entrytime+"</td><td><a href='#'> <i class='layui-icon'>&#xe613;</i></a>&nbsp;&nbsp;&nbsp;&nbsp; <i class='layui-icon'>&#x1006;</i>"+"</td></tr>");
				   });
				  
			   }
				  
			 });
    	return totalPage;
    }
</script>
</head>
<body>
<div class="admin-main">
    <div id="main">
            <span class="title1">
            <a href="">用户管理</a>
            </span>
        <div class="layui-btn-group globalHight">
            <button class="layui-btn">帮助</button>
            <button class="layui-btn">查询</button>
            <button class="layui-btn">删除</button>
        </div>
        <form id="NewSale" action="" method="post">
        <table class="layui-table">
            <tr>
                <td>用户名称</td>
                <td>
                    <input type="text" name="searchCustomerId" id="searchCustomerId" onkeyup="pagelist()">
                </td>
                <td>角色名称</td>
                <td>
                    <input type="text" name="searchCustomerName" id="searchCustomerName" onkeyup="pagelist()">
                </td>
            </tr>
        </table>
        <br/>
        
			
            <table class="layui-table">
                <colgroup>
                    <col width="100">
                    <col width="200">
                    <col width="300">
                    <col width="100">
                    <col width="150">
                    <col width="150">
                    <col width="100">
                </colgroup>
                
                <tr>
                    <td>编号</td>
                    <td>用户名称</td>
                    <td>管理模块</td>
                    <td>角色</td>
                    <td>角色码</td>
                    <td>入职时间</td>
                    <td>操作</td>
                </tr>
                <tbody id="users">
                <tr>
                    <td>1</td>
                    <td>睿智数码</td>
                    <td>采购笔记本电脑意向</td>
                    <td>刘先生</td>
                    <td>13729239239</td>
                    <td>2007年12月06日</td>
                    <td>
                        <i class="layui-icon">&#xe613;</i>
                        <i class="layui-icon">&#x1006;</i>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
        <div id="page1"></div>


    </div>
</div>
</body>

</html>
