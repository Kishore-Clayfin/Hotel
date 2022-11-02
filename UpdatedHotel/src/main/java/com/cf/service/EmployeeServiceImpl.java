package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Employee;
import com.cf.repository.IEmployeeDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class EmployeeServiceImpl implements IEmployeeService
{
	@Autowired
	private IEmployeeDao employeeDao;
	
	/*******************************************************************************************************
	 - Function Name	:	addEmployee(Employee employee)
	 - Input Parameters	:	employee 
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddEmployee
	 ********************************************************************************************************/
	@Override
	public Employee addEmployee(Employee employee)
	{
		Employee emp=employeeDao.save(employee); 
		log.info("Employee Added");
		return emp;
	}

	/*******************************************************************************************************
	 - Function Name	:	deleteEmployee(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteEmployee
	 ********************************************************************************************************/
	@Override
	public void deleteEmployee(int id) 
	{
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		employeeDao.deleteById(id);
		log.info("Employee deleted");
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveEmployee() 
	 - Input Parameters	:	
	 - Return Type		:	List<Employee>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveAllEmployee
	 ********************************************************************************************************/
	@Override
	public List<Employee> retrieveEmployee() 
	{
		List<Employee> list= employeeDao.findAll();
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveEmployeeByDept(String name)
	 - Input Parameters	:	name
	 - Return Type		:	List<Employee>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveEmployeeByDepartment
	 ********************************************************************************************************/
	public List<Employee> retrieveEmployeeByDept(String name) 
	{
		List<Employee> list= employeeDao.findByDepartmentName(name);
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateEmployeeSalary(int id, Employee employee)
	 - Input Parameters	:	id,employee
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateEmployeeSalary
	 ********************************************************************************************************/
	@Override
	public Employee updateEmployeeSalary(int id, Employee employee)
	{
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		Employee empl=employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Employee  found with id = " + id));
		empl.setSalary(employee.getSalary());
		Employee e=employeeDao.save(empl);
		 return e;
		
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveEmployeeById(int id)
	 - Input Parameters	:	id
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveEmployeeById
	 ********************************************************************************************************/
	@Override
	public Employee retrieveEmployeeById(int id)
	{
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		Employee employee=employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Employee  found with id = " + id));
		return employee;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateEmployeeMobileNo(int id, Employee employee)
	 - Input Parameters	:	id,employee
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateEmployeeMobileNumber
	 ********************************************************************************************************/
	@Override
	public Employee updateEmployeeMobileNo(int id, Employee employee)
	{
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		Employee empl=employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Employee  found with id = " + id));
		empl.setMobileNumber(employee.getMobileNumber());
		Employee e=employeeDao.save(empl);		
		log.info("Employee Mobile Number Updated");
		return e;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateEmployeeName(int id, Employee employee)
	 - Input Parameters	:	id,employee
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateEmployeeName
	 ********************************************************************************************************/
	@Override
	public Employee updateEmployeeName(int id, Employee employee) {
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		Employee empl=employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Employee  found with id = " + id));
		empl.setName(employee.getName());
		Employee e=employeeDao.save(empl);	
		log.info("Employee Name Updated");
		return e;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateEmployeeDepartment(int id, Employee employee)
	 - Input Parameters	:	id,employee
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateEmployeeDepartment
	 ********************************************************************************************************/
	@Override
	public Employee updateEmployeeDepartment(int id, Employee employee) {
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		Employee empl=employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Employee  found with id = " + id));
		empl.setDepartment(employee.getDepartment());
		Employee e=employeeDao.save(empl);	
		log.info("Employee Department Updated");
		return e;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateEmployeeEmail(int id, Employee employee)
	 - Input Parameters	:	id,employee
	 - Return Type		:	Employee
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateEmployeeEmail
	 ********************************************************************************************************/
	public Employee updateEmployeeEmail(int id, Employee employee) 
	{
		if (!employeeDao.existsById(id))
		 {
			  log.error("No Employee found with id = " + id);
		      throw new ResourceNotFoundException("No Employee found with id = " + id);
		 }
		Employee empl=employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Employee  found with id = " + id));
		empl.setEmail(employee.getEmail());
		Employee e=employeeDao.save(empl);	
		log.info("Employee Email Updated");
		return e;
	}
	
	
}
