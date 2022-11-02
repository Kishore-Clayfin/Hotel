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

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.ItemCategory;
import com.cf.service.ItemCategoryServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/admin")
public class ItemCategoryController {

	@Autowired
	private ItemCategoryServiceImpl itemCategoryService;

//	ADD
	/*******************************************************************************************************
	- Function Name		: createItemCategory(@Valid @RequestBody ItemCategory categoryRequest)
	- Input Parameters	: categoryRequest
	- Return Type		: ResponseEntity<ItemCategory>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addItemCategory(categoryRequest);
	********************************************************************************************************/
	@PostMapping("/additemcategory")
	public ResponseEntity<ItemCategory> createItemCategory(@Valid @RequestBody ItemCategory categoryRequest) {
		ItemCategory i=itemCategoryService.addItemCategory(categoryRequest);
		return new ResponseEntity<>(i, HttpStatus.CREATED);
	}
	
//	 DELETE
	
	/*******************************************************************************************************
	- Function Name		: deleteItemCategory(@PathVariable("id") int id)
	- Input Parameters	: categoryRequest
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteItemCategory(id);
	********************************************************************************************************/
	 @DeleteMapping("/deleteItemCategory/{id}")
	  public ResponseEntity<HttpStatus> deleteItemCategory(@PathVariable("id") int id)
	 {
		 itemCategoryService.deleteItemCategory(id);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	
//	RETRIEVE
	 /*******************************************************************************************************
		- Function Name		: getAllItemCategorys() 
		- Input Parameters	: categoryRequest
		- Return Type		: ResponseEntity<List<ItemCategory>>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveItemCategory();
		********************************************************************************************************/
	 @GetMapping("/findAllItemCategory")
		public ResponseEntity<List<ItemCategory>> getAllItemCategorys() 
	 {
			List<ItemCategory> list = itemCategoryService.retrieveItemCategory();

			return new ResponseEntity<>(list, HttpStatus.OK);
		}

//			 RETRIEVE BY ID
	 	/*******************************************************************************************************
		- Function Name		: getItemCategoryById(@PathVariable(value = "id") int id)
		- Input Parameters	: categoryRequest
		- Return Type		: ResponseEntity<ItemCategory>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveItemCategoryById(id);
		********************************************************************************************************/
		@GetMapping("/findItemCategory/{id}")
		public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable(value = "id") int id) {
			ItemCategory dept = itemCategoryService.retrieveItemCategoryById(id);

			return new ResponseEntity<>(dept, HttpStatus.OK);
		}
//		UPDATE
		/*******************************************************************************************************
		- Function Name		: updateItemCategory(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody ItemCategory categoryRequest)
		- Input Parameters	: id,update,categoryRequest
		- Return Type		: ResponseEntity<ItemCategory>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method updateItemCategoryName(id, categoryRequest);updateItemCategoryType(id, categoryRequest);
		********************************************************************************************************/
		 @PutMapping("/updateItemCategory/{id}/{update}")
		  public ResponseEntity<ItemCategory> updateItemCategory(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody ItemCategory categoryRequest) 
		 {
			 if(update.equalsIgnoreCase("ItemCategoryName"))
			 {
				 ItemCategory i= itemCategoryService.updateItemCategoryName(id, categoryRequest);
				 return new ResponseEntity<>(i,HttpStatus.OK);
			 }
			 else if(update.equalsIgnoreCase("ItemCategoryType"))
			 {
				 ItemCategory i= itemCategoryService.updateItemCategoryType(id, categoryRequest);
				 return new ResponseEntity<>(i,HttpStatus.OK);
			 }
			 else
			 {
					log.error("BAD CREDENTIALS");

				 throw new ResourceNotFoundException("BAD CREDENTIALS");
			 }
//			 return new ResponseEntity<>(HttpStatus.OK);
		  }
}
