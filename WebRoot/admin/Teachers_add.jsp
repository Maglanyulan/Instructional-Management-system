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
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加教师<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="${ pageContext.request.contextPath}/Admin_teaquery.action">返回</a>
		</div>
	</div>
</div>

<div id="mainContainer">
<!-- 从session中获取学生集合 -->

	<form name="addForm" action="<%=path%>/Admin_teaadd.action" method="post">
		<table table width="100%" style="border-collapse:separate; border-spacing:25px;" >
		  <tr>
		   <td width="9%">姓名：</td>
		    <td><input type="text" name="TName" style="width:180px;height:20px;"/></td>
		    <td width="9%">工号：</td>
		    <td><input type="text" name="teacherId" style="width:180px;height:20px;" /></td>
		  </tr>
		  
		  <tr>
		    <td>性别：</td>
		    <td><input type="radio" name="TSex" value="男" checked="checked" />男<input type="radio" name="TSex" value="女"/>女</td>
		    <td>出生日期：</td>
		    <td><input style="width:180px;height:20px;" name="TDate" type="text" id="control_date" size="20"
		      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
		    </td>
		  </tr>
		  
		  <tr>
		    <td>头衔：</td>
		    <td><input type="text" name="TJobTitle" style="width:180px;height:20px;" /></td>
		    <td>学院：</td>
		    <td><input type="text" name="TCollege" style="width:180px;height:20px;" /></td>
		  </tr>
		  <tr>
		    <td>电话：</td>
		    <td><input type="text" name="TPhone" style="width:180px;height:20px;" /></td>
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