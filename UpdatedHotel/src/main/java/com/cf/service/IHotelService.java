package com.cf.service;

import java.util.List;

import com.cf.model.Hotel;

public interface IHotelService 
{
	Hotel addHotel(Hotel hotel);

	void deleteHotel(int id);

	List<Hotel> retrieveHotel();

	Hotel updateHotelArea(int id, Hotel hotel);
	Hotel updateHotelCity(int id, Hotel hotel);
	Hotel updateHotelClassification(int id, Hotel hotel);
	Hotel updateHotelTiming(int id, Hotel hotel);
	Hotel updateHotelContactNo(int id, Hotel hotel);

	
}
