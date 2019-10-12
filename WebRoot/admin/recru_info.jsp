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
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;招聘信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;信息列表<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="admin/recru_add.jsp">添加招聘信息</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<div id = "table">
<table class="default" width="100%">
	<col width="5%">
	<col width="20%">
	<col width="15%">
	<col width="15%">
	<col width="30%">
	<col width="15%">
	<tr class="title">
		<td>编号</td>
		<td>标题</td>
		<td>招聘类型</td>
		<td>招聘时间</td>
		<td>详情</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.recrulist" var="r">
	<tr class="list">		
		<td><s:property value="#r.recruId"/></td>
		<td><s:property value="#r.recruTitle"/></td>
		<td><s:property value="#r.recruType" /></td>
		<td><s:date name="#r.recruDate" format="yyyy年MM月dd日"/></td>
    	<td><s:property value="#r.recruDetail" /></td>  	
		<td><a href="<%=path%>/Admin_recrudelete.action?rid=<s:property value="#r.recruId"/>"  onclick="javascript: return confirm('真的要删除吗？');">删除</a>
		</td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</div>
</body>
</html>