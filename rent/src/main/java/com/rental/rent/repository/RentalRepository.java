package com.rental.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rent.entity.Rental;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>{
    
}
