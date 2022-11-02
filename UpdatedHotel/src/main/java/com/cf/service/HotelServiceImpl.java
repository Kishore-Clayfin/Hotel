package com.cf.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Hotel;
import com.cf.repository.IHotelDao;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelDao hotelDao;

	/*******************************************************************************************************
	 - Function Name	:	addHotel(Hotel hotel)
	 - Input Parameters	:	hotel 
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	AddHotel
	 ********************************************************************************************************/
	@Override
	public Hotel addHotel(Hotel hotel) {
		Hotel h=hotelDao.save(hotel);
		log.info("Hotel Added");
		return h;
	}

	/*******************************************************************************************************
	 - Function Name	:	deleteHotel(int id)
	 - Input Parameters	:	id 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteHotel
	 ********************************************************************************************************/
	@Override
	public void deleteHotel(int id) 
	{
		 if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);
		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		hotelDao.deleteById(id);
		log.info("Hotel Deleted");

	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveHotel()
	 - Input Parameters	:	 
	 - Return Type		:	List<Hotel>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveAllHotel
	 ********************************************************************************************************/
	@Override
	public List<Hotel> retrieveHotel() {
		List<Hotel> list = hotelDao.findAll();
		return list;
	}

	/*******************************************************************************************************
	 - Function Name	:	retrieveHotelByLoc(String state,String city,String area)
	 - Input Parameters	:	state,city,area
	 - Return Type		:	List<Hotel>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	RetrieveHotelByLocation
	 ********************************************************************************************************/
	public List<Hotel> retrieveHotelByLoc(String state,String city,String area) 
	{
		 if (!hotelDao.existsByStateAndCityAndArea(state, city, area))
		 {
			 log.error("No hotel found in location = " + state+" "+city+" "+area);
		      throw new ResourceNotFoundException("No hotel found in location = " + state+" "+city+" "+area);
		 }
		List<Hotel> list = hotelDao.findByStateAndCityAndArea(state,city,area);
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateHotelTiming(int id, Hotel hotel)
	 - Input Parameters	:	id,hotel
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateHotelTiming
	 ********************************************************************************************************/
	@Override
	public Hotel updateHotelTiming(int id, Hotel hotel) 
	{
		 if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);
		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		Hotel updateHotel = hotelDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Hotel  found with id = " + id));
		updateHotel.setOpenTiming(hotel.getOpenTiming());
		updateHotel.setCloseTiming(hotel.getCloseTiming());
		Hotel h=hotelDao.save(updateHotel);
		log.info("Hotel Timing Updated");
		return h;
	}

	/*******************************************************************************************************
	 - Function Name	:	findByID(int id)
	 - Input Parameters	:	id
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	FindByID
	 ********************************************************************************************************/
	public Hotel findByID(int id) 
	{
		if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);
		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		Hotel hotel = hotelDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Hotel  found with id = " + id));

		return hotel;
	}

	/*******************************************************************************************************
	 - Function Name	:	findByHotelName(String name)
	 - Input Parameters	:	name
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	FindByHotelName
	 ********************************************************************************************************/
	public List<Hotel> findByHotelName(String name) {
		if (!hotelDao.existsByName(name)) {
			 log.error("No hotel found with name = " + name);

			throw new ResourceNotFoundException("No Hotel found with name = " + name);
		}
		List<Hotel> list = hotelDao.findByName(name);
		return list;

	}
	
	/*******************************************************************************************************
	 - Function Name	:	findByHotelByArea(String area)
	 - Input Parameters	:	area
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	FindByHotelByArea
	 ********************************************************************************************************/
	public List<Hotel> findByHotelByArea(String area) {
		if (!hotelDao.existsByArea(area)) {
			 log.error("No hotel found with area = " + area);

			throw new ResourceNotFoundException("No Hotel found in Area = " + area);
		}
		List<Hotel> list = hotelDao.findByArea(area);
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	findByHotelByCity(String city)
	 - Input Parameters	:	city
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	FindByHotelByCity
	 ********************************************************************************************************/
	public List<Hotel> findByHotelByCity(String city) {
		if (!hotelDao.existsByCity(city)) {
			 log.error("No hotel found with city = " + city);

			throw new ResourceNotFoundException("No Hotel found in City = " + city);
		}
		List<Hotel> list = hotelDao.findByCity(city);
		return list;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateHotelArea(int id, Hotel hotel)
	 - Input Parameters	:	id,hotel
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateHotelArea
	 ********************************************************************************************************/
	@Override
	public Hotel updateHotelArea(int id, Hotel hotel) {
		if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);

		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		Hotel updateHotel = hotelDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Hotel  found with id = " + id));
		updateHotel.setArea(hotel.getArea());
		Hotel h=hotelDao.save(updateHotel);		
		log.info("Hotel Area Updated");
		return h;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateHotelCity(int id, Hotel hotel)
	 - Input Parameters	:	id,hotel
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateHotelCity
	 ********************************************************************************************************/
	@Override
	public Hotel updateHotelCity(int id, Hotel hotel) {
		if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);

		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		Hotel updateHotel = hotelDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Hotel  found with id = " + id));
		updateHotel.setCity(hotel.getCity());
		Hotel h=hotelDao.save(updateHotel);	
		log.info("Hotel City Updated");
		return h;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateHotelClassification(int id, Hotel hotel)
	 - Input Parameters	:	id,hotel
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateHotelClassification
	 ********************************************************************************************************/
	@Override
	public Hotel updateHotelClassification(int id, Hotel hotel) {
		if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);

		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		Hotel updateHotel = hotelDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Hotel  found with id = " + id));
		updateHotel.setClassification(hotel.getClassification());
		Hotel h=hotelDao.save(updateHotel);		
		log.info("Hotel Classification Updated");
		return h;
	}

	/*******************************************************************************************************
	 - Function Name	:	updateHotelContactNo(int id, Hotel hotel)
	 - Input Parameters	:	id,hotel
	 - Return Type		:	Hotel
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	UpdateHotelContactNumber
	 ********************************************************************************************************/
	@Override
	public Hotel updateHotelContactNo(int id, Hotel hotel) {
		if (!hotelDao.existsById(id))
		 {
			 log.error("No hotel found with id = " + id);

		      throw new ResourceNotFoundException("No hotel found with id = " + id);
		 }
		Hotel updateHotel = hotelDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Hotel  found with id = " + id));
		updateHotel.setContactNumber(hotel.getContactNumber());
		Hotel h=hotelDao.save(updateHotel);		
		log.info("Hotel COntact Number Updated");
		return h;
	}
	

}
