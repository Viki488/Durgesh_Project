package com.bikkadIt.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIt.blog.Model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
