package com.yanquange.phonestore.order.service;

import java.sql.SQLException;

import cn.itcast.jdbc.JdbcUtils;

import com.yanquange.phonestore.order.dao.OrderDao;
import com.yanquange.phonestore.order.domain.Order;

public class OrderService {
	private OrderDao orderDao = new OrderDao();
	public void add(Order order){
		try {
			JdbcUtils.beginTransaction();
			orderDao.addOrder(order);
			orderDao.addOrderItem(order.getOrderItemList());
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {

			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e);
		}
	}
}
