package com.cf.service;

import java.util.List;

import com.cf.model.Employee;


public interface IEmployeeService
{
	Employee addEmployee(Employee employee);
	 void deleteEmployee(int id);
	 List<Employee> retrieveEmployee();
	 Employee retrieveEmployeeById(int id);
	 Employee updateEmployeeSalary(int id,Employee employee);
	 Employee updateEmployeeMobileNo(int id,Employee employee);
	 Employee updateEmployeeName(int id,Employee employee);
	 Employee updateEmployeeDepartment(int id,Employee employee);
}
