<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/query.css" />
<body>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师信息<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="admin/Teachers_add.jsp">添加教师</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取教师集合 -->
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
	<tr class="title">
		<td>工号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>出生日期</td>
		<td>职位</td>
		<td>学院</td>
		<td>电话</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.teacherlist" var="tea">
	<tr class="list">
		<td><s:property value="#tea.teacherId"/></td>
		<td><s:property value="#tea.TName"/></td>
		<td><s:property value="#tea.TSex"/></td>
		<td><s:date name="#tea.TDate" format="yyyy年MM月dd日"/></td>
		<td><s:property value="#tea.TJobTitle"/></td>
		<td><s:property value="#tea.TCollege"/></td>
		<td><s:property value="#tea.TPhone"/></td>
		<td><a href="Admin_teadelete.action?tid=<s:property value="#tea.teacherId"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a>
			<a href="Admin_teamodify.action?tid=<s:property value="#tea.teacherId"/>" >修改</a>
		</td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</div>
</body>

</html>