package com.proj.cons.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proj.cons.entities.Instrument;
import com.proj.cons.service.InstrumentService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class InstrumentRESTController {
	@Autowired
	InstrumentService instrumentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Instrument> getAllInsts() {
	return instrumentService.getAllInsts();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Instrument getInstById(@PathVariable("id") String id) {
	return instrumentService.getInst(id);
	 }

	
	@RequestMapping(method = RequestMethod.POST)
	public Instrument createInst(@RequestBody Instrument instrument) {
	return instrumentService.saveInst(instrument);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Instrument updateInst(@RequestBody Instrument instrument) {
	return instrumentService.updateInst(instrument);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteInst(@PathVariable("id") String id)
	{
		instrumentService.deleteInstById(id);
	}


	

}
