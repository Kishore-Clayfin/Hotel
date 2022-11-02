package com.cf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.User;
import com.cf.repository.IUserDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class UserServiceImpl implements IUserService
{
	@Autowired
	private IUserDao userDao;

	/*******************************************************************************************************
	 - Function Name	:	addUser(User user)
	 - Input Parameters	:	user 
	 - Return Type		:	User
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddUser
	 ********************************************************************************************************/
	@Override
	public User addUser(User user)
	{
		User u= userDao.save(user);	
		 log.info("User Added");
		 return u;
	}

	/*******************************************************************************************************
	 - Function Name	:	deleteUser(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteUser
	 ********************************************************************************************************/
	@Override
	public void deleteUser(int id) 
	{
		if (!userDao.existsById(id))
		 {
			log.error("No User found with id = " + id);
		      throw new ResourceNotFoundException("No User found with id = " + id);
		 }
		userDao.deleteById(id);
		 log.info("User Deleted");

	}
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveUsers()
	 - Input Parameters	:	
	 - Return Type		:	List<User>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	retrieveAllUsers
	 ********************************************************************************************************/
	@Override
	public List<User> retrieveUsers() 
	{
		
		List<User> list= userDao.findAll();
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateUserPassword(int id, User user)
	 - Input Parameters	:	id,user
	 - Return Type		:	User
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateUserPassword
	 ********************************************************************************************************/
	@Override
	public User updateUserPassword(int id, User user) 
	{
		if (!userDao.existsById(id))
		 {
			log.error("No User found with id = " + id);
		      throw new ResourceNotFoundException("No User found with id = " + id);
		 }
		 User user1 = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User  found with id = " + id));
		 user1.setPassword(user.getPassword());
		 User u= userDao.save(user1);
		 log.info("User Password Updated");
		 return u;
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveUsersById(int id)
	 - Input Parameters	:	id
	 - Return Type		:	User
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveUsersById
	 ********************************************************************************************************/
	@Override
	public User retrieveUsersById(int id)
	{
		if (!userDao.existsById(id))
		 {
			log.error("No User found with id = " + id);
		      throw new ResourceNotFoundException("No User found with id = " + id);
		 }
		User user=userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User  found with id = " + id));
		return user;
		
	}

	/*******************************************************************************************************
	 - Function Name	:	updateUserRole(int id, User user)
	 - Input Parameters	:	id,user
	 - Return Type		:	User
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateUserRole
	 ********************************************************************************************************/
	@Override
	public User updateUserRole(int id, User user) {
		if (!userDao.existsById(id))
		 {
			log.error("No User found with id = " + id);
		      throw new ResourceNotFoundException("No User found with id = " + id);
		 }
		User user1 = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User  found with id = " + id));
		 user1.setRole(user.getRole());
		 User u=userDao.save(user1);
		 log.info("User Role Updated");
		 return u;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateUserUsername(int id, User user)
	 - Input Parameters	:	id,user
	 - Return Type		:	User
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateUserUsername
	 ********************************************************************************************************/
	@Override
	public User updateUserUsername(int id, User user) {
		if (!userDao.existsById(id))
		 {
			log.error("No User found with id = " + id);
		      throw new ResourceNotFoundException("No User found with id = " + id);
		 }
		User user1 = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User  found with id = " + id));
		 user1.setUsername(user.getUsername());
		 User u= userDao.save(user1);
		 log.info("User Username Updated");
		 return u;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateUserEnabled(int id, User user)
	 - Input Parameters	:	id,user
	 - Return Type		:	User
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateUserEnabled
	 ********************************************************************************************************/
	@Override
	public User updateUserEnabled(int id, User user) {
		if (!userDao.existsById(id))
		 {
			log.error("No User found with id = " + id);
		      throw new ResourceNotFoundException("No User found with id = " + id);
		 }
		User user1 = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User  found with id = " + id));
		 user1.setEnabled(user.getEnabled());
		 User u= userDao.save(user1);
		 log.info("User Enabled Updated");
		 return u;
	}
}
