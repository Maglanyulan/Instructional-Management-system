<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 开课信息 -->

<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/query.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程信息<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<%-- <a href="<%=path%>/teacher/Course_add.jsp">课程开设</a> --%>
			<a href="<%=path%>/teacher/Course_add.jsp">课程开设</a>
		</div>
	</div>
</div>

<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="100%">
	<col width="20%">
	<col width="15%">
	<col width="15%">
	<col width="10%">
	<col width="10%">
	<col width="30%">
	<tr class="title">
		<td>课程名称</td>
		<td>学分</td>
		<td>任课老师</td>
		<td>类型</td>
		<td>课时</td>
		<td>时间地点</td>
		<!-- <td>操作</td> -->
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.courselist" var="cou" status="status">
	<tr class="list">
		<td><s:property value="#cou.courseName"/></td>
		<td><s:property value="#cou.courseCredit"/></td>
		<td><s:property value="#session.tea_name[#status.index].TName"/></td>
		<td><s:property value="#cou.courseType"/></td>
		<td><s:property value="#cou.coursePeriod"/></td>
		<td><s:property value="#cou.courseTimeAddr"/></td>
	</s:iterator>
	<!-- 遍历结束 -->
	
	
</table>
</div>
</body>
</html>