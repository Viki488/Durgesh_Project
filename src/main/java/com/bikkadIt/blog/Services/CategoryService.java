package com.bikkadIt.blog.Services;

import java.util.List;

import com.bikkadIt.blog.Payloads.CategoryDto;

public interface CategoryService {
	
	//Create 
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update
	
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	public  void deleteCategory(Integer categoryId);
	
	//get
	
	public CategoryDto getCategory(Integer categoryId);
	//getAll
	
	public List <CategoryDto > getCategories ();

	
}
