package org.togo.rikCorpSolution.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.togo.rikCorpSolution.dtos.CategorieDTO;
import org.togo.rikCorpSolution.dtos.CategoryHistoryDTO;
import org.togo.rikCorpSolution.dtos.ProduitDTO;
import org.togo.rikCorpSolution.entities.Categorie;
import org.togo.rikCorpSolution.entities.Produit;
import org.togo.rikCorpSolution.exceptions.CategoryEntityNotFoundException;
import org.togo.rikCorpSolution.mappers.CategorieMapperImplementation;
import org.togo.rikCorpSolution.mappers.ProduitMapperImplementation;
import org.togo.rikCorpSolution.repositories.ProduitRepository;
import org.togo.rikCorpSolution.services.CategorieService;
import org.togo.rikCorpSolution.repositories.CategorieRepository;

@Service
@Transactional
public class CategorieServiceImplementation implements CategorieService{
	
	private final CategorieRepository categorieRep;
	private final ProduitRepository produitRep;
	private  final ProduitMapperImplementation produitMapperImplementation;
	private final CategorieMapperImplementation categorieMapperImplementation;
	@Autowired
	public CategorieServiceImplementation(CategorieRepository categorieRep,CategorieMapperImplementation categorieMapperImplementation,ProduitMapperImplementation produitMapperImplementation,ProduitRepository produitRep) {
		this.categorieRep=categorieRep;
		this.categorieMapperImplementation=categorieMapperImplementation;
		this.produitRep=produitRep;
		this.produitMapperImplementation=produitMapperImplementation;
	}

	@Override
	public CategorieDTO ajouter(CategorieDTO categorieDTO) {
		// TODO Auto-generated method stub
		Categorie saveCategorie = categorieMapperImplementation.fromCategorieDTO(categorieDTO);
		return categorieMapperImplementation.fromCategorie(categorieRep.save(saveCategorie));
	}

	@Override
	public CategorieDTO rechercherById(long id) {
		// TODO Auto-generated method stub
		Categorie categorie = categorieRep.findById(id).get();
		return categorieMapperImplementation.fromCategorie(categorie);
	}

	@Override
	public CategorieDTO rechercherByLibelle(String libelle) {
		// TODO Auto-generated method stub
		Categorie categorie = categorieRep.findByLibelle(libelle);
		return categorieMapperImplementation.fromCategorie(categorie);
	}

	@Override
	public void supprimer(long id) {
		// TODO Auto-generated method stub
		categorieRep.deleteById(id);
	}

	@Override
	public List<CategorieDTO> afficherAll() {
		// TODO Auto-generated method stub
		return categorieRep.displayAllCategories().stream().map(categorie -> categorieMapperImplementation.fromCategorie(categorie)).collect(Collectors.toList());
	}

	@Override
	public List<CategorieDTO> rechercherByKeyWord(String libelle) {
		return categorieRep.searchByKeyword(libelle).stream().map(categorie -> categorieMapperImplementation.fromCategorie(categorie)).collect(Collectors.toList());
	}

	@Override
	public CategorieDTO updateCategorie(CategorieDTO categorieDTO) {
		// TODO Auto-generated method stub
		Categorie saveCategorie = categorieMapperImplementation.fromCategorieDTO(categorieDTO);
		return categorieMapperImplementation.fromCategorie(categorieRep.save(saveCategorie));
	}

	@Override
	public CategoryHistoryDTO getProductPaged(long id, int page, int size) throws CategoryEntityNotFoundException {
		Categorie categorie = categorieRep.findById(id).orElse(null);
		if (categorie==null) throw new CategoryEntityNotFoundException("Categorie Not Found");
		Page<Produit> produits = produitRep.findProductByCat(id, PageRequest.of(page,size));
		CategoryHistoryDTO categoryHistoryDTO = new CategoryHistoryDTO();
		List<ProduitDTO> produitDTOS = produits.stream().map(produit -> produitMapperImplementation.fromProduit(produit)).collect(Collectors.toList());
		categoryHistoryDTO.setProduitDTOS(produitDTOS);
		categoryHistoryDTO.setId(categorie.getId());
		categoryHistoryDTO.setLibelle(categorie.getLibelle());
		categoryHistoryDTO.setCurrentPage(page);
		categoryHistoryDTO.setSizePages(size);
		categoryHistoryDTO.setTotalPages(produits.getTotalPages());
		return categoryHistoryDTO;
	}
}
