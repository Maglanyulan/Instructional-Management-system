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
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/add_2.css" />
	
<body>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;信息管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学院专业<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加专业<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="${ pageContext.request.contextPath}/Admin_majorquery.action">返回</a>
		</div>
	</div>
</div>

<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<form name="addForm" action="Admin_majoradd.action" method="post">
	<table width="100%" style="border-collapse:separate; border-spacing:25px;">
	
	   <tr>
	    <td width="9%">专业代码：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="majorId" /></td>
	    <td width="9%">学院：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="college" /></td>
	  </tr>
	  <tr>
	    <td width="9%">专业：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="majorName" /></td>
	    <td width="9%">学科门类：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="grade" /></td> 
	  </tr>
	</table>
	<div id="tips">
		<div id="buttonGroup" class="b-right">
		<input class="button" type="submit" value="添加" style="width:100px;height:35px;" onmouseover="this.style.backgroundColor='#77D1F6'" onmouseout="this.style.backgroundColor=''">
		</div>
	</div>
</form>
</div>
</body>
</html>