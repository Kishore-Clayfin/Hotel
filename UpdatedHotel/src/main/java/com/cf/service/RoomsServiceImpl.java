package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Rooms;
import com.cf.repository.IRoomsDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class RoomsServiceImpl implements IRoomsService
{
	@Autowired
	private IRoomsDao roomsDao;

	/*******************************************************************************************************
	 - Function Name	:	addRooms(Rooms rooms)
	 - Input Parameters	:	rooms 
	 - Return Type		:	Rooms
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddRooms
	 ********************************************************************************************************/
	@Override
	public Rooms addRooms(Rooms rooms)
	{
		Rooms r=roomsDao.save(rooms);
		log.info("Rooms Added");
		return r;
	}

	/*******************************************************************************************************
	 - Function Name	:	deleteRooms(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteRooms
	 ********************************************************************************************************/
	@Override
	public void deleteRooms(int id) 
	{
		if (!roomsDao.existsById(id))
		 {
			log.error("No Rooms found with id = " + id);
		      throw new ResourceNotFoundException("No Rooms found with id = " + id);
		 }
		roomsDao.deleteById(id);
		log.info("Rooms Deleted");

	}

	/*******************************************************************************************************
	 - Function Name	:	deleteRooms(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteRooms
	 ********************************************************************************************************/
	@Override
	public List<Rooms> retrieveRooms()
	{
		List<Rooms> list= roomsDao.findAll();
		return list;
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveRoomsById(int id) 
	 - Input Parameters	:	id 
	 - Return Type		:	Rooms
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveRoomsById
	 ********************************************************************************************************/
	@Override
	public Rooms retrieveRoomsById(int id) 
	{
		if (!roomsDao.existsById(id))
		 {
			log.error("No Rooms found with id = " + id);
		      throw new ResourceNotFoundException("No Rooms found with id = " + id);
		 }
		Rooms rooms=roomsDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Rooms  found with id = " + id));
		return rooms;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateRoomsNo(int id, Rooms rooms)
	 - Input Parameters	:	id,rooms 
	 - Return Type		:	Rooms
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateRoomsNumber
	 ********************************************************************************************************/
	@Override
	public Rooms updateRoomsNo(int id, Rooms rooms)
	{
		if (!roomsDao.existsById(id))
		 {
			log.error("No Rooms found with id = " + id);
		      throw new ResourceNotFoundException("No Rooms found with id = " + id);
		 }
		Rooms room =roomsDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Rooms  found with id = " + id));
		room.setRoomNumber(rooms.getRoomNumber());
		Rooms r=roomsDao.save(room);
		log.info("Rooms RoomsNo updated");
		return r;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateRoomsType(int id, Rooms rooms)
	 - Input Parameters	:	id,rooms 
	 - Return Type		:	Rooms
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateRoomsType
	 ********************************************************************************************************/
	@Override
	public Rooms updateRoomsType(int id, Rooms rooms) {
		if (!roomsDao.existsById(id))
		 {
			log.error("No Rooms found with id = " + id);
		      throw new ResourceNotFoundException("No Rooms found with id = " + id);
		 }
		Rooms room =roomsDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Rooms  found with id = " + id));
		room.setRoomType(rooms.getRoomType());
		Rooms r=roomsDao.save(room);	
		log.info("Rooms Rooms Type updated");
		return r;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateRoomNoOfBeds(int id, Rooms rooms)
	 - Input Parameters	:	id,rooms 
	 - Return Type		:	Rooms
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateRoomNoOfBeds
	 ********************************************************************************************************/
	@Override
	public Rooms updateRoomNoOfBeds(int id, Rooms rooms)
	{
		if (!roomsDao.existsById(id))
		 {
			log.error("No Rooms found with id = " + id);
		      throw new ResourceNotFoundException("No Rooms found with id = " + id);
		 }
		Rooms room =roomsDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Rooms  found with id = " + id));
		room.setNumberOfBeds(rooms.getNumberOfBeds());
		Rooms r=roomsDao.save(room);
		log.info("Rooms Rooms NoOfBeds updated");
		return r;
	}
	
}
