package com.kaiburr.servertask.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaiburr.servertask.model.Server;
import com.kaiburr.servertask.repository.ServerRepository;

@RestController
public class ServerController {
	 
	@Autowired 
	private ServerRepository serverRepository; 
	
	
	@GetMapping("/findAllServers")
	public List<Server> getAllServers(){
		
		return this.serverRepository.findAll();
	}
	@GetMapping("/findServer/{id}")
	public Optional<Server> getServers(@PathVariable int id){
		return this.serverRepository.findById(id);
	}
	
	@GetMapping("/findServerByName/{name}")
	public List<Server> getServersByName(@PathVariable String name){
		return this.serverRepository.getServersByName(name);
		
	}
	
	@PostMapping("/addServer")
	public Server saveServer(@RequestBody Server server) {
		this.serverRepository.save(server);
		return server;
		
	}

	@DeleteMapping("/deleteServer/{id}") 
	public String deleteServer(@PathVariable int id) {
		serverRepository.deleteById(id);
		return "Server with id " + id + " is deleted";
	}
	
}
