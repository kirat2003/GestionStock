package org.togo.rikCorpSolution.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="libelle_prod",nullable=false,unique=true)
	private String libelle;
	
	@Column(name="quantite_prod",nullable = false)
	private int quantite;
	
	@Column(name="prixUnitaire_prod",nullable=false)
	private double prixUnitaire;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Categorie categorie;

	public Produit() {
		super();
		//TODO Auto-generated constructor stub
	}
	

	public Produit(String libelle, int quantite, double prixUnitaire, Categorie categorie) {
		super();
		this.libelle = libelle;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.categorie = categorie;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
