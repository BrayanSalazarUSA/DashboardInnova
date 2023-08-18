package com.innovamonitoring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovamonitoring.models.entity.Agent;
import com.innovamonitoring.models.entity.Camera;
import com.innovamonitoring.models.services.IAgentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AgentController {

	
	@Autowired
	private IAgentService agentService;
	
	@GetMapping("/agents")
	public List<Agent> index() {
		return agentService.findAll();
	}
	
	@PostMapping("/agents")
	public Agent create(@RequestBody Agent agent) {
	
		return agentService.save(agent);
	}
	
	

	@PutMapping("/agents/{id}")
	public Agent update(@RequestBody Agent agent, @PathVariable Long id) {
		
		Agent actualAgent = agentService.findById(id);
		
		Agent agentUpdated = null;
		
		actualAgent.setName(agent.getName());
		actualAgent.setLastName(agent.getLastName());
		
		agentUpdated = agentService.save(actualAgent);
		
		return agentUpdated;
	}
	
	@DeleteMapping("/agent/{id}")
	public void delete(@PathVariable Long id) {
		
		agentService.deleteById(id);
	} 
	
	
}
