package com.agriness.onlinebooks.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import com.agriness.onlinebooks.model.Reservation;

@Repository(forEntity = Reservation.class) 
public interface ReservationRepository extends EntityRepository <Reservation, Long>{
	@Query("select r from Reservation r where r.client.id = ?1")
	List<Reservation> findByClient(Long clientId);
	
	
}
