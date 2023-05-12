package com.proj.cons.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proj.cons.entities.Client;

import com.proj.cons.repos.ClientRepository;


@RestController
@RequestMapping("/api/client")
@CrossOrigin("*")
public class ClientRESTController {
	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Client> getAllClients()
	{
	return clientRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Client getClientById(@PathVariable("id") Long id) {
	return clientRepository.findById(id).get();
	}
	@RequestMapping(method = RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
	return clientRepository.save(client);
	}
	

}
