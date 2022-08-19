package com.bikkadIt.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.blog.Payloads.ApiResponse;
import com.bikkadIt.blog.Payloads.PostDto;
import com.bikkadIt.blog.Payloads.PostResponse;
import com.bikkadIt.blog.Services.PostService;


@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		
		PostDto creatPost = this.postService.creatPost(postDto, userId, categoryId);
	
		
		return new ResponseEntity<PostDto>(creatPost,HttpStatus.CREATED);
		
		
	}
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser (@PathVariable Integer userId){
		
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
		
	}
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory (@PathVariable Integer categoryId){
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);	
		
	}
	
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value="pageNumber",defaultValue="1",required = false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="5",required = false)Integer pageSize){
		 PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
		
	}
	
	//get posts details by Id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
		
	}
	
	//delete post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deleteById (@PathVariable Integer postId){
		this.postService.deletePost(postId);
		return new ApiResponse("Post is Successfully deleted !!",true);
		
	}
	
	//update post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> upadatePost(@RequestBody PostDto postDto,@PathVariable Integer postId ){
		
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
		
	}
	
	

}
