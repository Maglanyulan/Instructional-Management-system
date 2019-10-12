<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 成绩录入-查看学生成绩 -->
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
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;查看成绩<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="Teacher_courselist.action?tid=${loginUserName}">返回</a>
		</div>

	</div>
</div>
</div>
 <div id="tips">
	<div id="buttonGroup">
		${stu_course}成绩：
	</div>
</div> 
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="100%">
	<col width="50%">
	<col width="50%">
	<tr class="title">
		<td>学生名字</td>
		<td>成绩</td>
	</tr>
	
		<!-- 遍历开始 -->
		<s:iterator value="#session.stu_score" var="sco" status="status">
			<tr class="list">
				<td><s:property value="#session.stu_name[#status.index]"/></td>		
				<td><s:property value="#sco.score"/></td> 
			</tr>
		</s:iterator>
		<!-- 遍历结束 -->
	

	
</table>
</div>
</body>


</html>