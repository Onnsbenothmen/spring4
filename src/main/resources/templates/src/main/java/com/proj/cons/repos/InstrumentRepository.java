package com.proj.cons.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.cons.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, String> {
	List<Instrument> findBynomI(String nomI);

}
