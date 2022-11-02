package com.cf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cf.model.Hotel;

public interface IHotelDao extends JpaRepository<Hotel, Integer>
{
	 List<Hotel> findByName(String name);
	 List<Hotel> findByArea(String area);
	 List<Hotel> findByCity(String city);
	 List<Hotel> findByStateAndCityAndArea(String state,String city,String area);
	 boolean existsByStateAndCityAndArea(String state,String city,String area);
	 boolean existsByName(String name);
	 boolean existsByArea(String area);
	 boolean existsByCity(String city);
}
