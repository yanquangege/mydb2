package com.yanquange.phonestore.phone.service;

import java.util.List;

import com.yanquange.phonestore.phone.dao.PhoneDao;
import com.yanquange.phonestore.phone.domain.Phone;

public class PhoneService {
	private PhoneDao phoneDao = new PhoneDao();
	public List<Phone> findAll(){
		return phoneDao.findAll();
	}
	
	public List<Phone> findByCid(String cid){
		return phoneDao.findByCid(cid);
	}
	
	public Phone findByPid(String pid){
		return phoneDao.findByPid(pid);
	}

}
