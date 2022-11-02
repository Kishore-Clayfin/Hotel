package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.ItemTimings;
import com.cf.repository.IItemTimingsDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class ItemTimingsServiceImpl implements IItemTimingsService
{
	@Autowired
	private IItemTimingsDao itemTimingsDao;

	/*******************************************************************************************************
	 - Function Name	:	addItemTimings(ItemTimings itemTimings)
	 - Input Parameters	:	itemTimings 
	 - Return Type		:	ItemTimings
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddItemTimings
	 ********************************************************************************************************/
	@Override
	public ItemTimings addItemTimings(ItemTimings itemTimings)
	{
		ItemTimings i=itemTimingsDao.save(itemTimings);
		log.info("ItemTimings Added");
		return i;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	deleteItemTimings(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteItemTimingsById
	 ********************************************************************************************************/
	@Override
	public void deleteItemTimings(int id)
	{
		if (!itemTimingsDao.existsById(id))
		 {
			 log.error("No itemTimings found with id = " + id);
		      throw new ResourceNotFoundException("No itemTimings found with id = " + id);
		 }
		itemTimingsDao.deleteById(id);	
		log.info("ItemTimings Deleted");

	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveItemTimings() 
	 - Input Parameters	:	 
	 - Return Type		:	List<ItemTimings>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveItemTimings
	 ********************************************************************************************************/
	@Override
	public List<ItemTimings> retrieveItemTimings() 
	{
		List<ItemTimings> list= itemTimingsDao.findAll();
		return list;
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveItemTimingsById(int id)
	 - Input Parameters	:	id
	 - Return Type		:	ItemTimings
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RretrieveItemTimingsById
	 ********************************************************************************************************/
	@Override
	public ItemTimings retrieveItemTimingsById(int id) 
	{
		if (!itemTimingsDao.existsById(id))
		 {
			 log.error("No itemTimings found with id = " + id);
		      throw new ResourceNotFoundException("No itemTimings found with id = " + id);
		 }
		ItemTimings itemtimings=itemTimingsDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No itemTimings  found with id = " + id));
		return itemtimings;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateItemTimingsCategories(int id, ItemTimings itemTimings)
	 - Input Parameters	:	id,itemTimings
	 - Return Type		:	ItemTimings
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateItemTimingsCategories
	 ********************************************************************************************************/
	@Override
	public ItemTimings updateItemTimingsCategories(int id, ItemTimings itemTimings)
	{
		if (!itemTimingsDao.existsById(id))
		 {
			 log.error("No itemTimings found with id = " + id);
		      throw new ResourceNotFoundException("No itemTimings found with id = " + id);
		 }
		ItemTimings itemtimings=itemTimingsDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Department  found with id = " + id));
		itemtimings.setCategories(itemTimings.getCategories());
		ItemTimings i=itemTimingsDao.save(itemtimings);		
		log.info("ItemTimings Categories Updated");
		return i;
	}
	
	
}
