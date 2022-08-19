package com.bikkadIt.blog.Payloads;

import java.util.Date;

import com.bikkadIt.blog.Model.Category;
import com.bikkadIt.blog.Model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	

	private CategoryDto category;
	
	
	private UserDto user;

}
