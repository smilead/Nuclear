<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/28
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>联系人</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>css/linkman.css" />
</head>
<body>
<div id="main">
    <div>
        <span id="title1">
		  <a href="">客户信息管理 ></a>
		  <a href="">客户信息 ></a>
            <a href="">联系人 ></a>
		</span>
    </div>

    <div class="layui-btn-group globalHight">
        <button class="layui-btn">帮助</button>
        <button class="layui-btn"><a href="/CRM/webContent/custManagement/contactA!con">新建</a> </button>
        <button class="layui-btn"><a href="/custManagement/custInformation.jsp">返回</a></button>
    </div>
    <div>
        <table class="layui-table">
            <tr>
                <td>客户编号</td>
                <td>
                    <label>${sessionScope.customer.cuostomerid }</label>
                </td>
                <td>客户名称</td>
                <td>
                    <label>${sessionScope.customer.company }</label>
                </td>
            </tr>
        </table>
        <br>
        <table class="layui-table">
            <thead>
                <tr>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>职位</td>
                    <td>办公电话</td>
                    <td>手机号</td>
                    <td>备注</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            
            
             <c:forEach items="${requestScope.contacts}" var="contacts">
             
            <tr>
                <td>${contacts.contactsname }</td>
                <td>${contacts.contactssex }</td>
                <td>${contacts.contactsjob }</td>
                <td>${contacts.contactsphone }</td>
                <td>${contacts.contactsbirthday }</td>
                <td>${contacts.contactsremarks }</td>
                <td>
                    <a href="/CRM/webContent/custManagement/contactA!com?contactsid=${contacts.contactsid }"><i class="layui-icon">&#xe642;</i></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;<i class="layui-icon">&#xe640;</i>
                </td>
            </tr>
            </c:forEach>
           
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
