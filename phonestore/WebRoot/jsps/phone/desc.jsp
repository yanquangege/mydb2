<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'desc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			font-size: 10pt;
		}
		div{
			width : 200px;
			height : 320px;
			text-align: center;
			float: left;
			border:1px solid gray;
			margin:20px 30px;
			
		}
		img{width: 200;height: 200}
		li{text-align: left;}
	</style>
  </head>
  
  <!-- 测试git3 3-->
  <body>
    <div>
    	<img src="<c:url value='/${phone.image }'/>"/><br/>
    	
    
    <ul>
    	<li>书名：${phone.pname }</li>
    	<li>价格：${phone.price }</li>
    	<li>厂家：${phone.producer }</li>
    </ul>
   	<form action="<c:url value = '/CartServlet'/>" method="post">
   		<input type="hidden" name = "method" value = "add"/>
   		<input type="hidden" name = "pid" value = "${phone.pid }"/>
		<input type = "text" name = "count" value ="1" style="width: 50px;"/>
		<input type ="submit" value ="购买"/> 
	</form>
	</div>
  </body>
</html>
