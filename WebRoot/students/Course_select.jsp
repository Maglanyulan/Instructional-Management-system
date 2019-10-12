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
<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="${ pageContext.request.contextPath}/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;进行选课</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="Student_querycourse.action?sid=${loginUserName}">个人课程</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<s:form  action="Student_saveCourse.action" method="post" theme="simple"> 
<table class="default" width="100%">
	<col width="5%">
	<col width="10%">
	<col width="15%">
	<col width="5%">
	<col width="5%">
	<col width="10%">
	<col width="40%">
	<col width="10%">
	<tr class="title">
	  
    	<td>选择</td>
		<td>课程编号</td>
		<td>课程名</td>
		<td>学分</td>
		<td>类型</td>
		<td>课程学时</td>
		<td>上课时间地点</td>
		<td>任课教师</td>
	</tr>
	<!-- 遍历开始 -->
	<s:iterator value="#session.all_course" var="stu" status="status">
	<tr class="list">
	<td>
			<s:iterator value="#session.my_course" var="cou" >
			 <s:if test='%{#cou.courseId==#stu.courseId}'>
		        <s:set var="flag1" value="true"/>
		      </s:if>
		      <s:else>
		      	<s:set var="flag2" value="true"/>
		      </s:else>
			</s:iterator>
			
			<s:iterator value="#session.mysco_course" var="cous" >
		     	<s:if test='%{#cous.courseId==#stu.courseId}'>
		        	<s:set var="flag3" value="true"/>
		      	</s:if>
		      	<s:else>
		      		<s:set var="flag4" value="true"/>
		      	</s:else>
		     </s:iterator>
				
			<s:if test="flag1">
				 <s:if test="flag3"> 
					 已中选
					<s:set var="flag3" value="false"/>
				</s:if>
		        <s:else>
		        	<s:textfield type="radio" checked="checked" value="%{#stu.courseId}" name="%{#status.index}"/>
		          	<s:set var="flag4" value="false"/>
		        </s:else> 
		        <s:set var="flag1" value="false"/>
			</s:if>
			<s:else>
				<s:textfield type="radio" value="%{#stu.courseId}" name="%{#status.index}"/>
			</s:else>
     	</td>
		<td><s:property value="#stu.courseId"/></td>
		<td><s:property value="#stu.courseName"/></td>
		<td><s:property value="#stu.courseCredit"/></td>
		<td><s:property value="#stu.courseType"/></td>
		<td><s:property value="#stu.coursePeriod"/></td>
		<td><s:property value="#stu.courseTimeAddr"/></td>
		<td><s:property value="#session.userNames[#status.index]"/></td>
	</tr>
	</s:iterator>
	<s:hidden value="%{#session.loginUserName}" name="sid" />         
 	<s:hidden value="%{#session.all_course.size()}" name="size" />  
	<!-- 遍历结束 -->
</table>
<div id="tips">
	  <div id="button-group" style="padding-left:78%">
			<input type="submit" class="button" value="提交"/>
			<input type="reset" class="button" value="重置"/>
		</div>
	</div>
</s:form> 

</div>
</body>

    <script type="text/javascript">
        $(function(){
            $('input:radio').click(function(){
                //alert(this.checked);
                //

                var domName = $(this).attr('name');

                var $radio = $(this);
                // if this was previously checked
                if ($radio.data('waschecked') == true){
                    $radio.prop('checked', false);
                    $("input:radio[name='" + domName + "']").data('waschecked',false);
                    //$radio.data('waschecked', false);
                } else {
                    $radio.prop('checked', true);
                    $("input:radio[name='" + domName + "']").data('waschecked',false);
                    $radio.data('waschecked', true);
                }
            });
        });
    </script>

</html>
