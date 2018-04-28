package com.yanquange.phonestore.category.service;

import java.util.List;

import com.yanquange.phonestore.category.dao.CategoryDao;
import com.yanquange.phonestore.category.domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

}
