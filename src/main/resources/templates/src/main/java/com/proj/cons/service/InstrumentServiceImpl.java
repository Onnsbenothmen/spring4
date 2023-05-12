package com.proj.cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.cons.entities.Instrument;
import com.proj.cons.repos.InstrumentRepository;
@Service
public class InstrumentServiceImpl implements InstrumentService {
	
	@Autowired
	InstrumentRepository instrumentRepository;


	@Override
	public Instrument saveInst(Instrument i) {
		return instrumentRepository.save(i);
	}

	@Override
	public Instrument updateInst(Instrument i) {
		return instrumentRepository.save(i);

	}

	@Override
	public void deleteInst(Instrument i) {
		instrumentRepository.delete(i);		
	}

	@Override
	public void deleteInstById(String nomI) {
		instrumentRepository.deleteById(nomI);		
		
	}

	@Override
	public Instrument getInst(String nomI) {
		return instrumentRepository.findById(nomI).get();
	}

	@Override
	public List<Instrument> getAllInsts() {
		return instrumentRepository.findAll();
	}
	
	
	@Override
	public List<Instrument> findBynomI(String nomI) {
	return instrumentRepository.findBynomI(nomI);
	}

}
