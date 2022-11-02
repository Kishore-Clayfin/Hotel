package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.FoodCategory;
import com.cf.repository.IFoodCategoryDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class FoodCategoryServiceImpl implements IFoodCategoryService
{
	@Autowired
	private IFoodCategoryDao foodCategoryDao;

//	ADD
	/*******************************************************************************************************
	 - Function Name	:	addFoodCategory(FoodCategory foodCategory)
	 - Input Parameters	:	foodCategory
	 - Return Type		:	FoodCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddFoodCategory
	 ********************************************************************************************************/
	@Override
	public FoodCategory addFoodCategory(FoodCategory foodCategory) {
		FoodCategory f=foodCategoryDao.save(foodCategory);
		log.info("FoodCategory Added");
		return f;
	}

//	DELETE
	/*******************************************************************************************************
	 - Function Name	:	deleteFoodCategory(int id)
	 - Input Parameters	:	id
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteFoodCategory
	 ********************************************************************************************************/
	@Override
	public void deleteFoodCategory(int id) 
	{
		if (!foodCategoryDao.existsById(id))
		 {
			log.error("No Foodcategory found with id = " + id);
		      throw new ResourceNotFoundException("No Foodcategory found with id = " + id);
		 }
		foodCategoryDao.deleteById(id);
		log.info("FoodCategory Deleted");

	}
	
//	RETRIEVE
	/*******************************************************************************************************
	 - Function Name	:	retrieveFoodCategory()
	 - Input Parameters	:	
	 - Return Type		:	List<FoodCategory>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveFoodCategory
	 ********************************************************************************************************/
	@Override
	public List<FoodCategory> retrieveFoodCategory()
	{
		List<FoodCategory> list= foodCategoryDao.findAll();
		return list;
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveFoodCategoryById(int id)
	 - Input Parameters	:	id
	 - Return Type		:	FoodCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveFoodCategoryById
	 ********************************************************************************************************/
	@Override
	public FoodCategory retrieveFoodCategoryById(int id)
	{
		if (!foodCategoryDao.existsById(id))
		 {
			log.error("No Foodcategory found with id = " + id);
		      throw new ResourceNotFoundException("No Foodcategory found with id = " + id);
		 }
		FoodCategory foodCategory=foodCategoryDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Foodcategory  found with id = " + id));
		return foodCategory;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateFoodCategoryName(int id, FoodCategory foodCategory)
	 - Input Parameters	:	id,foodCategory
	 - Return Type		:	FoodCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateFoodCategoryName
	 ********************************************************************************************************/
	@Override
	public FoodCategory updateFoodCategoryName(int id, FoodCategory foodCategory)
	{
		if (!foodCategoryDao.existsById(id))
		 {
			log.error("No Foodcategory found with id = " + id);
		      throw new ResourceNotFoundException("No Foodcategory found with id = " + id);
		 }
		FoodCategory updateFoodcategory =foodCategoryDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Foodcategory  found with id = " + id));
		updateFoodcategory.setItemName(foodCategory.getItemName());
		FoodCategory f=foodCategoryDao.save(updateFoodcategory);
		log.info("FoodCategory Name Updated");
		return f;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateFoodCategoryPrice(int id, FoodCategory foodCategory)
	 - Input Parameters	:	id,foodCategory
	 - Return Type		:	FoodCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateFoodCategoryPrice
	 ********************************************************************************************************/
	@Override
	public FoodCategory updateFoodCategoryPrice(int id, FoodCategory foodCategory) 
	{
		if (!foodCategoryDao.existsById(id))
		 {
			log.error("No Foodcategory found with id = " + id);
		      throw new ResourceNotFoundException("No Foodcategory found with id = " + id);
		 }
		FoodCategory updateFoodcategory =foodCategoryDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Foodcategory  found with id = " + id));
		updateFoodcategory.setItemPrice(foodCategory.getItemPrice());
		FoodCategory f=	foodCategoryDao.save(updateFoodcategory);
		log.info("FoodCategory Price Updated");
		return f;

	}
	
	
}
