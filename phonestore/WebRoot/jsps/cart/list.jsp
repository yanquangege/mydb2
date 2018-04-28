<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	*{
		font-size: 11pt;
	}
	div{
		margin: 20px;
		border: solid 1px gray;
		width : 200px;
		height : 200px;
		text-align: center;
	}
	img{
		width : 200;
		height : 200;
	}
	li{
		margin: 10px;
	}
	</style>

  </head>
  
  <body>
    <h1>购物车</h1>
    
    <c:choose>
    	<c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0 }">
    		<h2>您还没有选购商品</h2>
    	</c:when>
    	<c:otherwise>
    	
    	
    <table border="1" width="100%" cellspacing="0" background="black">
    	<tr>
    		<td colspan="7" align="right" style="font-size: 15pt;font-weight: 900">
    			<a href="<c:url value='/CartServlet?method=clear'/>">清空购物车</a>
    		</td>
    	</tr>
    	<tr>
    		<th>图片</th>
    		<th>产品名</th>
    		<th>厂家</th>
    		<th>单价</th>
    		<th>数量</th>
    		<th>小计</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${sessionScope.cart.cartItems }" var = "cartItem">
	    	<tr>
	    		<td>
	    			<div>
	    				<img  src="<c:url value = '/${cartItem.phone.image }'/>"/>
	    			</div>
	    		</td>
	    		<td>${cartItem.phone.pname }</td>
	    		<td>${cartItem.phone.producer }</td>
	    		<td>${cartItem.phone.price }</td>
	    		<td>${cartItem.count }</td>
	    		<td>${cartItem.subtatal }</td>
	    		<td><a href="<c:url value='/CartServlet?method=delete&pid=${cartItem.phone.pid }'/>">删除</a> </td>
	    	</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="7" align="right" style="font-size: 15pt;font-weight: 900;">
    			合计：${cart.total }元
    		</td>
    	</tr>
    	<tr>
    		<td colspan="7" align="right" style="font-size: 15pt;font-weight: 900;">
    			<a href = "<c:url value='/OrderServlet?method=add'/>">购买</a>
    		</td>
    	</tr>
    </table>
    </c:otherwise>
    </c:choose>
  </body>
</html>
