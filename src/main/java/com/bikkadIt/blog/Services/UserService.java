package com.bikkadIt.blog.Services;

import java.util.List;

import com.bikkadIt.blog.Payloads.UserDto;

public interface UserService {
	
	UserDto creatUser (UserDto userDto);
	UserDto updateUser (UserDto userDto,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

}
