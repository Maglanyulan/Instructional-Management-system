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
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教学信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;公告列表<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="admin/anno_add.jsp">添加教学公告</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<div id = "table">
<table class="default" width="100%">
	<col width="5%">
	<col width="20%">
	<col width="30%">
	<col width="15%">
	<col width="20%">
	<col width="10%">
	<tr class="title">
		<td>编号</td>
		<td>标题</td>
		<td>详情</td>
		<td>部门</td>
		<td>发布时间</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.annolist" var="a">
	<tr class="list">		
		<td><s:property value="#a.tAnnoId"/></td>
		<td><s:property value="#a.title"/></td>
		<td><s:property value="#a.detail" /></td>
    	<td><s:property value="#a.publishDapartment" /></td>
    	<td><s:date name="#a.publishTime" format="yyyy年MM月dd日 HH:mm:ss"/></td>
		<td><a href="<%=path%>/Admin_annodelete.action?aid=<s:property value="#a.tAnnoId"/>"  onclick="javascript: return confirm('真的要删除吗？');">删除</a>
		</td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</div>
</body>
</html>