package com.proj.cons.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idC;
	private String nomPC;
	private String nomC;
	private String prenomC;
	private Date dateNC;
	private int numC;
	private String emailC;
	public Client() {
		
	}
	public Client(String nomPC, String nomC, String prenomC, Date dateNC, int numC, String emailC) {
		super();
		this.nomPC = nomPC;
		this.nomC = nomC;
		this.prenomC = prenomC;
		this.dateNC = dateNC;
		this.numC = numC;
		this.emailC = emailC;
	}
	public Long getIdC() {
		return idC;
	}
	public void setIdC(Long idC) {
		this.idC = idC;
	}
	public String getNomPC() {
		return nomPC;
	}
	public void setNomPC(String nomPC) {
		this.nomPC = nomPC;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getPrenomC() {
		return prenomC;
	}
	public void setPrenomC(String prenomC) {
		this.prenomC = prenomC;
	}
	public Date getDateNC() {
		return dateNC;
	}
	public void setAgeC(Date dateNC) {
		this.dateNC = dateNC;
	}
	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public String getEmailC() {
		return emailC;
	}
	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}
	@Override
	public String toString() {
		return "Client [idC=" + idC + ", nomPC=" + nomPC + ", nomC=" + nomC + ", prenomC=" + prenomC + ", dateNC=" + dateNC
				+ ", numC=" + numC + ", emailC=" + emailC + "]";
	}
	
	
	
}
