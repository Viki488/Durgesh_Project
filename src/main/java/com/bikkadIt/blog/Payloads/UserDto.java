package com.bikkadIt.blog.Payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id ;
	
	@NotEmpty
	@Size(min=4,message="Useename must be min of 4 characters !!")
	private String name;
	@Email (message ="Your email is not valid !!")
	private String email;
	@NotEmpty 
	@Size(min=3,max =10, message ="Password must be min of 3 and max of 10 char !!")
	private String password;
	@NotEmpty 
	private String about;

}
