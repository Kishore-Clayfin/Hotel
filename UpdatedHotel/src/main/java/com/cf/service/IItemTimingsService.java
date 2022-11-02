package com.cf.service;


import java.util.List;

import com.cf.model.ItemTimings;

public interface IItemTimingsService 
{
	ItemTimings addItemTimings(ItemTimings itemTimings);
	void deleteItemTimings(int id);
	List<ItemTimings> retrieveItemTimings();
	ItemTimings retrieveItemTimingsById(int id);
	ItemTimings updateItemTimingsCategories(int id, ItemTimings itemTimings);

}
