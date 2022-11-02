package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.User;

public interface IUserDao extends JpaRepository<User,Integer>{

}
