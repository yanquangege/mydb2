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
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
    <h1 style="text-align: center;">烟圈哥的手机店</h1><br/><br/>
    <div style="font-size: 10pt;">
    
    
    <c:choose>
    	<c:when test="${empty sessionScope.session_user }">
    		<a href="<c:url value = '/jsps/user/login.jsp'/>" target="_parent">登录</a>
    		<a href="<c:url value = '/jsps/user/regist.jsp'/>" target="_parent">注册</a>
    	</c:when>
    	<c:otherwise>
			 您好：${sessionScope.session_user.username }&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value = '/jsps/cart/list.jsp'/>" target="body">我的购物车 </a>&nbsp;|&nbsp;
			<a href="<c:url value = '/jsps/order/list.jsp'/>" target="body">我的订单</a>&nbsp;|&nbsp;
			<a href="<c:url value = '/UserServlet?method=quit'/>" target="_parent">退出</a>
    	</c:otherwise>
    </c:choose>

    
    </div>
  </body>
</html>
