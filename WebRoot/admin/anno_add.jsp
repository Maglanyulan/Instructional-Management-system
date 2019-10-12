<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 开课信息-课设开设 -->
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/add_1.css" />

<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;信息管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="Teacher_courselist.action">教学信息</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup" >
		<div class="button"  onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/Admin_annoquery.action" >查看教学信息</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>添加教学信息</strong>
<br>
<br>
<form name="addForm" action="Admin_annoadd.action" method="post">
<table width="600" >

  <tr> 
	  <td width="30%">标题：</td>
	  <td><input style="width:180px;height:20px;" type="text" name="title" /></td>
	
  </tr>
  
    <tr> 
	  <td width="30%">部门：</td>
	  <td><input style="width:180px;height:20px;" type="text" name="publishDapartment" /></td>
  </tr>
  <tr>
    <td width="30%">详情：</td>
    <td><s:textfield   name="detail" readonly="readonly" style="width: 500px;height:200px; background-color: #EEEEEE;" theme="simple"/></td>   
  </tr>
</table>
<div id="tips">
		<div id="buttonGroup" class="b-right">
		<input class="button" type="submit" value="发布" style="width:100px;height:35px;" onmouseover="this.style.backgroundColor='#77D1F6'" onmouseout="this.style.backgroundColor=''">
		</div>
	</div>
</form>


</div>
</body>
</html>