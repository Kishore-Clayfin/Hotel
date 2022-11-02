package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.ItemCategory;

public interface IItemCategoryDao extends JpaRepository<ItemCategory, Integer>
{

}
