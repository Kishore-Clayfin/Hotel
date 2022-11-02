package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.ItemTimings;

public interface IItemTimingsDao extends JpaRepository<ItemTimings, Integer>
{ 

}
