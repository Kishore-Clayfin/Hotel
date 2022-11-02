package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.Department;

public interface IDepartmentDao extends JpaRepository<Department, Integer>
{

}
