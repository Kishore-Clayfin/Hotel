package com.cf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cf.model.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Integer>
{
	@Query(value = "select * from Employee inner join department on Employee.DEPARTMENT_DEPARTMENT_ID=department.DEPARTMENT_ID where department.DEPARTMENT_NAME =?",nativeQuery = true)
	List<Employee> findByDepartmentName(String name);
}
