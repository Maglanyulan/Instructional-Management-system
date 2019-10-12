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
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/add_1.css" />
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;信息管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="Teacher_courselist.action">培养计划</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup" >
		<div class="button"  onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/Admin_queryPYList.action" target="_blank">查看培养方案</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>添加培养计划</strong>
<br>
<br>
<form name="addForm" action="<%=path%>/Teacher_courseAdd.action" method="post">
<table width="600" >

  <tr> 
	  <td width="30%">学院：</td>
	  <td>
		  <select onchange="window.open(this.options[this.selectedIndex].value,target='_self')" name="select" style="width: 200px">
			  <option value="">-请选择-</option>
			  <%-- <option value="<%=path%>/admin/trainplanlist_WX.jsp">物信</option>
			  <option value="<%=path%>/admin/trainplanlist_JG.jsp">经管</option> --%>
			  
			  <s:iterator value="#session.college" var="col" >
						<%-- <option value="<%=path%>/Admin_majorlist.action?college=<s:property value="#col.college"/>" >${col.college}</option> --%>
			  			<%-- <option value="<%=path%>/Admin_majorlist.action?college=<%=session.getAttribute("college")%>/>" >${col.college}</option> --%>
			  			<option value="<%=path%>/Admin_majorlist.action?majorid=<s:property value="#col.majorId"/>" >${col.college}</option>
			  </s:iterator>
		</select> 
	  </td>
  </tr>
  
    <tr> 
	  <td width="30%">专业：</td>
	  <td>
		  <select onchange="window.open(this.options[this.selectedIndex].value,target='_self')" style="width: 200px; background-color: #EEEEEE;" disabled="disabled" name="select">
			  <option value="">-请选择-</option>
		  </select> 
	  </td>
  </tr>
  
  <tr> 
	  <td width="30%">年级：</td>
	  <td>
		  <select onchange="window.open(this.options[this.selectedIndex].value,target='_self')" style="width: 200px; background-color: #EEEEEE;" disabled="disabled" name="select">
			  <option value="">-请选择-</option>
		  </select> 
	  </td>
  </tr>
  
  <tr> 
	  <td width="30%">培养层次：</td>
	  <td>
		  <select onchange="window.open(this.options[this.selectedIndex].value,target='_self')" style="width: 200px; background-color: #EEEEEE;" disabled="disabled" name="select">
			  <option value="">-请选择-</option>
		  </select> 
	  </td>
  </tr>
  
  <tr>
    <td width="30%">编号：</td>
    <td><s:textfield  name="college" readonly="readonly" style="width: 200px; background-color: #EEEEEE;" theme="simple"/></td>   
  </tr>
  <tr>
    <td width="30%">培养计划：</td>
    <td><s:textfield   name="college" readonly="readonly" style="width: 500px;height:150px; background-color: #EEEEEE;" theme="simple"/></td>   
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
</html>