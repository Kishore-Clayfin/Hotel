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
import org.springframework.web.servlet.ModelAndView;

import com.cf.ExcelExporter;
import com.cf.PdfGenereator;
import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Hotel;
import com.cf.service.HotelServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api")
public class HotelController {
	@Autowired
	private HotelServiceImpl hotelservice;
	
//	ADD
	/*******************************************************************************************************
	- Function Name		: createHotel(@Valid @RequestBody Hotel hotelRequest)
	- Input Parameters	: hotelRequest
	- Return Type		: ResponseEntity<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addHotel(hotelRequest);
	********************************************************************************************************/
	@PostMapping("/admin/addHotel")
	public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotelRequest) {

		Hotel h=hotelservice.addHotel(hotelRequest);
//		employeeRequest.setDepartment(employeeRequest.getDepartment());
		return new ResponseEntity<>(h, HttpStatus.CREATED);
	}



//	 DELETE
	/*******************************************************************************************************
	- Function Name		: deleteHotel(@PathVariable("id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteHotel(id);
	********************************************************************************************************/
	@DeleteMapping("/admin/deleteHotel/{id}")
	public ResponseEntity<HttpStatus> deleteHotel(@PathVariable("id") int id) {
		hotelservice.deleteHotel(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	ADMIN
//		RETRIEVE ALL
	/*******************************************************************************************************
	- Function Name		: getAllHotels()
	- Input Parameters	: hotelRequest
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveHotel();
	********************************************************************************************************/
	@GetMapping("/admin/findAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotel = hotelservice.retrieveHotel();

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

//		 RETRIEVE BY ID
	/*******************************************************************************************************
	- Function Name		: getHotelByHotelId(@PathVariable(value = "id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByID(id);
	********************************************************************************************************/
	@GetMapping("/admin/findHotelById/{id}")
	public ResponseEntity<Hotel> getHotelByHotelId(@PathVariable(value = "id") int id) {
		Hotel hotel = hotelservice.findByID(id);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	 RETRIEVE BY NAME
	/*******************************************************************************************************
	- Function Name		: getHotelByHotelName(@PathVariable(value = "name") String name)
	- Input Parameters	: name
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelName(name)
	********************************************************************************************************/
	@GetMapping("/admin/findHotelByName/{name}")
	public ResponseEntity<List<Hotel>> getHotelByHotelName(@PathVariable(value = "name") String name) {
		List<Hotel> hotel = hotelservice.findByHotelName(name);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	 RETRIEVE BY AREA
	/*******************************************************************************************************
	- Function Name		: getHotelByArea(@PathVariable(value = "area") String area)
	- Input Parameters	: area
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelByArea(area);
	********************************************************************************************************/
	@GetMapping("/admin/findHotelByArea/{area}")
	public ResponseEntity<List<Hotel>> getHotelByArea(@PathVariable(value = "area") String area) {
		List<Hotel> hotel = hotelservice.findByHotelByArea(area);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	 RETRIEVE BY CITY
	/*******************************************************************************************************
	- Function Name		: getHotelByCity(@PathVariable(value = "city") String city) 
	- Input Parameters	: city
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelByCity(city);
	********************************************************************************************************/
	@GetMapping("/admin/findHotelByCity/{city}")
	public ResponseEntity<List<Hotel>> getHotelByCity(@PathVariable(value = "city") String city) 
	{
		List<Hotel> hotel = hotelservice.findByHotelByCity(city);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	USER
//	RETRIEVE BY EXACT LOCATION
	/*******************************************************************************************************
	- Function Name		: getHotelsByLoc(@PathVariable(value = "state") String state,@PathVariable(value = "city") String city,@PathVariable(value = "area") String area) 
	- Input Parameters	: state,city,area
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveHotelByLoc(state, city, area);
	********************************************************************************************************/
	@GetMapping("/user/findHotel/{state}/{city}/{area}")
	public ResponseEntity<List<Hotel>> getHotelsByLoc(@PathVariable(value = "state") String state,@PathVariable(value = "city") String city,@PathVariable(value = "area") String area) 
	{
		
		List<Hotel> hotel = hotelservice.retrieveHotelByLoc(state, city, area);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}


//	RETRIEVE ALL
	/*******************************************************************************************************
	- Function Name		: getAllHotelsForUsers()
	- Input Parameters	: hotelRequest
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveHotel();
	********************************************************************************************************/
	@GetMapping("/user/findAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotelsForUsers()
	{
		List<Hotel> hotel = hotelservice.retrieveHotel();

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	RETRIEVE BY NAME
	/*******************************************************************************************************
	- Function Name		: getHotelByHotelNameForUsers(@PathVariable(value = "name") String name)
	- Input Parameters	: name
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelName(name)
	********************************************************************************************************/
	@GetMapping("/user/findHotelByName/{name}")
	public ResponseEntity<List<Hotel>> getHotelByHotelNameForUsers(@PathVariable(value = "name") String name) {
		List<Hotel> hotel = hotelservice.findByHotelName(name);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	RETRIEVE BY AREA
	/*******************************************************************************************************
	- Function Name		: getHotelByAreaForUsers(@PathVariable(value = "area") String area)
	- Input Parameters	: area
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelByArea(area);
	********************************************************************************************************/
	@GetMapping("/user/findHotelByArea/{area}")
	public ResponseEntity<List<Hotel>> getHotelByAreaForUsers(@PathVariable(value = "area") String area) {
		List<Hotel> hotel = hotelservice.findByHotelByArea(area);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
//	 RETRIEVE BY CITY
	/*******************************************************************************************************
	- Function Name		: getHotelByCityForUser(@PathVariable(value = "city") String city) 
	- Input Parameters	: city
	- Return Type		: ResponseEntity<List<Hotel>>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelByCity(city);
	********************************************************************************************************/
	@GetMapping("/user/findHotelByCity/{city}")
	public ResponseEntity<List<Hotel>> getHotelByCityForUser(@PathVariable(value = "city") String city) 
	{
		List<Hotel> hotel = hotelservice.findByHotelByCity(city);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
	
//	 UPDATE
	/*******************************************************************************************************
	- Function Name		: updateHotel(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody Hotel hotelRequest)
	- Input Parameters	: id,update,hotelRequest
	- Return Type		: ResponseEntity<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method updateHotelTiming(id, hotelRequest);updateHotelArea(id, hotelRequest);updateHotelCity(id, hotelRequest);
							updateHotelClassification(id,hotelRequest);updateHotelContactNo(id, hotelRequest);


	********************************************************************************************************/
	@PutMapping("/admin/updateHotel/{id}/{update}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody Hotel hotelRequest) {
		
		
		if(update.equalsIgnoreCase("HotelTiming"))
		{
			Hotel h=hotelservice.updateHotelTiming(id, hotelRequest);
			return new ResponseEntity<>(h,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("HotelArea"))
		{
			Hotel h=hotelservice.updateHotelArea(id, hotelRequest);
			return new ResponseEntity<>(h,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("HotelCity"))
		{
			Hotel h=hotelservice.updateHotelCity(id, hotelRequest);
			return new ResponseEntity<>(h,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("HotelClassification"))
		{
			Hotel h=hotelservice.updateHotelClassification(id, hotelRequest);
			return new ResponseEntity<>(h,HttpStatus.OK);
		}
		else if(update.equalsIgnoreCase("HotelContactNo"))
		{
			Hotel h=hotelservice.updateHotelContactNo(id, hotelRequest);
			return new ResponseEntity<>(h,HttpStatus.OK);
		}
		else
		{
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");

		}
	}
	
//  PDF
	/*******************************************************************************************************
	- Function Name		: hotelDetailsReportByCity(@PathVariable(value = "role") String role,@PathVariable("city") String city,HttpServletResponse response)
	- Input Parameters	: role,city
	- Return Type		: List<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelByCity(city); and it will create pdf


	********************************************************************************************************/
	@GetMapping("/{role}/findHotelByCity/{city}/pdf")
	public List<Hotel> hotelDetailsReportByCity(@PathVariable(value = "role") String role,@PathVariable("city") String city,HttpServletResponse response) throws IOException
	{
		if(role.equalsIgnoreCase("user")||role.equalsIgnoreCase("admin"))
		{
			 DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		        String headerKey = "Content-Disposition";
		        String headerVal = "attachment; filename=hotel_details_" + dateFormat.format(new Date()) + ".pdf";
		        response.setHeader(headerKey, headerVal);
		        List<Hotel> list = hotelservice.findByHotelByCity(city);
		        PdfGenereator.hotelDetailReport(response,list);
		        return list;
		}
		else
		{
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	/*******************************************************************************************************
	- Function Name		: allHotelDetailsReport(@PathVariable(value = "role") String role,HttpServletResponse response)
	- Input Parameters	: role
	- Return Type		: List<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveHotel(); and it will create pdf


	********************************************************************************************************/
	@GetMapping("/{role}/findAllHotel/pdf")
	public List<Hotel> allHotelDetailsReport(@PathVariable(value = "role") String role,HttpServletResponse response) throws IOException
	{
		if(role.equalsIgnoreCase("user")||role.equalsIgnoreCase("admin"))
		{
			 DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		        String headerKey = "Content-Disposition";
		        String headerVal = "attachment; filename=hotel_details_" + dateFormat.format(new Date()) + ".pdf";
		        response.setHeader(headerKey, headerVal);
		        List<Hotel> list = hotelservice.retrieveHotel();
		        PdfGenereator.hotelDetailReport(response,list);
		        return list;
		}
		else
		{
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	/*******************************************************************************************************
	- Function Name		: hotelDetailsReportByName(@PathVariable(value = "role") String role,@PathVariable("name") String name,HttpServletResponse response)
	- Input Parameters	: role,name
	- Return Type		: List<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelName(name); and it will create pdf


	********************************************************************************************************/
	@GetMapping("/{role}/findHotelByName/{name}/pdf")
	public List<Hotel> hotelDetailsReportByName(@PathVariable(value = "role") String role,@PathVariable("name") String name,HttpServletResponse response) throws IOException
	{
		if(role.equalsIgnoreCase("user")||role.equalsIgnoreCase("admin"))
		{
			 DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		        String headerKey = "Content-Disposition";
		        String headerVal = "attachment; filename=hotel_details_" + dateFormat.format(new Date()) + ".pdf";
		        response.setHeader(headerKey, headerVal);
		        List<Hotel> list = hotelservice.findByHotelName(name);
		        PdfGenereator.hotelDetailReport(response,list);
		        return list;
		}
		else
		{
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	/*******************************************************************************************************
	- Function Name		: hotelDetailsReportByArea(@PathVariable(value = "role") String role,@PathVariable("area") String area,HttpServletResponse response)
	- Input Parameters	: role,area
	- Return Type		: List<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByHotelByArea(area); and it will create pdf


	********************************************************************************************************/
	@GetMapping("/{role}/findHotelByArea/{area}/pdf")
	public List<Hotel> hotelDetailsReportByArea(@PathVariable(value = "role") String role,@PathVariable("area") String area,HttpServletResponse response) throws IOException
	{
		if(role.equalsIgnoreCase("user")||role.equalsIgnoreCase("admin"))
		{
			 DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		        String headerKey = "Content-Disposition";
		        String headerVal = "attachment; filename=hotel_details_" + dateFormat.format(new Date()) + ".pdf";
		        response.setHeader(headerKey, headerVal);
		        List<Hotel> list = hotelservice.findByHotelByArea(area);
		        PdfGenereator.hotelDetailReport(response,list);
		        return list;
		}
		else
		{
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	/*******************************************************************************************************
	- Function Name		: hotelDetailsReportById(@PathVariable("id") int id,HttpServletResponse response)
	- Input Parameters	: id
	- Return Type		: Hotel
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method findByID(id); and it will create pdf


	********************************************************************************************************/
	@GetMapping("/admin/findHotelById/{id}/pdf")
	public Hotel hotelDetailsReportById(@PathVariable("id") int id,HttpServletResponse response) throws IOException
	{
		
			 DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		        String headerKey = "Content-Disposition";
		        String headerVal = "attachment; filename=hotel_details_" + dateFormat.format(new Date()) + ".pdf";
		        response.setHeader(headerKey, headerVal);
		        Hotel list = hotelservice.findByID(id);
		        PdfGenereator.hotelDetailReportById(response,list);
		        return list;
		
	}
	
	
//	TO DOWNLOAD EXCEL FORMAT
	/*******************************************************************************************************
	- Function Name		: exportToExcel(HttpServletResponse response)
	- Input Parameters	: role
	- Return Type		: List<Hotel>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method retrieveHotel(); and it will create excel


	********************************************************************************************************/
	 @GetMapping("/admin/findAllHotel/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException 
	 {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Hotels_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Hotel> listUsers = hotelservice.retrieveHotel();
	         
	        ExcelExporter excelExporter = new ExcelExporter(listUsers);
	         
	        excelExporter.export(response);    
	 }
	 
	
}
