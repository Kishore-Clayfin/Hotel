package com.cf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Employee;
import com.cf.service.EmployeeServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;

//	ADD
	/*******************************************************************************************************
	- Function Name		: createEmployee(@Valid @RequestBody Employee employeeRequest)
	- Input Parameters	: employeeRequest
	- Return Type		: ResponseEntity<Employee>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addEmployee(employeeRequest);
	********************************************************************************************************/
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employeeRequest) {

		Employee e=employeeService.addEmployee(employeeRequest);
//		employeeRequest.setDepartment(employeeRequest.getDepartment());
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}

//	RETRIEVE
	/*******************************************************************************************************
	- Function Name		: getAllEmployees()
	- Input Parameters	: 
	- Return Type		: ResponseEntity<List<Employee>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveEmployee();
	********************************************************************************************************/
	@GetMapping("/findAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employee = employeeService.retrieveEmployee();

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
//	RETRIEVE BY DEPARTMENT
	/*******************************************************************************************************
	- Function Name		: getEmployeesDept(@PathVariable (value ="name") String name) 
	- Input Parameters	: name
	- Return Type		: ResponseEntity<List<Employee>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveEmployeeByDept(name);
	********************************************************************************************************/
	@GetMapping("/findEmployeesByDept/{name}")
	public ResponseEntity<List<Employee>> getEmployeesDept(@PathVariable (value ="name") String name) 
	{
		List<Employee> employee = employeeService.retrieveEmployeeByDept(name);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
//	 RETRIEVE BY ID
	/*******************************************************************************************************
	- Function Name		: getItemEmployeeById(@PathVariable(value = "id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<Employee>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveEmployeeById(id);
	********************************************************************************************************/
	@GetMapping("/findEmployee/{id}")
	public ResponseEntity<Employee> getItemEmployeeById(@PathVariable(value = "id") int id) {
		Employee employee = employeeService.retrieveEmployeeById(id);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

//	 DELETE
	/*******************************************************************************************************
	- Function Name		: deleteEmployee(@PathVariable("id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteEmployee(id);
	********************************************************************************************************/
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	 UPDATE
	/*******************************************************************************************************
	- Function Name		: updateEmployee(@Validated @PathVariable("id") int id,@PathVariable("update") String update, @RequestBody Employee employeeRequest)
	- Input Parameters	: id,update,employeeRequest
	- Return Type		: ResponseEntity<Employee>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method updateEmployeeSalary(id, employeeRequest);updateEmployeeMobileNo(id, employeeRequest);
							updateEmployeeName(id, employeeRequest);updateEmployeeDepartment(id, employeeRequest);
							
	********************************************************************************************************/
	@PutMapping("/updateEmployee/{id}/{update}")
	public ResponseEntity<Employee> updateEmployee(@Validated @PathVariable("id") int id,@PathVariable("update") String update, @RequestBody Employee employeeRequest) {
		
		 if(update.equalsIgnoreCase("EmployeeSalary"))
		 {
			 Employee e= employeeService.updateEmployeeSalary(id, employeeRequest);
			 return new ResponseEntity<>(e,HttpStatus.OK);
		 }
		 else if(update.equalsIgnoreCase("EmployeeMobileNo"))
		 {
			 Employee e=employeeService.updateEmployeeMobileNo(id, employeeRequest);
			 return new ResponseEntity<>(e,HttpStatus.OK);
		 
		 }
		 else if(update.equalsIgnoreCase("EmployeeName"))
		 {
			 Employee e=employeeService.updateEmployeeName(id, employeeRequest);
			 return new ResponseEntity<>(e,HttpStatus.OK);
		 
		 }
		 else if(update.equalsIgnoreCase("EmployeeDepartment"))
		 {
			 Employee e= employeeService.updateEmployeeDepartment(id, employeeRequest);
			 return new ResponseEntity<>(e,HttpStatus.OK);
		 
		 }
		 else
		 {
				log.error("BAD CREDENTIALS");

			 throw new ResourceNotFoundException("BAD CREDENTIALS");

		 }
	}
	
	/*******************************************************************************************************
	- Function Name		: updateEmployeeEmail(@Validated @RequestParam(value = "id") int id, @RequestBody Employee employeeRequest) 
	- Input Parameters	: id,employeeRequest
	- Return Type		: ResponseEntity<Employee>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method updateEmployeeEmail(id, employeeRequest);
	********************************************************************************************************/
	@PutMapping("/updateEmployee/Email")
	public ResponseEntity<Employee> updateEmployeeEmail(@Validated @RequestParam(value = "id") int id, @RequestBody Employee employeeRequest) 
	{
		Employee e= employeeService.updateEmployeeEmail(id, employeeRequest);
		 return new ResponseEntity<>(e,HttpStatus.OK);
	}
		

}
