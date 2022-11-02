package com.cf.service;

import java.util.List;

import com.cf.model.Department;

public interface IDepartmentService 
{
	Department addDepartment(Department department);
	void deleteDepartment(int id);
	Department updateDepartmentName(int id,Department department);
	List<Department> retrieveDepartment();
	Department retrieveDepartmentById(int id);
}
