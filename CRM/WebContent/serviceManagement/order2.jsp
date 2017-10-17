<%@page import="java.security.interfaces.RSAKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报价创建</title>
    <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/main.css" />
    <link rel="stylesheet" href="css/newService.css" />
</head>
<body>

<script type="text/javascript">
   function add(){
	   var b,c,d,e;
	    b = document.getElementById("b").value;
	    c = document.getElementById("c").value;
	    d = document.getElementById("d").value;
	    e = document.getElementById("e").value;
	    f = document.getElementById("f").value;
	    f=b*b/b+c*c/c+d*d/d+e*e/e+f*f/f;
	   document.getElementById("f").value = f;
   }

	function UserLoginChecks(){
		var g=document.getElementById("g").value;
		var b=document.getElementById("b").value;
		var c=document.getElementById("c").value;
		var d=document.getElementById("d").value;
		var e=document.getElementById("e").value;
		if(g == ""){
			alert("客户经理不能为空！");
			return false;
		}if(b == ""){
			alert("实施报价不能为空！");
			return false;
		}if(c == ""){
			alert("运维服务报价不能为空！");
			return false;
		}if(d == ""){
			alert("专项服务报价不能为空！");
			return false;
		}if(e == ""){
			alert("项目损益报价不能为空！");
			return false;
		}else{
			return true;
	}
   
</script>


<div id="main">
<form action="order2!addbaojia" method="post">
    <div>
        <span>
		  <a href="index.jsp">报价管理 ></a>
		  <a href="index.jsp">报价创建 ></a>
		</span>
    </div>

    <div>
        <table class="layui-table">
            <tr>
                <td>编号</td><td><input type="text" name="offerid"></td>
                <td>客户名称</td><td><input type="text"></td>
                <td>送货地址</td><td><input type="text"></td>
           </tr>
           
           <tr>
                <td>客户经理</td>
                 <td>
                    <select name="cname" id="g">
                        <option value="12">ml11</option>
                        <option value="13">ml22</option>
                        <option value="14">ml33</option>
                        <option value="15">ml44</option>
                    </select>
                    <span> *</span>
                </td>
                <td>状态</td><td>未审核</td>
           </tr>
        </table>
    </div>
   
   <div>
      <table class="layui-table">
           <tr>
              <td>产品编号</td>  <td>产品名称</td>  <td>单价（元）</td><td>数量</td>
           </tr>
           <tr>
              <td>1</td>
              <td>火腿肠</td>
              <td>2</td>
              <td>1</td>
           </tr>
           <tr>
              <td>3</td>
              <td>矿泉水</td>
              <td>1.5</td>
              <td>3</td>
           </tr>
           </table>
    </div>
    <div>
        <table class="layui-table">
           <tr>
              <td>产品报价</td><td><input type="text" name="price" id="a" value="6.5"><span> *</span></td>
           </tr>
           <tr>
              <td>实施报价</td><td><input type="text" name="actual" id="b"><span> *</span></td>
           </tr>
           <tr>
              <td>运维服务报价</td><td><input type="text" name="operate" id="c"><span> *</span></td>
           </tr>
           <tr>
              <td>专项服务报价</td><td><input type="text" name="service" id="d"><span> *</span></td>
           </tr>
           <tr>
              <td>项目损益报价</td><td><input type="text" name="profit" id="e"><span> *</span></td>
           </tr>
           <tr>
              <td><input type="button" value="合计" onclick="add()" onclick="return UserLoginChecks();"/></td><td><input type="text" name="total" id="f" value="6.5"><span> *</span></td>
           </tr>
      </table>
   </div>
   
       <div class="layui-btn-group globalHight">
        <input type="submit" value="提交" class="layui-btn">
    </div>
   
</form>
</div>
</body>
</html>