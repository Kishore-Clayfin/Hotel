package com.cf.service;

import java.util.List;

import com.cf.model.User;

public interface IUserService 
{
	User addUser(User user);
	 void deleteUser(int id);
	 List<User> retrieveUsers();
	 User retrieveUsersById(int id);
	 User updateUserPassword(int id,User user);
	 User updateUserRole(int id,User user);
	 User updateUserUsername(int id,User user);
	 User updateUserEnabled(int id,User user);
}
