<%--
  Created by IntelliJ IDEA.
  User: Amily
  Date: 2017/8/1
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑销售机会</title>
    <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/main.css" />
    <link rel="stylesheet" href="css/ComplieSaleOpportunity.css">
</head>
<body>
<div class="admin-main">
    <div id="main">
            <span class="title1">
            <a href="">编辑销售机会</a>
            </span>
        <div class="layui-btn-group">
            <button class="layui-btn">帮助</button>
            <button class="layui-btn">返回</button>
            <button class="layui-btn" > <a  href="#" onclick="update()" >保存</a></button>
        </div>
<script type="text/javascript">
function update() {
	document.getElementById("NewSale").submit();
}
</script>
        <form id="NewSale" action="ManageSaleOpportunity_updatechance" method="post">
            <table class="layui-table" >
                <colgroup>
                    <col width="200">
                    <col width="350">
                    <col width="200">
                    <col width="350">
                </colgroup>

                <tbody>
                <tr id="rowOne">
                    <td class="td1">编号</td>
                    <td class="td1">
                        <input type="text" name="chanceid" value="${requestScope.chance.chanceid}" autocomplete="off" class="layui-input">
                    </td>
                    <td class="td1">机会来源</td>
                    <td class="td1">
                        <input type="text" name="source" value="${requestScope.chance.source }" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td class="td1">客户名称</td>
                    <td class="td1">
                        <input type="text" name="customername" value="${requestScope.chance.customername }" autocomplete="off" class="layui-input">
                        <span class="tab">*</span>
                    </td>
                    <td class="td1">成功机率</td>
                    <td class="td1">
                        <input type="text" name="odds" value="${requestScope.chance.odds }" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td class="td1">概要</td>
                    <td colspan="3" class="td1">
                        <input type="text" name="outline" value="${requestScope.chance.outline }"autocomplete="off" class="layui-input">
                    </td>

                </tr>
                <tr>
                    <td class="td1">联系人</td>
                    <td class="td1">
                        <input type="text" name="contactsname" value="${requestScope.chance.contactsname }"  autocomplete="off" class="layui-input">
                    </td>
                    <td class="td1">联系人电话</td>
                    <td class="td1">
                        <input type="text" name="contactsphone" value="${requestScope.chance.contactsphone }"  autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr id="rowFive">
                    <td class="td1">机会描述</td>
                    <td colspan="3" class="td1">
                        <textarea name="desc"  class="layui-textarea">${requestScope.chance.description}</textarea>
                    </td>

                </tr>
                <tr>
                    <td class="td1">创建人</td>
                    <td class="td1">
                        <input type="text" name="userByCreateuserid"  value="${requestScope.chance.userByCreateuserid.username}" autocomplete="off" class="layui-input">
                        <span class="tab">*</span>
                    </td>
                    <td class="td1">创建时间</td>
                    <td class="td1">
                        <input type="text" name="createTime" value="${requestScope.chance.createtime}" autocomplete="off" class="layui-input">
                        <span class="tab">*</span>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="layui-table" lay-even="" lay-skin="row">
                <colgroup>
                    <col width="200">
                    <col width="350">
                    <col width="200">
                    <col width="350">
                </colgroup>
                <tbody>
                <tr style="margin-top: 10px">
                    <td class="td2">指派人</td>
                    <td class="td1">
                     <select id="userByAssignuserid" name="userByAssignuserid">
                       		<option value="${requestScope.chance.userByCreateuserid.username}">${requestScope.chance.userByCreateuserid.username}</option>
                       		<c:forEach items="${requestScope.users}" var="usr">
                           		 <option value="${usr.userid}">${usr.username}</option>
                       		</c:forEach>
                           
                        </select>
                        
                     
                        
               
                        <span class="tab2">*</span>
                    </td>
                    <td class="td2">指派时间</td>
                    <td class="td1">
                        <input type="text" name="newTime" lay-verify="newTime" autocomplete="off" class="layui-input">
                        <span class="tab2">*</span>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

    </div>
</div>
</body>
</html>
