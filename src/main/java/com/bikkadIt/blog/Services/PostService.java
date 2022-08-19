package com.bikkadIt.blog.Services;

import java.util.List;

import com.bikkadIt.blog.Model.Post;
import com.bikkadIt.blog.Payloads.PostDto;
import com.bikkadIt.blog.Payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto creatPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost (Integer postId);
	
	//Get All POST
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//Get all post by category
	
	List <PostDto> getPostByCategory(Integer categoryId);
	
	//get all  postBy USER
	
	List <PostDto> getPostByUser(Integer userId);
	
	//Search post
	
	List <Post> searchPosts(String keyword);
	

}
