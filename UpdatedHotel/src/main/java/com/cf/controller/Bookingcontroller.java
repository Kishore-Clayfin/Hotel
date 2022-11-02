package com.cf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import com.cf.model.Booking;
import com.cf.service.BookingServiceImpl;
import com.google.zxing.WriterException;

import lombok.var;

@RequestMapping("/api/user")
@RestController

public class Bookingcontroller
{
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

		Booking book=bookingService.bookingHotel(bookRequest);
//		employeeRequest.setDepartment(employeeRequest.getDepartment());
		return new ResponseEntity<>(book, HttpStatus.CREATED);
		
	}

	
	 @RequestMapping(value = "/sid", method = RequestMethod.GET,
	            produces = MediaType.IMAGE_PNG_VALUE)
	    public ResponseEntity<byte[]> getImage() throws IOException {

	        var imgFile = new ClassPathResource("qrcodes/Phonepe.png");
	        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_PNG)
	                .body(bytes);
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
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
}
