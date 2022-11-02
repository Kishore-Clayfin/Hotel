package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.ItemCategory;
import com.cf.repository.IItemCategoryDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class ItemCategoryServiceImpl implements IItemCategoryService
{
	@Autowired
	private IItemCategoryDao itemCategoryDao;
	
	/*******************************************************************************************************
	 - Function Name	:	addItemCategory(ItemCategory itemCategory)
	 - Input Parameters	:	itemCategory 
	 - Return Type		:	ItemCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddItemCategory
	 ********************************************************************************************************/
	@Override
	public ItemCategory addItemCategory(ItemCategory itemCategory) 
	{
		ItemCategory i=itemCategoryDao.save(itemCategory);
		log.info("ItemCategory Added");
		return i;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	deleteItemCategory(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteItemCategory
	 ********************************************************************************************************/
	@Override
	public void deleteItemCategory(int id)
	{
		if (!itemCategoryDao.existsById(id))
		 {
			 log.error("No itemCategory found with id = " + id);
		      throw new ResourceNotFoundException("No itemCategory found with id = " + id);
		 }
		itemCategoryDao.deleteById(id);
		log.info("ItemCategory Deleted");

	}
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveItemCategory()
	 - Input Parameters	:	
	 - Return Type		:	List<ItemCategory>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveAllItemCategory
	 ********************************************************************************************************/
	@Override
	public List<ItemCategory> retrieveItemCategory() {
		List<ItemCategory> list= itemCategoryDao.findAll();
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveItemCategoryById(int id) 
	 - Input Parameters	:	id
	 - Return Type		:	ItemCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveItemCategoryById
	 ********************************************************************************************************/
	@Override
	public ItemCategory retrieveItemCategoryById(int id) 
	{
		if (!itemCategoryDao.existsById(id))
		 {
			 log.error("No itemCategory found with id = " + id);
		      throw new ResourceNotFoundException("No itemCategory found with id = " + id);
		 }
		ItemCategory itemCategory=itemCategoryDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No itemCategory  found with id = " + id));
		return itemCategory;

	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateItemCategoryType(int id, ItemCategory itemCategory)
	 - Input Parameters	:	itemCategory
	 - Return Type		:	ItemCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateItemCategoryType
	 ********************************************************************************************************/
	@Override
	public ItemCategory updateItemCategoryType(int id, ItemCategory itemCategory)
	{
		if (!itemCategoryDao.existsById(id))
		 {
			 log.error("No itemCategory found with id = " + id);
		      throw new ResourceNotFoundException("No itemCategory found with id = " + id);
		 }
		ItemCategory itemcategory=itemCategoryDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Department  found with id = " + id));
		itemcategory.setCategoryType(itemCategory.getCategoryType());
		ItemCategory i=itemCategoryDao.save(itemcategory);	
		log.info("ItemCategory type updated");

		return i;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateItemCategoryName(int id, ItemCategory itemCategory)
	 - Input Parameters	:	itemCategory
	 - Return Type		:	ItemCategory
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateItemCategoryName
	 ********************************************************************************************************/
	@Override
	public ItemCategory updateItemCategoryName(int id, ItemCategory itemCategory) 
	{
		if (!itemCategoryDao.existsById(id))
		 {
			 log.error("No itemCategory found with id = " + id);
		      throw new ResourceNotFoundException("No itemCategory found with id = " + id);
		 }
		ItemCategory itemcategory=itemCategoryDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Department  found with id = " + id));
		itemcategory.setCategoryname(itemCategory.getCategoryname());
		ItemCategory i=itemCategoryDao.save(itemcategory);	
		log.info("ItemCategory Name updated");
		return i;
	}

}
