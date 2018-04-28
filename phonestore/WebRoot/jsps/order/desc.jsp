<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付页</title>
    
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
			height : 200px;
			text-align: center;
			float: left;
			border:1px solid gray;
			margin:20px 30px;
			
		}
		img{width: 200;height: 200}
		li{text-align: left;}
	</style>
  </head>

  </head>
  
  <body>
  <h1>当前订单</h1>
  <table border="1" width = "100%" cellspacing="0" background="black">
  	<tr bgcolor="gray" bordercolor="gray">
  		<td colspan="6">
  			订单编号：${order.oid } 
  			成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.ordertime }" /> 金额：<font color="red"><b>${order.total }</b></font>
  		</td>
  	</tr>
  	<c:forEach items="${order.orderItemList }" var = "orderItem">

	  	<tr bordercolor="gray" align="center">
	  		<td width = "15%">
	  			<div>
	  				<img  src="<c:url value = "/${orderItem.phone.image }"/>"/>
	  			</div>
	  		</td>
	  		<td>产品名：${orderItem.phone.pname}</td>
	  		<td>单价：${orderItem.phone.price}</td>
	  		<td>厂家：${orderItem.phone.producer}</td>
	  		<td>数量：${orderItem.count}</td>
	  		<td>小计：${orderItem.subtotal}</td>
	  	</tr>

  	</c:forEach>
  
  </table>
  
  <form method="post" action="" id = "form" target="body">
  收货地址：<input type="text" name ="address" size ="50" value = "长沙市开福区雄新华府2栋605"/><br/>
  
  <input type="submit" value = "付款"/>
  选择银行<br/>
  
  </form>
  </body>
</html>
