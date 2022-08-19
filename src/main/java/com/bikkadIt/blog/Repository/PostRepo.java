package com.bikkadIt.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIt.blog.Model.Category;
import com.bikkadIt.blog.Model.Post;
import com.bikkadIt.blog.Model.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List <Post> findByUser (User user);
	
	List <Post> findByCategory(Category category);

}
