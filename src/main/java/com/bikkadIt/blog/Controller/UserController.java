package com.bikkadIt.blog.Controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.blog.Payloads.ApiResponse;
import com.bikkadIt.blog.Payloads.UserDto;
import com.bikkadIt.blog.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService ; 
	
	//Post -CreatUser
	@PostMapping(value="/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto creatUserDto = this.userService.creatUser(userDto);
		
		return new ResponseEntity<>(creatUserDto,HttpStatus.CREATED);
	}
	//Put-UpdateUser
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody  UserDto userDto,@PathVariable Integer userId ){
		
		UserDto updatedUser = this.userService.updateUser(userDto,userId);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
		
		
	}
	
	//Delete -Delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
		
		}
	
	
	//Get-user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers (){
		
		return ResponseEntity.ok(this.userService.getAllUsers());
			
	}
	
	//Get-Particular user get
	@GetMapping("/{userId}")
	public ResponseEntity <UserDto> getSingleUser(@PathVariable Integer userId ){
		return ResponseEntity.ok(this.userService.getUserById(userId));
		
		
	}
}


