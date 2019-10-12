<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 开课信息 -->

<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />

<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;首页<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<!-- <a href="Teacher_coursequery.action"> -->详情<!-- </a> --><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<%-- <a href="<%=path%>/teacher/Course_add.jsp">课程开设</a> --%>
			<a href="<%=path%>/MainPage_getJXList.action">返回</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="80%">

	<col width="80%">

<!-- 	<tr class="title">
		<td>课程名称</td>
		<td>学分</td>
		<td>任课老师</td>
		<td>类型</td>
		<td>课时</td>
		<td>时间地点</td>
		<td>操作</td>
	</tr> -->
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.JXContext" var="jxcontent">
	<tr class="list">
		<td><s:property value="#jxcontent.detail"/></td>
<%-- 		<td><s:property value="#cou.courseCredit"/></td>
		<td><s:property value="#cou.teacherInfo.getTeacherId()"/></td>
		<td><s:property value="#cou.courseType"/></td>
		<td><s:property value="#cou.coursePeriod"/></td>
		<td><s:property value="#cou.courseTimeAddr"/></td> --%>
		
		<%-- <td><a href="<%=path%>/Student_delete.action?sid=<s:property value="#stu.stuId"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td> --%>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
	
	
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