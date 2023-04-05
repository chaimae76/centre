package com.example.demo.service;

import org.apache.catalina.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.user;
import com.example.demo.repository.userRepository;

@Service
public class userservice {
   @Autowired
   private userRepository repo;
   public user login(String username, String password) {
	   user user = repo.findByUsernameAndPassword(username,password);
	   return user;
   }
public void save(User user) {
	// TODO Auto-generated method stub
	
}

}
