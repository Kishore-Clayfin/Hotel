package com.cf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import com.cf.model.Booking;
import com.cf.repository.IBookingDao;
import com.cf.service.BookingServiceImpl;
import com.google.zxing.WriterException;

import lombok.var;

@RequestMapping("/api/user")
@RestController

public class Bookingcontroller
{
	@Autowired
	private IBookingDao book;
	@Autowired
	private BookingServiceImpl bookingService;
	
	
	
	/*******************************************************************************************************
	- Function Name		:  createHotel(@Validated @RequestBody Booking bookRequest)
	- Input Parameters	:  bookRequest
	- Return Type		: ResponseEntity<Booking>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method bookingHotel(bookRequest);
	 * @throws IOException 
	 * @throws WriterException 
	********************************************************************************************************/
	@PostMapping("/booking")
	public ResponseEntity<Booking> booking(@Validated @RequestBody Booking bookRequest) throws WriterException, IOException {
System.out.println(bookRequest.getHotel().getRooms());
		Booking book=bookingService.bookingHotel(bookRequest);
//		employeeRequest.setDepartment(employeeRequest.getDepartment());
		return new ResponseEntity<>(book, HttpStatus.CREATED);
		
	}

	
	@GetMapping("/bookingList")
	public ResponseEntity<List<Booking>> retrieveAll()
	{
		List<Booking> list= book.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	
	//	DELETE ALL
	
	/*******************************************************************************************************
	- Function Name		: DeleteAllHotel()
	- Input Parameters	: 
	- Return Type		: ResponseEntity<Booking>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method bookingHotel(bookRequest);
	********************************************************************************************************/
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Booking> DeleteAllHotel() 
	{

		bookingService.DeleteAllBooking();
//		employeeRequest.setDepartment(employeeRequest.getDepartment());
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
