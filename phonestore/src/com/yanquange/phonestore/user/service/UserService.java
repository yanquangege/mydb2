package com.yanquange.phonestore.user.service;

import org.omg.CORBA.Request;

import com.yanquange.phonestore.user.dao.UserDao;
import com.yanquange.phonestore.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public void regist(User form) throws UserException{
		User user = userDao.findByUsername(form.getUsername());
		if (user != null ) throw new UserException("该用户名已经被注册");
		
		user = userDao.findByEmail(form.getEmail());
		if (user != null ) throw new UserException("该email已经被注册");
		
		userDao.add(form);
		
	}
	
	public void active(String code) throws UserException{
		User user = userDao.findByCode(code);
		if (user == null ) throw new UserException("激活码无效");
		
		if (user.isState()) throw new UserException("您已经激活，请不要重复操作");
		
		userDao.active(user);
		
	}
	
	public User login(User form) throws UserException{
		User user = userDao.findByUsername(form.getUsername());
		if (user == null ) throw new UserException("用户名不存在");
		
		if (!user.getPassword().equals(form.getPassword())) throw new UserException("密码错误"); 
		
		if (!user.isState()) throw new UserException("账户未激活");
		
		

		return user;
	}
}
