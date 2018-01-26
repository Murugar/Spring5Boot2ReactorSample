package com.iqmsoft.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.model.Client;
import com.iqmsoft.repository.ClientRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class ClientController {
	
	@Autowired
    private ClientRepository personRespository;
	
	@GetMapping
    public Flux<Client> index() {
        return personRespository.findAll();
    }
	
	
}
