package com.yanquange.phonestore.category.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.yanquange.phonestore.category.domain.Category;
import com.yanquange.phonestore.category.service.CategoryService;

public class CategoryServlet extends BaseServlet {

	CategoryService categoryService = new CategoryService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("categoryLIst", categoryList);
		return "/jsps/left.jsp";
	}

}
