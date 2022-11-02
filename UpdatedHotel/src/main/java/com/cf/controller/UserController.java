package com.cf.controller;

import java.util.List;

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

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.User;
import com.cf.service.UserServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/admin")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

//	ADD
	/*******************************************************************************************************
	- Function Name		: createUser(@Valid @RequestBody User userRequest)
	- Input Parameters	: userRequest
	- Return Type		: ResponseEntity<User>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addUser(userRequest);
	********************************************************************************************************/
	@PostMapping("/addUser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User userRequest) {
		System.out.println(userRequest);
		User u=userService.addUser(userRequest);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

//	RETRIEVE
	/*******************************************************************************************************
	- Function Name		: getAllUsers()
	- Input Parameters	: userRequest
	- Return Type		: ResponseEntity<List<User>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveUsers();
	********************************************************************************************************/
	@GetMapping("/findAllUser")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> user = userService.retrieveUsers();

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

//	 RETRIEVE BY ID
	/*******************************************************************************************************
	- Function Name		: getUserById(@PathVariable(value = "id") int id)
	- Input Parameters	: userRequest
	- Return Type		: ResponseEntity<User>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveUsersById(id);
	********************************************************************************************************/
	@GetMapping("/findUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int id) {
		User user = userService.retrieveUsersById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

//	 UPDATE
	/*******************************************************************************************************
	- Function Name		: updateComment(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody User userRequest)
	- Input Parameters	: id,update,userRequest
	- Return Type		: ResponseEntity<User>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method updateUserPassword(id, userRequest);updateUserRole(id, userRequest);updateUserEnabled(id, userRequest);updateUserUsername(id, userRequest);
	********************************************************************************************************/
	@PutMapping("/updateuser/{id}/{update}")
	public ResponseEntity<User> updateComment(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody User userRequest)
	{
		
		if(update.equalsIgnoreCase("UserPassword"))
		{
			User u=userService.updateUserPassword(id, userRequest);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("UserRole"))
		{
			User u=userService.updateUserRole(id, userRequest);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("UserEnabled"))
		{
			User u=userService.updateUserEnabled(id, userRequest);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("UserUsername"))
		{
			User u=userService.updateUserUsername(id, userRequest);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		else
		{
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");

		}
	}

//	 DELETE
	/*******************************************************************************************************
	- Function Name		: deleteUser(@PathVariable("id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteUser(id);
	********************************************************************************************************/
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
