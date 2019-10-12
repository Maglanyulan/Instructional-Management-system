<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 成绩录入-查看学生成绩 -->
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/query.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;成绩信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;成绩录入<span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="Teacher_courselist.action?tid=${loginUserName}">返回</a>
		</div>
	</div>
</div>
</div>
 <div id="tips">
	<div id="buttonGroup">
		设置${stu_course.courseName}的成绩：
	</div>
</div> 

<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<s:form  action="Teacher_saveScore.action" method="post" theme="simple"> 
	<table class="default" width="100%">
	<col width="50%">
	<col width="50%">
	<tr class="title">
		<td>学生名字</td>
		<td>成绩</td>
	</tr> 
		<!-- 遍历开始 -->
		<s:iterator value="#session.stu_score" var="sco" status="status">
			<tr class="list">
				<td><s:textfield value="%{#session.stu_name[#status.index].stuName}"  readonly="true"/></td>		
				<td><s:textfield  value="%{#sco.score}" name="%{'scoreInfos['+#status.index+'].score'}"/></td>
				<s:hidden value="%{#session.stu_name[#status.index].stuId}" name="%{'scoreInfos['+#status.index+'].stuId'}" />
				<s:hidden value="%{#session.stu_course.courseId}" name="%{'scoreInfos['+#status.index+'].courseId'}" />
			</tr>
		</s:iterator>
		
		<s:hidden value="%{#session.stu_name.size()}" name="size" />
		<!-- 遍历结束 -->
	
</table>
<!-- 	<tr>
	    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
	  </tr>
	   -->
	<div id="tips">
	  <div id="button-group">
			<input type="submit" class="button" value="提交"/>
			<input type="reset" class="button" value="重置"/>
		</div>
	</div>
</s:form> 

</div>


</body>

</html>