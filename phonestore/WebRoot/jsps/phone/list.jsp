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
    
    <title>My JSP 'phone.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.icon{ border:1px solid gray;
			   float: left;
			   text-align: center;
			   margin:20px 30px;} 
		img{width: 300;height: 300}
	</style>

  </head>
  
  
  <body>
  	<c:forEach items="${listPhone }" var = "phone" >
  	
    <div class ="icon"  >

    	<a href="<c:url value= '/PhoneServlet?method=findByPid&pid=${phone.pid }'/>">
    	<img src="<c:url value='/${phone.image }'/>"  /> 
    	</a>
    	<br/>
    	<a href="<c:url value= '/PhoneServlet?method=findByPid&pid=${phone.pid }'/>">${phone.pname }</a>
    </div>
    </c:forEach> 
  </body>
</html>