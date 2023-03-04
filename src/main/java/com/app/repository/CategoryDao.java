package com.app.repository;

import java.util.List;

import com.app.entities.Category;

public interface CategoryDao {
//add a method to fetch all categories
	List<Category> getAllCategories();
}
