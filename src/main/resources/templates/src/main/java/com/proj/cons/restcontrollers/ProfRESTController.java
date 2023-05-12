package com.proj.cons.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.proj.cons.entities.Prof;
import com.proj.cons.repos.ProfRepository;



@RestController
@RequestMapping("/api/prof")
@CrossOrigin("*")
public class ProfRESTController {
	@Autowired
	ProfRepository profRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Prof> getAllProfs()
	{
	return profRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Prof getProfById(@PathVariable("id") Long id) {
	return profRepository.findById(id).get();
	}
	@RequestMapping(method = RequestMethod.POST)
	public Prof createProf(@RequestBody Prof prof) {
	return profRepository.save(prof);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Prof updateProf(@RequestBody Prof prof) {
	return profRepository.save(prof);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProf(@PathVariable("id") Long id)
	{
		profRepository.deleteById(id);
	}
	
	

}
