package com.agriness.onlinebooks.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.agriness.onlinebooks.model.Client;


@Repository(forEntity = Client.class) 
public interface ClientRepository extends EntityRepository <Client, Long>{

}
