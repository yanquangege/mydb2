package com.yanquange.phonestore.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.yanquange.phonestore.user.domain.User;

public class UserDao {

	private QueryRunner qr = new TxQueryRunner();

	public User findByUsername(String username) {

		try {
			String sql = "select * from t_user where username = ?";
			return qr.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findByEmail(String email) {

		try {
			String sql = "select * from t_user where email = ?";
			return qr.query(sql, new BeanHandler<User>(User.class), email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User findByCode(String code) {

		try {
			String sql = "select * from t_user where code = ?";
			return qr.query(sql, new BeanHandler<User>(User.class), code);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(User user) {

		try {
			String sql = "insert into t_user(uid,username,password,code,email,state) "
					+ "values (?,?,?,?,?,?)";
			Object[] params = { user.getUid(), user.getUsername(),
					user.getPassword(), user.getCode(), user.getEmail(),
					user.isState() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void active(User user){
		try {
			String sql = "update t_user set state = true where uid = ? ";
			qr.update(sql, user.getUid());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
