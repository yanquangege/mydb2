package com.yanquange.phonestore.phone.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.yanquange.phonestore.phone.domain.Phone;
import com.yanquange.phonestore.phone.service.PhoneService;

public class PhoneServlet extends BaseServlet {

	private PhoneService phoneService = new PhoneService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Phone> listPhone = phoneService.findAll();
		request.setAttribute("listPhone", listPhone);
		return "/jsps/phone/list.jsp";


	}
	
	public String findByCid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		List<Phone> listPhone = phoneService.findByCid(cid);
		request.setAttribute("listPhone", listPhone);
		return "/jsps/phone/list.jsp";


	}
	
	public String findByPid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Phone phone = phoneService.findByPid(pid);
		request.setAttribute("phone", phone);
		return "/jsps/phone/desc.jsp";


	}
	
	

}
