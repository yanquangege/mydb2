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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <body>
    <h1>登录</h1>
    <p style="color: red;font-weight: 900">${msg }</p>
    <form action="<c:url value ='/UserServlet'/>" method ="post">
    <input type = "hidden" name = "method" value="login">
    用户名:<input type="text" name ="username" value="${form.username }"/>${errors.username }<br/>
 密码:<input type="password" name = "password" value="${form.password }"/>${errors.password }<br/>
 <input type="submit" value = "登录"/>
    </form>
  </body>
  </body>
</html>
