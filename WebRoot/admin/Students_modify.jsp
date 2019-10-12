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
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/add_2.css" />
<body>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;用户管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生列表<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;修改资料<span>&nbsp;
	</div>
</div>

<div id="tips">
	<div id="buttonGroup">
	<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="Admin_stuquery.action">返回</a>
	</div>
	</div>
</div>

<div id="mainContainer">
<!-- 从session中获取学生集合 -->


<div id="mainContainer">
<form name="modifyForm" action="Admin_stusave.action" method="post">
<table width="100%" style="border-collapse:separate; border-spacing:25px;" >
  <tr>
    <td width="9%">学号：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuId" value='<s:property value="#session.modify_students.stuId"/>'  readonly="readonly"/></td>
    <td width="9%">姓名：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuName" value='<s:property value="#session.modify_students.stuName"/>'/></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>
      <s:if test='%{#session.modify_students.stuSex=="男"}'>
         <input type="radio" name="stuSex" value="男" checked="checked"/>男
         <input type="radio" name="stuSex" value="女"/>女
      </s:if>
      <s:else>
         <input type="radio" name="stuSex" value="男" />男
         <input type="radio" name="stuSex" value="女" checked="checked"/>女
      </s:else>
      </td>
    <td>出生日期：</td>
    <td><input style="width:180px;height:20px;" name="stuBirth" type="text" id="control_date" size="20"
      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" 
      value="<s:date name="#session.modify_students.stuBirth" format="yyyy-MM-dd"/>"
      />
    </td>
  </tr>
  <tr>
    <td>居住地：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuAddr" value='<s:property value="#session.modify_students.stuAddr"/>'/></td>
    <td width="9%">专业：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuClass" value='<s:property value="#session.modify_students.stuClass"/>' /></td>
  </tr>
  <tr>
    <td>生源地：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuSource" value='<s:property value="#session.modify_students.stuSource"/>' /></td>
    <td>辅导员：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuCounsellor"value='<s:property value="#session.modify_students.stuCounsellor"/>'  /></td>
  </tr>
   <tr>
    <td>电话：</td>
    <td><input style="width:180px;height:20px;" type="text" name="stuPhone"value='<s:property value="#session.modify_students.stuPhone"/>'  /></td>
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