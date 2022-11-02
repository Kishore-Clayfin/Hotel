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
import com.cf.model.Rooms;
import com.cf.service.RoomsServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/admin")
public class RoomsController
{
	@Autowired
	private RoomsServiceImpl roomsService;
	
//	ADD
	/*******************************************************************************************************
	- Function Name		: createRooms(@Valid @RequestBody Rooms roomsRequest)
	- Input Parameters	:  roomsRequest
	- Return Type		: ResponseEntity<Rooms>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method addRooms(roomsRequest);
	********************************************************************************************************/
	@PostMapping("/addrooms")
	public ResponseEntity<Rooms> createRooms(@Valid @RequestBody Rooms roomsRequest) {
		Rooms r=roomsService.addRooms(roomsRequest);
		return new ResponseEntity<>(r, HttpStatus.CREATED);
	}
//	 DELETE
	/*******************************************************************************************************
	- Function Name		: deleteRooms(@PathVariable("id") int id)
	- Input Parameters	: id
	- Return Type		: ResponseEntity<HttpStatus>
	- Throws    		: ResourceNotFoundException
	- Author     		: KISHOREKUMAR 
	- Description		: calls service method deleteRooms(id);
	********************************************************************************************************/
	 @DeleteMapping("/deleteRooms/{id}")
	  public ResponseEntity<HttpStatus> deleteRooms(@PathVariable("id") int id)
	 {
		 roomsService.deleteRooms(id);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	 
//	 RETRIEVE
	 /*******************************************************************************************************
		- Function Name		: getAllRooms()
		- Input Parameters	: 
		- Return Type		: ResponseEntity<List<Rooms>>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveRooms();
		********************************************************************************************************/
	 @GetMapping("/findAllRooms")
		public ResponseEntity<List<Rooms>> getAllRooms() 
	 {
			List<Rooms> list = roomsService.retrieveRooms();

			return new ResponseEntity<>(list, HttpStatus.OK);
		}

//			 RETRIEVE BY ID
	 /*******************************************************************************************************
		- Function Name		: getDepartmentById(@PathVariable(value = "id") int id)
		- Input Parameters	: id
		- Return Type		: ResponseEntity<Rooms>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method retrieveRoomsById(id);
		********************************************************************************************************/
		@GetMapping("/findRooms/{id}")
		public ResponseEntity<Rooms> getDepartmentById(@PathVariable(value = "id") int id) {
			Rooms room = roomsService.retrieveRoomsById(id);

			return new ResponseEntity<>(room, HttpStatus.OK);
		}
//		UPDATE
		/*******************************************************************************************************
		- Function Name		: updateDepartment(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody Rooms roomsRequest)
		- Input Parameters	: id,,update,roomsRequest
		- Return Type		: ResponseEntity<Rooms>
		- Throws    		: ResourceNotFoundException
		- Author     		: KISHOREKUMAR 
		- Description		: calls service method updateRoomNoOfBeds(id, roomsRequest);updateRoomsNo(id, roomsRequest);updateRoomsType(id, roomsRequest);
		********************************************************************************************************/
		 @PutMapping("/updateRooms/{id}/{update}")
		  public ResponseEntity<Rooms> updateDepartment(@PathVariable("id") int id,@PathVariable("update") String update, @RequestBody Rooms roomsRequest) 
		 {
			 
		     if(update.equalsIgnoreCase("RoomNoOfBeds"))
		     {
		    	 Rooms r=roomsService.updateRoomNoOfBeds(id, roomsRequest);
			     return new ResponseEntity<>(r,HttpStatus.OK);
		     }
		     else if(update.equalsIgnoreCase("RoomsNo"))
		     {
		    	 Rooms r=roomsService.updateRoomsNo(id, roomsRequest);
			     return new ResponseEntity<>(r,HttpStatus.OK);
		     }
		     else if(update.equalsIgnoreCase("RoomsType"))
		     {
		    	 Rooms r= roomsService.updateRoomsType(id, roomsRequest);
			     return new ResponseEntity<>(r,HttpStatus.OK);
		     }
		     else
		     {
					log.error("BAD CREDENTIALS");

		     	throw new ResourceNotFoundException("BAD CREDENTIALS");

		     }
		 }
	
}
