package com.proj.cons.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
@Entity
public class Instrument {
	@Id
	private String nomI;
	private double prixI;
	private String heure;
	@Lob
	private byte[] image;
	@ManyToOne
	private Prof prof;


	
	
	
	public Prof getProf() {
		return prof;
	}






	public void setProf(Prof prof) {
		this.prof = prof;
	}






	public Instrument() {
		
	}



	


	public Instrument(String nomI, double prixI, String heure, byte[] image) {
		super();
		this.nomI = nomI;
		this.prixI = prixI;
		this.heure = heure;
		this.image = image;
	}






	public String getNomI() {
		return nomI;
	}



	public void setNomI(String nomI) {
		this.nomI = nomI;
	}



	public double getPrixI() {
		return prixI;
	}



	public void setPrixI(double prixI) {
		this.prixI = prixI;
	}



	public String getHeure() {
		return heure;
	}



	public void setHeure(String heure) {
		this.heure = heure;
	}



	public byte[] getImage() {
		return image;
	}






	public void setImage(byte[] image) {
		this.image = image;
	}






	@Override
	public String toString() {
		return "Instrument [nomI=" + nomI + ", prixI=" + prixI + ", heure=" + heure + ", image="
				+ Arrays.toString(image) + "]";
	}







	
	
	
	
	

}
