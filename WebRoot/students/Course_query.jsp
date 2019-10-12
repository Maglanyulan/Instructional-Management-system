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
<body>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;查询课程</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="Student_makecourse.action?sid=${loginUserName}">导出课程表</a>
		</div>
	</div>
</div>
 <div id="tips">
	<div id="buttonGroup">
		个人课程：
	</div>
</div> 
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="100%">
	<col width="15%">
	<col width="15%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="30%">
	<col width="10%">
	<tr class="title">
		<td>课程编号</td>
		<td>课程名</td>
		<td>学分</td>
		<td>类型</td>
		<td>课程学时</td>
		<td>上课时间地点</td>
		<td>任课教师</td>
	</tr>
	<!-- 遍历开始 -->
	<s:iterator value="#session.my_course" var="stu" status="status">
	<tr class="list">
		<td><s:property value="#stu.courseId"/></td>
		<td><s:property value="#stu.courseName"/></td>
		<td><s:property value="#stu.courseCredit"/></td>
		<td><s:property value="#stu.courseType"/></td>
		<td><s:property value="#stu.coursePeriod"/></td>
		<td><s:property value="#stu.courseTimeAddr"/></td>
		<td><s:property value="#session.userNames[#status.index]"/></td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</body>
</html>