package com.cf.service;

import java.util.List;

import com.cf.model.Rooms;

public interface IRoomsService 
{
	Rooms addRooms(Rooms rooms);
	void deleteRooms(int id);
	List<Rooms> retrieveRooms();
	Rooms retrieveRoomsById(int id);
	Rooms updateRoomsNo(int id, Rooms rooms);
	Rooms updateRoomsType(int id, Rooms rooms);
	Rooms updateRoomNoOfBeds(int id, Rooms rooms);

}
