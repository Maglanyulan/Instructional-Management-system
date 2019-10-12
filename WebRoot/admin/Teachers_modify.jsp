<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="${ pageContext.request.contextPath}text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/default.css" />
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/add_2.css" />
<body>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师信息<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;修改资料<span>&nbsp;
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

<form name="modifyForm" action="Admin_teasave.action" method="post">
<table width="100%" style="border-collapse:separate; border-spacing:25px;" >

  <tr>
   <td width="9%">工号：</td>
    <td><input style="width:180px;height:20px;" type="text" name="teacherId" value='<s:property value="#session.modify_teachers.teacherId"/>'  readonly="readonly"/></td>
    <td width="9%">姓名：</td>
    <td><input style="width:180px;height:20px;" type="text" name="TName" value='<s:property value="#session.modify_teachers.TName"/>'/></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>
      <s:if test='%{#session.modify_teachers.TSex=="男"}'>
         <input type="radio" name="TSex" value="男" checked="checked"/>男
         <input type="radio" name="TSex" value="女"/>女
      </s:if>
      <s:else>
         <input type="radio" name="TSex" value="男" />男
         <input type="radio" name="TSex" value="女" checked="checked"/>女
      </s:else>
      </td>
    <td>出生日期：</td>
    <td><input style="width:180px;height:20px;" name="TDate" type="text" id="control_date" size="20"
      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" 
      value="<s:date name="#session.modify_teachers.TDate" format="yyyy-MM-dd"/>"
      />
    </td>
  </tr>
  <tr>
    <td>头衔：</td>
    <td><input style="width:180px;height:20px;" type="text" name="TJobTitle" value='<s:property value="#session.modify_teachers.TJobTitle"/>'/></td>
    <td>学院:</td>
    <td><input style="width:180px;height:20px;" type="text" name="TCollege" value='<s:property value="#session.modify_teachers.TCollege"/>'/></td>
  </tr>
    <tr>
    <td>电话:</td>
    <td><input style="width:180px;height:20px;" type="text" name="TPhone" value='<s:property value="#session.modify_teachers.TPhone"/>'/></td>
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
</html>