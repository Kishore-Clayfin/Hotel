package com.cf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cf.model.ItemTimings;
import com.cf.service.ItemTimingsServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/admin")
public class ItemTimingsController 
{
	@Autowired
	private ItemTimingsServiceImpl itemTimingsService;

//	ADD
	/*******************************************************************************************************
	- Function Name		: createItemTimings(@Valid @RequestBody ItemTimings timingRequest)
	- Input Parameters	: timingRequest
	- Return Type		: ResponseEntity<ItemTimings>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addItemTimings(timingRequest);
	********************************************************************************************************/
	@PostMapping("/additemtimings")
	public ResponseEntity<ItemTimings> createItemTimings(@Valid @RequestBody ItemTimings timingRequest) {
		ItemTimings i=itemTimingsService.addItemTimings(timingRequest);
		return new ResponseEntity<>(i, HttpStatus.CREATED);
	}
	
//	DELETE
	/*******************************************************************************************************
	- Function Name		: deleteItemTimingst(@PathVariable("id") int id)
	- Input Parameters	: timingRequest
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteItemTimings(id);
	********************************************************************************************************/
	@DeleteMapping("/deleteItemTimings/{id}")
	  public ResponseEntity<HttpStatus> deleteItemTimingst(@PathVariable("id") int id)
	 {
		itemTimingsService.deleteItemTimings(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	
//	RETRIEVE
	/*******************************************************************************************************
	- Function Name		: getAllItemTimings() 
	- Input Parameters	: 
	- Return Type		: ResponseEntity<List<ItemTimings>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveItemTimings();
	********************************************************************************************************/
	 @GetMapping("/findAllItemTimings")
		public ResponseEntity<List<ItemTimings>> getAllItemTimings() 
	 {
			List<ItemTimings> list = itemTimingsService.retrieveItemTimings();

			return new ResponseEntity<>(list, HttpStatus.OK);
		}

//			 RETRIEVE BY ID
	 /*******************************************************************************************************
		- Function Name		: getItemTimingsById(@PathVariable(value = "id") int id)
		- Input Parameters	: id
		- Return Type		: ResponseEntity<ItemTimings>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveItemTimingsById(id);
		********************************************************************************************************/
		@GetMapping("/findItemTimings/{id}")
		public ResponseEntity<ItemTimings> getItemTimingsById(@PathVariable(value = "id") int id) {
			ItemTimings dept = itemTimingsService.retrieveItemTimingsById(id);

			return new ResponseEntity<>(dept, HttpStatus.OK);
		}
	
//	UPDATE
		 /*******************************************************************************************************
		- Function Name		: updateItemTimings(@PathVariable("id") int id, @RequestBody ItemTimings updateRequest)
		- Input Parameters	: id,updateRequest
		- Return Type		: ResponseEntity<ItemTimings>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method updateItemTimingsCategories(id, updateRequest);
		********************************************************************************************************/
		 @PutMapping("/updateItemTimings/{id}")
		  public ResponseEntity<ItemTimings> updateItemTimings(@PathVariable("id") int id, @RequestBody ItemTimings updateRequest) 
		 {
			 ItemTimings i=itemTimingsService.updateItemTimingsCategories(id, updateRequest);
		    return new ResponseEntity<>(i,HttpStatus.OK);
		  }
}
