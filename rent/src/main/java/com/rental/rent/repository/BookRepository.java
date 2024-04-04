package com.rental.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rent.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
