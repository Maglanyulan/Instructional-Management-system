<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/default.css" />
	
	
<body>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;信息管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学院专业<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;修改专业<span>&nbsp;
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
<!-- 从session中获取专业集合 -->

<form name="modifyForm" action="Admin_majorsave.action" method="post">
	<table width="100%" style="border-collapse:separate; border-spacing:25px;">
	
	   <tr>
	    <td width="9%">专业代码：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="majorId" value='<s:property value="#session.modify_majors.majorId" />' readonly="readonly"/></td>
	    <td width="9%">学院：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="college" value='<s:property value="#session.modify_majors.college"/>' /></td>
	  </tr>

	  <tr>
	    <td width="9%">专业：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="majorName" value='<s:property value="#session.modify_majors.majorName"/>' /></td>
	    <td width="9%">学科门类：</td>
	    <td><input style="width:180px;height:20px;" type="text" name="grade" value='<s:property value="#session.modify_majors.grade"/>' /></td> 
	  </tr>
	</table>
	<div id="tips">
		<div id="buttonGroup" class="b-right">
		<input class="button" type="submit" value="修改" style="width:100px;height:35px;" onmouseover="this.style.backgroundColor='#77D1F6'" onmouseout="this.style.backgroundColor=''">
		</div>
	</div>
</form>
</div>
</body>

<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:20px;
	margin-bottom:20px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	width:98%;
	font-size:16px;
}
.b-right{
	margin-left:65%;
}


</style>

</html>