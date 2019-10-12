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
			<a href="Student_makecourse.action?sid=${loginUserName}">个人课程</a>
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

<table class="default" width="80%">
 	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<tr class="title">
		<td id="th1">   </td>
		<td id="th2">周一</td>
		<td id="th2">周二</td>
		<td id="th2">周三</td>
		<td id="th2">周四</td>
		<td id="th2">周五</td>
		<td id="th2">周六</td>
		<td id="th2">周日</td>
	</tr>
	<tr>
		<td>1-2节</td>
		<td><s:property value="#session.table11"/></td>
		<td><s:property value="#session.table21"/></td>
		<td><s:property value="#session.table31"/></td>
		<td><s:property value="#session.table41"/></td>
		<td><s:property value="#session.table51"/></td>
		<td><s:property value="#session.table61"/></td> 
		<td><s:property value="#session.table71"/></td>    
	</tr> 
	<tr>     
		<td>3-4节</td>
		<td><s:property value="#session.table12"/></td>
		<td><s:property value="#session.table22"/></td>
		<td><s:property value="#session.table32"/></td>
		<td><s:property value="#session.table42"/></td>
		<td><s:property value="#session.table52"/></td>
		<td><s:property value="#session.table62"/></td> 
		<td><s:property value="#session.table72"/></td>    
	</tr> 
	<tr>
		<td>5-6节</td>
		<td><s:property value="#session.table13"/></td>
		<td><s:property value="#session.table23"/></td>
		<td><s:property value="#session.table33"/></td>
		<td><s:property value="#session.table43"/></td>
		<td><s:property value="#session.table53"/></td>
		<td><s:property value="#session.table63"/></td> 
		<td><s:property value="#session.table73"/></td>   
	</tr> 
	<tr>
		<td>7-8节</td>
		<td><s:property value="#session.table14"/></td>
		<td><s:property value="#session.table24"/></td>
		<td><s:property value="#session.table34"/></td>
		<td><s:property value="#session.table44"/></td>
		<td><s:property value="#session.table54"/></td>
		<td><s:property value="#session.table64"/></td> 
		<td><s:property value="#session.table74"/></td>   
	</tr> 
</table>
</div>
</body>
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
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
	margin-top:10px;
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
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>

</html>