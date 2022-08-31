package org.togo.rikCorpSolution.dtos;

import java.io.Serializable;


public class ProduitDTO implements Serializable{


	private long id;

	private String libelle;

	private int quantite;

	private double prixUnitaire;
	private CategorieDTO categorieDTO;

	public ProduitDTO() {

	}

	public ProduitDTO(long id, String libelle, int quantite, double prixUnitaire, CategorieDTO categorieDTO) {
		this.id = id;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.categorieDTO = categorieDTO;
	}

	public ProduitDTO(long id, String libelle, int quantite, double prixUnitaire) {
		this.id = id;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public CategorieDTO getCategorieDTO() {
		return categorieDTO;
	}

	public void setCategorieDTO(CategorieDTO categorieDTO) {
		this.categorieDTO = categorieDTO;
	}
}
