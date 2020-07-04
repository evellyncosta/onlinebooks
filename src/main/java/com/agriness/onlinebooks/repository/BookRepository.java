package com.agriness.onlinebooks.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.agriness.onlinebooks.model.Book;


@Repository(forEntity = Book.class) 
public interface BookRepository  extends EntityRepository <Book, Long>{
	
}
