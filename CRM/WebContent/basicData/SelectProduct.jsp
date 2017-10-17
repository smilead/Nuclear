<%--
  Created by IntelliJ IDEA.
  User: Amily
  Date: 2017/8/5
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品查询</title>
     <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
     <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/main.css" />
    <link rel="stylesheet" href="css/SelectProduct.css">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 	<script type="text/javascript">
 	
 	
 	</script>

</head>
<body>
<div id="main">
    <div id="nav">
        <span id="title1">
		  <a href="">客户信息管理 ></a>
		</span>
    </div>
    <div class="layui-btn-group globalHight">
        <button class="layui-btn">帮助</button>
        <button class="layui-btn"><a href="">查询</a></button>
    </div>

    <div>
        <table class="layui-table">
            <tr>
                <td>客户编号</td>
                <td>
                    <input type="text" name="searchCustomerId" id="searchCustomerId" onkeyup="pagelist()">
                </td>
                <td>客户名称</td>
                <td>
                    <input type="text" name="searchCustomerName" id="searchCustomerName" onkeyup="pagelist()">
                </td>
            </tr>
        </table>
        <br/>
        <table class="layui-table">
        <thead>
            <tr>
            <th>编号</th>
            <th>名称</th>
            <th>型号</th>
            <th>批次</th>
            <th>单位</th>
            <th>单价</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody id="customers">
             </tbody>
        </table>
    </div>
<div id="page1"></div>

</div>

</body>
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
			   url: "/CRM/basicData/findProduct",
			   data: {ssearchPType:$("#searchPType").val(),
				   searchPName:$("#searchPName").val(),
				   currentPage:curr,
				   pageSize:limit
				   },
			   dataType:"json",
			   success:function(pageModel){
				   totalPage = pageModel.totalPage;
				   $("#customers").empty();
				   $.each(pageModel.list,function(index,context){
					   $("#customers").append("<tr><td>"+context.productid+"</td><td>"+context.productname+"</td><td>"+context.producttype+"</td><td>"+context.productonce+"</td><td>"+context.productunit+"</td><td>"+context.productprice+"</td><td>"+context.productoutline+"</td></tr>");
				   });
				  
			   }
				  
			 });
    	return totalPage;
    }
</script>
</html>
