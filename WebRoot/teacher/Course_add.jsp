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
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/add_2.css" />
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;开设课程<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<%-- <a href="<%=path%>/teacher/Course_add.jsp">课程开设</a> --%>
			<a href="Teacher_coursequery.action">开课信息</a>
		</div>
	</div>
</div>
<div style="padding-left:30px">添加个人课程：
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<form name="addForm" action="Teacher_courseAdd.action?tid=${loginUserName}" method="post">
	<table width="100%" style="border-collapse:separate; border-spacing:25px;" >
	  <tr>
	    <td width="9%">课程号：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="courseId" /></td>
	    <td width="9%">课程名称：</td>
	    <td><input  style="width:180px;height:20px;" type="text" name="courseName" /></td>
	  </tr>	  
	  <tr>	    
	    <td>学分：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="courseCredit" /></td>
	    <td>类型：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="courseType" /></td>
	  </tr>
	  <tr>	    
	     <td>课时：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="coursePeriod" /></td>
	     <td>时间地点：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="courseTimeAddr" /></td>
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



</style>

</html>