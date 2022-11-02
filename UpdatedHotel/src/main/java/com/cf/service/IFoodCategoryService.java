package com.cf.service;

import java.util.List;

import com.cf.model.FoodCategory;

public interface IFoodCategoryService
{
	FoodCategory addFoodCategory(FoodCategory foodCategory);
	 void deleteFoodCategory(int id);
	 List<FoodCategory> retrieveFoodCategory();
	 FoodCategory retrieveFoodCategoryById(int id);
	 FoodCategory updateFoodCategoryPrice(int id,FoodCategory foodCategory);
	 FoodCategory updateFoodCategoryName(int id,FoodCategory foodCategory);
}
