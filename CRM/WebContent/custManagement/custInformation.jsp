<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/28
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>客户信息</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/main.css" />
    <link rel="stylesheet" href="css/custInformation.css"/>
<script type="text/javascript">
function ajax(pid,selectId){
	$.ajax({
		   type: 'post',
		   url: "/CRM/getAreas",
		   data: {
			   pid:pid
			   },
		   dataType:"json",
		   success:function(ars){
			   $("#"+selectId).empty();
			   $.each(ars,function(index,context){
				   var sel = "";
				   if("${sessionScope.customer.area.area.area.areaid}"==context.areaid || "${sessionScope.customer.area.area.areaid}"==context.areaid || "${sessionScope.customer.area.areaid}"==context.areaid){
					   sel = "selected='selected'";
				   }
				   $("#"+selectId).append("<option value='"+context.areaid+"' "+sel+">"+context.aname+"</option>");
			   });
			  
		   }
			  
		 });
}
$(function(){
	ajax(0,"prov");
	ajax("${sessionScope.customer.area.area.area.areaid}","city");
	ajax("${sessionScope.customer.area.area.areaid}","coun");
	$("#uid").val("${sessionScope.customer.user.userid}");
	$("#ddid1").val("${sessionScope.customer.datadictionaryByRelationshiplevel.ddid}");
	$("#ddid2").val("${sessionScope.customer.datadictionaryBySatisfaction.ddid}");
	$("#ddid03").val("${sessionScope.customer.datadictionaryByCredit.ddid}");
});
</script>
</head>
<body>
<div id="main">
    <%--路径--%>
    <div id="nav">
        <span class="title1">
		  <a href="">客户信息管理 ></a>
		  <a href="">客户信息 ></a>
		</span>
    </div>
        <form id="custInfo" method="post" action="/CRM/custManagement/Customer_update">
            <%--//选择按钮--%>
                <div class="layui-btn-group globalHight">
                    <button class="layui-btn">帮助</button>
                    <button class="layui-btn"><a href="/CRM/webContent/custManagement/contactA!contact?cuostomerid=${sessionScope.customer.cuostomerid }"> 联系人</a></button>
                    <button class="layui-btn"><a href="/CRM/webContent/custManagement/contactB!tian?cuostomerid=${sessionScope.customer.cuostomerid }">交往记录</a></button>
                    <button class="layui-btn"><a href="historicalOrder.jsp">历史订单</a></button>
                    <button class="layui-btn"><a href="custManage.jsp">返回</a></button>
                    <button class="layui-btn layui-btn-warm"><a onclick="submit()">保存</a></button>
                </div>
            <%--表格--%>

                <div>
                    <%--表一+++++++++++++--%>
                    <table class="layui-table" >
                        <colgroup>
                            <col class="tit">
                            <col class="content">
                            <col class="tit">
                            <col class="content">
                        </colgroup>
                        <tr>
                            <th>客户编号</th>
                            <th>
                                <label>${sessionScope.customer.cuostomerid }</label>
                                <input type="hidden" name="cuostomerid" value="${sessionScope.customer.cuostomerid }">
                            </th>
                            <th>名称</th>
                            <th>
                                <input type="text" name="company" value="${sessionScope.customer.company }">
                                <span>*</span>
                            </th>
                        </tr>
                        <tr>
                            <td>地区</td>
                            <td>
                                <select style="width:90px;" id="prov" onchange="ajax(this.value,'city')"></select >
                                <select style="width:90px;" id="city" onchange="ajax(this.value,'coun')"></select>
                                <select style="width:90px;" id="coun" name="area.areaid"></select>
                                <span>*</span>
                            </td>
                            <td>客户经理</td>
                            <td>
                                <div>
                                    <select name="user.userid" id="uid">
                                    
                                    <c:forEach items="${sessionScope.users }" var="user1">
                                    
                                    	<option value="${user1.userid }" >${user1.username }</option>
                                    </c:forEach>
                                    </select>
                                    <span>*</span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>客户等级</td>
                            <td colspan="3">
                                <select name="datadictionaryByRelationshiplevel.ddid" id="ddid1">
                                    <c:forEach items="${sessionScope.rela }" var="rela">
                                    
                                    	<option value="${rela.ddid }" >${rela.ddname }</option>
                                    </c:forEach>
                                </select>
                                <span>*</span>
                            </td>
                        </tr>
                        <tr>
                            <td>客户满意度</td>
                            <td>
                                <select name="datadictionaryBySatisfaction.ddid" id="ddid2">
                                    <c:forEach items="${sessionScope.sati }" var="sati">
                                    
                                    	<option value="${sati.ddid }" >${sati.ddname }</option>
                                    </c:forEach>
                                </select>
                                <span>*</span>
                            </td>
                            <td>客户信用度</td>
                            <td>
                                <select name="datadictionaryByCredit.ddid" id="ddid3">
                                    <c:forEach items="${sessionScope.cred }" var="cred">
                                    
                                    	<option value="${cred.ddid }" >${cred.ddname }</option>
                                    </c:forEach>
                                </select>
                                <span>*</span>
                            </td>
                        </tr>
						</table>
						<table class="layui-table" >
                        <colgroup>
                            <col class="tit">
                            <col class="content">
                            <col class="tit">
                            <col class="content">
                        </colgroup>
                        <tr>
                        <td>地址</td>
                        <td>
                            <input type="text" name="address" value="${sessionScope.customer.address }">
                            <span>*</span>
                        </td>
                        <td>邮政编码</td>
                        <td>
                            <input type="text" name="postalcode" value="${sessionScope.customer.postalcode }">
                            <span>*</span>
                        </td>
                    </tr>
                        <tr>
                            <td>电话</td>
                            <td>
                                <input type="text" name="phone" value="${sessionScope.customer.phone }">
                                <span>*</span>
                            </td>
                            <td>传真</td>
                            <td>
                                <input type="text" name="fax" value="${sessionScope.customer.fax}">
                                <span>*</span>
                            </td>
                        </tr>
                        <tr>
                            <td>网址</td>
                            <td>
                                <input type="text" name="url" value="${sessionScope.customer.url}">
                                <span>*</span>
                            </td>
                            <td></td>
                            <td>
                            </td>
                        </tr>
                      </table>
						<table class="layui-table" >
                        <colgroup>
                            <col class="tit">
                            <col class="content">
                            <col class="tit">
                            <col class="content">
                        </colgroup>
                        <tr>
                            <td>营业执照注册号</td>
                            <td>
                                <input type="text" name="licenseno" value="${sessionScope.customer.licenseno}">
                            </td>
                            <td>法人</td>
                            <td>
                                <input type="text" name="corporation" value="${sessionScope.customer.corporation}">
                                <span>*</span>
                            </td>
                        </tr>
                        <tr>
                            <td>注册资金（万元）</td>
                            <td>
                                <input type="text" name="capital" value="${sessionScope.customer.capital}">
                            </td>
                            <td>年营业额</td>
                            <td>
                                <input type="text" name="turnover" value="${sessionScope.customer.turnover}">
                            </td>
                        </tr>
                        <tr>
                            <td>开户银行</td>
                            <td>
                                <input type="text" name="bank" value="${sessionScope.customer.bank}">
                                <span>*</span>
                            </td>
                            <td>银行账号</td>
                            <td>
                                <input type="text" name="bankaccount" value="${sessionScope.customer.bankaccount}">
                                <span>*</span>
                            </td>
                        </tr>
                        <tr>
                            <td>地税登记号</td>
                            <td>
                                <input type="text" name="landtax" value="${sessionScope.customer.landtax}">
                            </td>
                            <td>国税登记号</td>
                            <td>
                                <input type="text" name="nationaltax" value="${sessionScope.customer.nationaltax}">
                            </td>
                        </tr>
                    </table>
                </div>
        </form>
</div>
</body>
</html>
