<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 成绩录入 -->
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/query.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;成绩信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生成绩<span>&nbsp;
	</div>
</div>

<div id="tips">

</div> 
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="100%">
	<col width="50%">
	<col width="50%">
	<tr class="title">
		<td>课程名称</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.courselist" var="cou">
	<tr class="list">
		<td><s:property value="#cou.courseName"/></td>	
		<td><a href="<%=path%>/Teacher_quaryscore.action?cid=<s:property value="#cou.courseId"/>" >查看学生成绩</a>
			<a href="<%=path%>/Teacher_scoreAdd.action?cid=<s:property value="#cou.courseId"/>" >录入成绩</a>
		</td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
	
	
</table>
</div>
</body>
</html>