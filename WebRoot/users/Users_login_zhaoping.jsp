<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 这是一个html5 doctype声明 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/css/login.css" />
</head>

<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title">教学信息管理系统</div>
			<div id="subTitle">Ver 1.0</div>
		</div>
	</div>
	<div id="main">
		<div id="mainBg">		
			<div id="mainPanel">
				<div id="left">
					 <div id="menu_container">
						<ul id="menu_items">
							<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='2px 0 0 2px'"><a href="<%=path%>/MainPage_getJXList.action">教学公告</a></li>
							<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>招聘信息</a></li>
							<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a href="<%=path%>/MainPage_getPYList.action">培养计划</a></li>	
						</ul>
					 </div>
					 <div id = "table" onscroll="javascript:titleTable.style.posLeft=-dataField.scrollLeft">									
						<s:iterator value="#session.ZPtitle" var="zptitle">
						
							<%-- <td><s:property value="#jxtitle.title"/></td> --%>
							<ul>
								<li>  
									<%-- <s:a href='MainPage_getJXContent.action?id=<s:property value="%{#jxtitle.TAnnoId}"/>'> --%>  
									<s:a href='MainPage_getZPContent.action?id=%{#zptitle.recruId}'>
										<s:property value="#zptitle.recruTitle+#zptitle.recruDate"/>  
									</s:a>
								</li>
							</ul>
						
						</s:iterator>
     				</div>

					 
				    
			</div>  
				 
			<div id="right">
				
				<form name="loginForm" action="Login_login" method="post">
				<!-- start of login form -->
				<div id="welcome">
					<span id="welcome-text">管&nbsp;理&nbsp;登&nbsp;录</span>
				</div>
				<div id="user-name">
					<span class="item">用户名:</span>
					<span><input type="text" name="UId" class="form-input"></span>
				</div>
				<div id="user-password">
					<span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
					<span class="input"><input type="password" name="UPassword" class="form-input"></span>
				</div>
				<div id="button-group">
					<input type="submit" class="btn" value="登录"/>
					<input type="reset" class="btn" value="重置"/>
				</div>
				<div>
				  <s:fielderror/> <!-- 显示表单验证的出错信息 -->
				</div>
				<!-- end of form -->
				</form>
				
			</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="text">Copyright © 2018 All Rights Reserved Powered By 620</div>
	</div>
</div>
</body>
</html>

