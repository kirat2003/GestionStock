package org.togo.rikCorpSolution.services;

import java.util.List;

import org.togo.rikCorpSolution.dtos.ProduitDTO;
import org.togo.rikCorpSolution.entities.Categorie;
import org.togo.rikCorpSolution.entities.Produit;

public interface ProduitService {

	public ProduitDTO ajouter(String libelle, int quantite, double prixUnitaire, long id);
	public ProduitDTO rechercherById(long id);
	public ProduitDTO rechercherByLibelle(String libelle);
	
	public void supprimer(long id);
	public void supprimerByLibelle(String libelle);

	public ProduitDTO updateProduit(ProduitDTO produitDTO);
	public ProduitDTO updateProduitV2(ProduitDTO produitDTO,long idCategory);

	public List<ProduitDTO> afficherAll();
	
	public List<ProduitDTO> afficherByCategory(long idCategory);
	
}
