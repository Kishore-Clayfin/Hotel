package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Department;
import com.cf.repository.IDepartmentDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service

public class DepartmentServiceImpl implements IDepartmentService
{
	@Autowired
	private IDepartmentDao depatmentDao;
	
	/*******************************************************************************************************
	 - Function Name	:	addDepartment(Department department)
	 - Input Parameters	:	department 
	 - Return Type		:	Department
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddDepartment
	 ********************************************************************************************************/
	
	@Override
	public Department addDepartment(Department department)
	{
		
		Department d=depatmentDao.save(department);
		log.info("Department Added");
		return d;
		
	}

	/*******************************************************************************************************
	 - Function Name	:	deleteDepartment(int id)
	 - Input Parameters	:	id
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteDepartment
	 ********************************************************************************************************/
	@Override
	public void deleteDepartment(int id)
	{
		if (!depatmentDao.existsById(id))
		 {
			  log.error("No Department found with id = " + id);
		      throw new ResourceNotFoundException("No Department found with id = " + id);
		 }
		depatmentDao.deleteById(id);
		log.info("Department Deleted");
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	updateDepartmentName(int id, Department department)
	 - Input Parameters	:	id,department
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateDepartment
	 ********************************************************************************************************/
	@Override
	public Department updateDepartmentName(int id, Department department) 
	{
		if (!depatmentDao.existsById(id))
		 {
			  log.error("No Department found with id = " + id);
		      throw new ResourceNotFoundException("No Department found with id = " + id);
		 }
		Department departments=depatmentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Department  found with id = " + id));
		departments.setDepartmentName(department.getDepartmentName());;
		Department d =depatmentDao.save(departments);
		log.info("Department Name Updated");
		return d;
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveDepartment() 
	 - Input Parameters	:	
	 - Return Type		:	List<Department>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveAllDepartment
	 ********************************************************************************************************/
	@Override
	public List<Department> retrieveDepartment() 
	{
		List<Department> list= depatmentDao.findAll();
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveDepartmentById(int id) 
	 - Input Parameters	:	id
	 - Return Type		:	Department
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveDepartmentById
	 ********************************************************************************************************/
	@Override
	public Department retrieveDepartmentById(int id)
	{
		if (!depatmentDao.existsById(id))
		 {
			  log.error("No Department found with id = " + id);
		      throw new ResourceNotFoundException("No Department found with id = " + id);
		 }
		Department departments=depatmentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Department  found with id = " + id));
		return departments;
	}
	 
}
