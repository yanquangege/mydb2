package com.yanquange.phonestore.cate.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.yanquange.phonestore.cate.domain.Cart;
import com.yanquange.phonestore.cate.domain.CartItem;
import com.yanquange.phonestore.phone.domain.Phone;
import com.yanquange.phonestore.phone.service.PhoneService;

public class CartServlet extends BaseServlet {

	
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String pid = request.getParameter("pid");
		Phone phone = new PhoneService().findByPid(pid);
		Integer count = Integer.parseInt(request.getParameter("count"));
		

		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setPhone(phone);
		
		cart.add(cartItem);
		return "/jsps/cart/list.jsp";
	}
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "/jsps/cart/list.jsp";
		
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String pid = request.getParameter("pid");
		cart.delete(pid);
		return "/jsps/cart/list.jsp";
		
	}

}
