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

import com.cf.model.Department;
import com.cf.service.DepartmentServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/admin")
public class DepartmentController
{

	@Autowired
	private DepartmentServiceImpl depatmentservice;

//	ADD
	/*******************************************************************************************************
	- Function Name		: createDepartment0(@Valid @RequestBody Department departmentRequest)
	- Input Parameters	: departmentRequest
	- Return Type		: ResponseEntity<Department>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addDepartment(departmentRequest);
	********************************************************************************************************/
	@PostMapping("/adddepartment")
	public ResponseEntity<Department> createDepartment0(@Valid @RequestBody Department departmentRequest)
	{
		
		Department department=depatmentservice.addDepartment(departmentRequest);
		return new ResponseEntity<>(department,HttpStatus.CREATED);
	}
	

//	 DELETE
	/*******************************************************************************************************
	- Function Name		: deleteDepartment(@PathVariable("id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteDepartment(id);
	********************************************************************************************************/
	 @DeleteMapping("/deletedepartment/{id}")
	  public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") int id)
	 {
		 depatmentservice.deleteDepartment(id);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	 
//	 RETRIEVE
	 /*******************************************************************************************************
		- Function Name		: getAllDepartments() 
		- Input Parameters	: 
		- Return Type		: ResponseEntity<List<Department>>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveDepartment();
		********************************************************************************************************/
	 @GetMapping("/findAllDepartment")
		public ResponseEntity<List<Department>> getAllDepartments() 
	 {
			List<Department> list = depatmentservice.retrieveDepartment();

			return new ResponseEntity<>(list, HttpStatus.OK);
		}

//			 RETRIEVE BY ID
	 	/*******************************************************************************************************
		- Function Name		: getDepartmentById(@PathVariable(value = "id") int id)
		- Input Parameters	: id
		- Return Type		: ResponseEntity<Department>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveDepartmentById(id);
		********************************************************************************************************/
		@GetMapping("/findDepartment/{id}")
		public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") int id) {
			Department dept = depatmentservice.retrieveDepartmentById(id);

			return new ResponseEntity<>(dept, HttpStatus.OK);
		}
//		UPDATE
		 @PutMapping("/updateDepartment/{id}")
		 /*******************************************************************************************************
			- Function Name		: updateDepartment(@PathVariable("id") int id, @RequestBody Department departmentRequest) 
			- Input Parameters	: id,departmentRequest
			- Return Type		: ResponseEntity<Department>
			- Throws    		: ResourceNotFoundException
			- Author     		: KISHOREKUMAR 
			- Description		: calls service method updateDepartmentName(id, departmentRequest);
			********************************************************************************************************/
		  public ResponseEntity<Department> updateDepartment(@PathVariable("id") int id, @RequestBody Department departmentRequest) 
		 {
			 Department deptartment= depatmentservice.updateDepartmentName(id, departmentRequest);

		    return new ResponseEntity<>(deptartment,HttpStatus.OK);
		  }
}
