package com.proj.cons.service;

import java.util.List;

import com.proj.cons.entities.Instrument;

public interface InstrumentService {

	public Instrument saveInst(Instrument i);
	
	public Instrument updateInst(Instrument i);
	
	public void deleteInst(Instrument i);
	
	public void deleteInstById(String nomI);
	
	public Instrument getInst(String nomI);
	
	public List<Instrument> getAllInsts();
	List<Instrument> findBynomI(String nomI);

}
