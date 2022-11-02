package com.cf.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.cf.ExcelExporter;
import com.cf.ExcelExporterFoodCategory;
import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.FoodCategory;
import com.cf.model.Hotel;
import com.cf.service.FoodCategoryServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/admin")
public class FoodCategoryController {

	@Autowired
	private FoodCategoryServiceImpl foodCategoryService;

//	ADD
	/*******************************************************************************************************
	- Function Name		:  createFoodCategory(@Valid @RequestBody FoodCategory foodCategoryRequest)
	- Input Parameters	:  foodCategoryRequest
	- Return Type		: ResponseEntity<FoodCategory>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addFoodCategory(foodCategoryRequest);
	********************************************************************************************************/
	@PostMapping("/addFoodCategory")
	public ResponseEntity<FoodCategory> createFoodCategory(@Valid @RequestBody FoodCategory foodCategoryRequest) {

		FoodCategory f=foodCategoryService.addFoodCategory(foodCategoryRequest);
		return new ResponseEntity<>(f, HttpStatus.CREATED);
	}

//	RETRIEVE
	/*******************************************************************************************************
	- Function Name		: createFoodCategory(@Valid @RequestBody FoodCategory foodCategoryRequest)
	- Input Parameters	: foodCategoryRequest
	- Return Type		: ResponseEntity<List<FoodCategory>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveFoodCategory();
	********************************************************************************************************/
	@GetMapping("/findAllFoodCategory")
	public ResponseEntity<List<FoodCategory>> getAllFoodCategory() {
		List<FoodCategory> foodCategory = foodCategoryService.retrieveFoodCategory();

		return new ResponseEntity<>(foodCategory, HttpStatus.OK);
	}

//	 RETRIEVE BY ID
	/*******************************************************************************************************
	- Function Name		: getFoodCategoryById(@PathVariable(value = "id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<FoodCategory>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveFoodCategoryById(id);
	********************************************************************************************************/
	@GetMapping("/findFoodCategory/{id}")
	public ResponseEntity<FoodCategory> getFoodCategoryById(@PathVariable(value = "id") int id) {
		FoodCategory food = foodCategoryService.retrieveFoodCategoryById(id);

		return new ResponseEntity<>(food, HttpStatus.OK);
	}

//	 UPDATE
	
	/*******************************************************************************************************
	- Function Name		: updateFoodCategory(@PathVariable("id") int id,@PathVariable("update") String update,@RequestBody FoodCategory foodCategoryRequest)
	- Input Parameters	: id,update,foodCategoryRequest
	- Return Type		: ResponseEntity<FoodCategory>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method updateFoodCategoryPrice(id, foodCategoryRequest);updateFoodCategoryName(id, foodCategoryRequest);
	********************************************************************************************************/
	@PutMapping("/updateFoodCategory/{id}/{update}")
	public ResponseEntity<FoodCategory> updateFoodCategory(@PathVariable("id") int id,@PathVariable("update") String update,@RequestBody FoodCategory foodCategoryRequest) 
	{
		 if(update.equalsIgnoreCase("FoodCategoryPrice"))
		 {
			 FoodCategory f=foodCategoryService.updateFoodCategoryPrice(id, foodCategoryRequest);
			 return new ResponseEntity<>(f,HttpStatus.OK);
		 }
		 else if(update.equalsIgnoreCase("FoodCategoryName"))
		 {
			 FoodCategory f= foodCategoryService.updateFoodCategoryName(id, foodCategoryRequest);
			 return new ResponseEntity<>(f,HttpStatus.OK);
		 }
		 else
		 {
				log.error("BAD CREDENTIALS");

			 throw new ResourceNotFoundException("BAD CREDENTIALS");

		 }
		 
	}

//	 DELETE
	/*******************************************************************************************************
	- Function Name		: deleteFoodCategory(@PathVariable("id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteFoodCategory(id);
	********************************************************************************************************/
	@DeleteMapping("/deleteFoodCategory/{id}")
	public ResponseEntity<HttpStatus> deleteFoodCategory(@PathVariable("id") int id) {
		foodCategoryService.deleteFoodCategory(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
//	EXCEL
	
//	EXCEL
	/*******************************************************************************************************
	- Function Name		: exportToExcel(@PathVariable("role") String role, HttpServletResponse response)
	- Input Parameters	: role 
	- Return Type		: void
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveFoodCategory();
	********************************************************************************************************/
	@GetMapping("/{role}/findAllFoodCategory/excel")
	public void exportToExcel(@PathVariable("role") String role, HttpServletResponse response) throws IOException {
		if (role.equalsIgnoreCase("user") || role.equalsIgnoreCase("admin"))
		{
			response.setContentType("application/octet-stream");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=FoodCategory_" + currentDateTime + ".xlsx";
			response.setHeader(headerKey, headerValue);

			List<FoodCategory> listUsers = foodCategoryService.retrieveFoodCategory();

			ExcelExporterFoodCategory excelExporter = new ExcelExporterFoodCategory(listUsers);

			excelExporter.export(response);
		} else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
}
