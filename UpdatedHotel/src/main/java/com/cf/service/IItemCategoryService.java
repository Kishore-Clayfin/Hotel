package com.cf.service;

import java.util.List;

import com.cf.model.ItemCategory;

public interface IItemCategoryService 
{
	ItemCategory addItemCategory(ItemCategory itemCategory);
	void deleteItemCategory(int id);
	List<ItemCategory> retrieveItemCategory();
	ItemCategory retrieveItemCategoryById(int id);
	ItemCategory updateItemCategoryType(int id, ItemCategory itemCategory);
	ItemCategory updateItemCategoryName(int id, ItemCategory itemCategory);
}
