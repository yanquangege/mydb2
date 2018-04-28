package com.yanquange.phonestore.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;

import com.yanquange.phonestore.order.domain.Order;
import com.yanquange.phonestore.order.domain.OrderItem;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();

	public void addOrder(Order order) {
		try {
			String sql = "insert into t_orders(oid,ordertime,total,state,uid,address)"
					+ "values (?,?,?,?,?,?)";
			Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
			Object[] params = { order.getOid(), timestamp, order.getTotal(),
					order.getState(), order.getUser().getUid(),
					order.getAddress() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void addOrderItem(List<OrderItem> orderItemList) {
		try {
			String sql = "insert into t_orderitem(iid,count,subtotal,oid,pid)"
					+ "values (?,?,?,?,?)";

			Object[][] params = new Object[orderItemList.size()][];

			for (int i = 0; i < orderItemList.size(); i++) {
				OrderItem oi = orderItemList.get(i);
				params[i] = new Object[] { oi.getIid(), oi.getCount(),
						oi.getSubtotal(), oi.getOrder().getOid(),
						oi.getPhone().getPid() };
			}
			qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
