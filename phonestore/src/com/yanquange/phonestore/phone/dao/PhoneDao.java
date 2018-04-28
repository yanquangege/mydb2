package com.yanquange.phonestore.phone.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.yanquange.phonestore.phone.domain.Phone;

public class PhoneDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Phone> findAll(){
		String sql ="select * from t_phone";
		try {
			return qr.query(sql, new BeanListHandler<Phone>(Phone.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Phone> findByCid(String cid){
		String sql ="select * from t_phone where cid = ?";
		try {
			return qr.query(sql, new BeanListHandler<Phone>(Phone.class),cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Phone findByPid(String pid){
		String sql ="select * from t_phone where pid = ?";
		try {
			return qr.query(sql, new BeanHandler<Phone>(Phone.class),pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
