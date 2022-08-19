package com.bikkadIt.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIt.blog.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	

}
