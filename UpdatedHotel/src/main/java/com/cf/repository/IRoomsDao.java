package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.Rooms;

public interface IRoomsDao extends JpaRepository<Rooms, Integer>
{

}
