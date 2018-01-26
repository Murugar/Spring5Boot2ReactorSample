package com.iqmsoft.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.iqmsoft.model.Client;

import reactor.core.publisher.Flux;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
	
	Flux<Client> findByName(String name);
	
}
