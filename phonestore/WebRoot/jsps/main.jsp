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
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    <table class = "table" align="center" width = "80%" border="1">
    	<tr style="background: #4682B4;height :140px;">
	    	<td colspan="2" align="center" >
	    		<iframe frameborder="0" src ="<c:url value ='/jsps/top.jsp'/>" name="top" width="100%"></iframe>
	    		
	    	</td>
    	</tr>
    	 <tr style="height:700px;">
	    	<td width="120" style="padding: 5px;" align="center" valign="top">
	    		<iframe frameborder="0" src ="<c:url value ='/CategoryServlet?method=findAll'/>" name="left" ></iframe>
	    		
	    	</td>
	    	<td >
	    		<iframe frameborder="0" src ="<c:url value ='/jsps/body.jsp'/>" name="body" width="100%" height="700px"></iframe>
	    		
	    	</td>
    	</tr>
    </table>
  </body>
</html>
