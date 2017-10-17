<%--
  Created by IntelliJ IDEA.
  User: Amily
  Date: 2017/8/1
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>指派销售机会</title>
    <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/main.css" />
    <link rel="stylesheet" href="css/AssignSaleOpportunity.css">
</head>
<body>
<div class="admin-main">
    <div id="main">
            <span class="title1">
            <a href="">销售机会管理 ></a>
            <a href="">指派销售机会</a>
            </span>
        <div class="layui-btn-group">
            <button class="layui-btn">帮助</button>
            <button class="layui-btn">返回</button>
            <button class="layui-btn"><a  href="#" onclick="submitForm()" >保存</a></button>
        </div>
<script type="text/javascript">
function submitForm() {
	document.getElementById("form1").submit();
}
</script>
        <form id="form1" action="ManageSaleOpportunity_assignChance" method="post">
            <table class="layui-table" lay-even="" lay-skin="row">
                <colgroup>
                    <col width="200">
                    <col width="350">
                    <col width="200">
                    <col width="350">
                </colgroup>

                <tbody>
                <tr id="rowOne">
                    <td class="td1">编号</td>
                    <td class="td1" ><input type="text" value="${requestScope.chance.chanceid}" readonly="readonly">

                    </td>
                    <td class="td1" >机会来源</td>
                    <td class="td1" >${requestScope.chance.source}

                    </td>
                </tr>
                <tr>
                    <td class="td1">客户名称</td>
                    <td class="td1">${requestScope.chance.contactsname}

                    </td>
                    <td class="td1">成功机率</td>
                    <td class="td1">${requestScope.chance.odds}

                    </td>
                </tr>
                <tr>
                    <td class="td1">概要</td>
                    <td colspan="3" class="td1" >${requestScope.chance.outline}

                    </td>

                </tr>
                <tr>
                    <td class="td1">联系人</td>
                    <td class="td1" >${requestScope.chance.contactsname}

                    </td>
                    <td class="td1">联系人电话</td>
                    <td class="td1" >${requestScope.chance.contactsphone}

                    </td>
                </tr>
                <tr>
                    <td class="td1">机会描述</td>
                    <td colspan="3" >${requestScope.chance.description}

                    </td>

                </tr>
                <tr>
                    <td class="td1">创建人</td>
                    <td class="td1" >${requestScope.chance.userByCreateuserid.username}

                    </td>
                    <td class="td1">创建时间</td>
                    <td class="td1">${requestScope.chance.createtime}

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
                    <td class="td2">指派给</td>
                    <td class="td1">
                   
                        <select id="userid" name="userid">
                       		<option value="">请选择..</option>
                       		<c:forEach items="${requestScope.users}" var="usr">
                           		 <option value="${usr.userid}">${usr.username}</option>
                       		</c:forEach>
                           
                        </select>
                        <input name="chanceid" id="chanceid" type="text" hidden="hidden" value="${requestScope.chance.chanceid}">
                        <span class="tab2">*</span>
                    </td>
                    <td class="td2">指派时间</td>
                    <td class="td1">${requestScope.chance.assigntime}
                        <input type="text" name="assigntime" id="assigntime" lay-verify="newTime" autocomplete="off" class="layui-input">
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
