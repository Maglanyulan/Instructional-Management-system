<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/query.css" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<body>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;用户管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生列表<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="admin/Students_add.jsp">添加学生</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<div id = "table">
<table class="default" width="100%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<tr class="title">
		<td>学号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>专业</td>
		<td>出生日期</td>
		<td>居住地</td>
		<td>生源地</td>
		<td>辅导员</td>
		<td>电话</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.studentlist" var="stu">
	<tr class="list">
		<td><s:property value="#stu.stuId"/></td>
		<td><s:property value="#stu.stuName"/></td>
		<td><s:property value="#stu.stuSex"/></td>
		<td><s:property value="#stu.stuClass"/></td>
		<td><s:date name="#stu.stuBirth" format="yyyy年MM月dd日"/></td>
		<td><s:property value="#stu.stuAddr"/></td>
		<td><s:property value="#stu.stuSource"/></td>
		<td><s:property value="#stu.stuCounsellor" /></td>
    	<td><s:property value="#stu.stuPhone" /></td>
		<td><a href="<%=path%>/Admin_studelete.action?sid=<s:property value="#stu.stuId"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a>
			<a href="<%=path%>/Admin_stumodify.action?sid=<s:property value="#stu.stuId"/>" >修改</a>
		</td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</div>
</body>
</html>