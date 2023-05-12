package com.proj.cons.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prof {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idP;
	private String nomP;
	private String prenomP;
	private int numP;
	private String emailP;
	
	@JsonIgnore
	@OneToMany(mappedBy = "prof")
	private List<Instrument> instruments;

	public Prof() {
		
	}

	public Prof(String nomP, String prenomP, int numP, String emailP, List<Instrument> instruments) {
		super();
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.numP = numP;
		this.emailP = emailP;
		this.instruments = instruments;
	}

	public Long getIdP() {
		return idP;
	}

	public void setIdP(Long idP) {
		this.idP = idP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getPrenomP() {
		return prenomP;
	}

	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}

	public int getNumP() {
		return numP;
	}

	public void setNumP(int numP) {
		this.numP = numP;
	}

	public String getEmailP() {
		return emailP;
	}

	public void setEmailP(String emailP) {
		this.emailP = emailP;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public String toString() {
		return "Prof [idP=" + idP + ", nomP=" + nomP + ", prenomP=" + prenomP + ", numP=" + numP + ", emailP=" + emailP
				+ ", instruments=" + instruments + "]";
	}
	
	
	
	



	

}
