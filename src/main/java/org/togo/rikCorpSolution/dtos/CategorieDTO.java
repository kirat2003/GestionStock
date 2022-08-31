package org.togo.rikCorpSolution.dtos;

import lombok.Data;

import java.io.Serializable;

public class CategorieDTO implements Serializable{
	
	private long id;
	
	private String libelle;

	public CategorieDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
