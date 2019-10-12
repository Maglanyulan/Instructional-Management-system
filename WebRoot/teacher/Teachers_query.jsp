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
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/query.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;个人信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;基本信息<span>&nbsp;
	</div>
</div>
<div id="mainContainer">
         <table>
         <caption><h1>个人信息</h1></caption>
         <tr><!--第1行开始-->
            <th>姓名</th>
            <th>
               <s:property value= "#session.my_Info.TName"/>
            </th>
            <th>工号</th>
            <th>
               <s:property value="#session.my_Info.teacherId" />
            </th>
         </tr><!--第1行结束-->
 
         <tr><!--第2行开始-->
            <th>性别</th>
            <th>
               <s:property value="#session.my_Info.TSex"/>
            </th>
            <th>出生日期</th>
            <th>
               <s:date name="#session.my_Info.TDate" format="yyyy年MM月dd日"/>
            </th>
         </tr><!--第2行结束-->
 
         <tr><!--第3行开始-->
            <th>学院</th>
            <th colspan="3">
               <s:property value="#session.my_Info.TCollege"/>
            </th>
         </tr><!--第3行结束-->
 
         <tr><!--第4行开始-->
            <th>电话</th>
            <th colspan="3">
               <s:property value="#session.my_Info.TPhone" />
            </th>
         </tr><!--第4行结束-->
 
         <tr><!--第5行开始-->
            <th>头衔</th>
            <th colspan="3">
               <s:property value="#session.my_Info.TJobTitle" />
            </th>
         </tr><!--第5行结束-->
         </table>
</div>

</body>
<style type="text/css">
#mainContainer{
    padding-top:30px;
	padding-left:15%;
	padding-right:15%;
	width:100%;
	font-family:微软雅黑;
	font-size:20px;
}
table {	
	border:1px solid;
	align:center;
	text-align:center;
	width:73%;	
}
caption {
	padding:10px 0;
}
th,th {
	padding:4px 0;
	border:1px solid;
}
</style>

</html>