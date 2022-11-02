package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.FoodCategory;

public interface IFoodCategoryDao extends JpaRepository<FoodCategory, Integer>
{

}
