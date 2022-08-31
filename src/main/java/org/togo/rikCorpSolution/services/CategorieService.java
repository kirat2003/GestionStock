package org.togo.rikCorpSolution.services;

import java.util.List;

import org.togo.rikCorpSolution.dtos.CategorieDTO;
import org.togo.rikCorpSolution.dtos.CategoryHistoryDTO;
import org.togo.rikCorpSolution.entities.Categorie;
import org.togo.rikCorpSolution.exceptions.CategoryEntityNotFoundException;

public interface CategorieService {

	public CategorieDTO ajouter(CategorieDTO categorieDTO);
	public CategorieDTO rechercherById(long id);
	public CategorieDTO rechercherByLibelle(String libelle);
	
	public void supprimer(long id);
	
	public List<CategorieDTO> afficherAll();

	public List<CategorieDTO> rechercherByKeyWord(String libelle);

	CategorieDTO updateCategorie(CategorieDTO categorieDTO);

    CategoryHistoryDTO getProductPaged(long id, int page, int size) throws CategoryEntityNotFoundException;
}
