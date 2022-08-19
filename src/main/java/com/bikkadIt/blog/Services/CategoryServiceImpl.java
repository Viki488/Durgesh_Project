package com.bikkadIt.blog.Services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIt.blog.Exception.ResourceNotFoundException;
import com.bikkadIt.blog.Model.Category;
import com.bikkadIt.blog.Payloads.CategoryDto;
import com.bikkadIt.blog.Repository.CategoryRepo;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper ;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addCategory = this.categoryRepo.save(cat);
		return this.modelMapper.map(addCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
	Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category"," Category Id", categoryId));
		
	cat.setCategoryTitle(categoryDto.getCategoryTitle());
	cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category upadatecat = this.categoryRepo.save(cat);
		
	return this.modelMapper.map(upadatecat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category Id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}
	

}
