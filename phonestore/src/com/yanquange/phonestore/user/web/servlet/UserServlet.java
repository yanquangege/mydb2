package com.yanquange.phonestore.user.web.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;

import com.yanquange.phonestore.cate.domain.Cart;
import com.yanquange.phonestore.user.domain.User;
import com.yanquange.phonestore.user.service.UserException;
import com.yanquange.phonestore.user.service.UserService;

public class UserServlet extends BaseServlet {

	private UserService userService = new UserService();
	
	public String quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/index.jsp";
		
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(),User.class);
		
		String username = form.getUsername();
		
		Map<String,String> errors = new HashMap<String,String>();
		
		if (username == null || username.trim().isEmpty()){
			errors.put("username", "用户名不能为空");
		}else if (username.length() < 3 || username.length() > 10) {
			errors.put("username", "用户名称长度必须在3到10之间");
		}
		
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()){
			errors.put("password", "密码不能为空");
		}else if (password.length() < 3 || username.length() > 10) {
			errors.put("password", "密码长度必须在3到10之间");
		}
		
		if(errors.size() >0){
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "/jsps/user/login.jsp";
		}
		
		
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("session_user",user);	
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "/jsps/user/login.jsp";
		}
		
		Cart cart = new Cart();
		request.getSession().setAttribute("cart", cart);
		return "r:/index.jsp";
	}
	
	public String active(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		try {
			userService.active(code);
			request.setAttribute("msg","您已激活成功，请登录~！");	
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "/jsps/msg.jsp";
	}
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		form.setUid(CommonUtils.uuid());
		form.setCode(CommonUtils.uuid()+CommonUtils.uuid());
		//form.setState(false);
		
		Map<String,String> errors = new HashMap<String,String>();
		
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()){
			errors.put("username", "用户名不能为空");
		}else if (username.length() < 3 || username.length() > 10) {
			errors.put("username", "用户名称长度必须在3到10之间");
		}
		
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()){
			errors.put("password", "密码不能为空");
		}else if (password.length() < 3 || username.length() > 10) {
			errors.put("password", "密码长度必须在3到10之间");
		}
		
		String email = form.getEmail();
		if (email == null || email.trim().isEmpty()){
			errors.put("password", "Email不能为空");
		}else if (email.matches("\\w+@\\w\\.\\w")) {
			errors.put("password", "Email格式错误");
		}
		
		if(errors.size() >0){
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "/jsps/user/regist.jsp";
		}
		try {
			userService.regist(form);
				
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "/jsps/user/regist.jsp";
		}
		
		Properties props = new Properties();
		
		props.load(this.getClass().getClassLoader()
				.getResourceAsStream("email_template.properties"));
		
		String host =props.getProperty("host");
		String uname = props.getProperty("uname");
		String pwd = props.getProperty("pwd");
		String from = props.getProperty("from");
		String to = form.getEmail();
		String subject = props.getProperty("subject");
		String content = props.getProperty("content");
		System.out.println(content);
		content = MessageFormat.format(content, form.getCode());
		System.out.println(content);
		
		Session session = MailUtils.createSession(host, uname, pwd);
		Mail mail = new Mail(from,to,subject,content);
		try{
			MailUtils.send(session,mail);
		}catch(MessagingException e){
			throw new RuntimeException(e);
		}
		
		request.setAttribute("msg", "恭喜，注册成功，请前往邮箱验证");
		
		

		return "/jsps/msg.jsp";
	}

}
