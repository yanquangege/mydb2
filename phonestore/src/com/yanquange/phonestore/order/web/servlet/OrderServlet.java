package com.yanquange.phonestore.order.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.yanquange.phonestore.cate.domain.Cart;
import com.yanquange.phonestore.cate.domain.CartItem;
import com.yanquange.phonestore.order.domain.Order;
import com.yanquange.phonestore.order.domain.OrderItem;
import com.yanquange.phonestore.order.service.OrderService;
import com.yanquange.phonestore.user.domain.User;

public class OrderServlet extends BaseServlet {

	private OrderService orderService = new OrderService();
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Order order = new Order();
		
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setState(1);
		order.setTotal(cart.getTotal());
		
		User user = (User) request.getSession().getAttribute("session_user");
		order.setUser(user);
		
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(CartItem ci : cart.getCartItems()){
			OrderItem oi = new OrderItem();
			oi.setIid(CommonUtils.uuid());
			oi.setCount(ci.getCount());
			oi.setOrder(order);
			oi.setPhone(ci.getPhone());
			oi.setSubtotal(ci.getSubtatal());
			
			orderItemList.add(oi);
		}
		order.setOrderItemList(orderItemList);
		
		orderService.add(order);
		request.setAttribute("order", order);
		cart.clear();
		
		return "/jsps/order/desc.jsp";
	}

}
