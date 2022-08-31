package org.togo.rikCorpSolution.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.togo.rikCorpSolution.dtos.CategorieDTO;
import org.togo.rikCorpSolution.dtos.ProduitDTO;
import org.togo.rikCorpSolution.entities.Categorie;
import org.togo.rikCorpSolution.entities.Produit;
import org.togo.rikCorpSolution.mappers.CategorieMapperImplementation;
import org.togo.rikCorpSolution.mappers.ProduitMapperImplementation;
import org.togo.rikCorpSolution.repositories.CategorieRepository;
import org.togo.rikCorpSolution.services.CategorieService;
import org.togo.rikCorpSolution.services.ProduitService;
import org.togo.rikCorpSolution.repositories.ProduitRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProduitServiceImplementation implements ProduitService{

	private ProduitRepository produitRep;
	private CategorieRepository categorieRepository;
	private ProduitMapperImplementation produitMapperImplementation;

	@Autowired
	public ProduitServiceImplementation(ProduitRepository produitRep,CategorieRepository categorieRepository,ProduitMapperImplementation produitMapperImplementation) {
		this.produitRep=produitRep;
		this.categorieRepository=categorieRepository;
		this.produitMapperImplementation=produitMapperImplementation;
	}
	@Override
	public ProduitDTO ajouter(String libelle, int quantite, double prixUnitaire, long idCategorie) {
		// TODO Auto-generated method stub
		Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
		Produit produit = new Produit();
		produit.setLibelle(libelle);
		produit.setQuantite(quantite);
		produit.setPrixUnitaire(prixUnitaire);
		produit.setCategorie(categorie);
		return produitMapperImplementation.fromProduit(produitRep.save(produit));
	}
	@Override
	public ProduitDTO rechercherById(long id) {
		// TODO Auto-generated method stub
		return produitMapperImplementation.fromProduit(produitRep.findById(id).get());
	}

	@Override
	public ProduitDTO rechercherByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return produitMapperImplementation.fromProduit(produitRep.findByLibelle(libelle));
	}

	@Override
	public void supprimer(long id) {
		// TODO Auto-generated method stub
		produitRep.deleteById(id);
	}

	@Override
	public void supprimerByLibelle(String libelle) {
		// TODO Auto-generated method stub
		produitRep.deleteByLibelle(libelle);
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO produitDTO) {
		return produitMapperImplementation.fromProduit(produitRep.save(produitMapperImplementation.fromProduitDTO(produitDTO)));
	}
	@Override
	public ProduitDTO updateProduitV2(ProduitDTO produitDTO,long idCategory) {
		produitDTO.setCategorieDTO(CategorieMapperImplementation.fromCategorie(categorieRepository.findById(idCategory).get()));
		return produitMapperImplementation.fromProduit(produitRep.save(produitMapperImplementation.fromProduitDTO(produitDTO)));
	}
	@Override
	public List<ProduitDTO> afficherAll() {
		// TODO Auto-generated method stub
		List<Produit> produits = produitRep.displayAllProduct();
		return produits.stream().map(produit -> produitMapperImplementation.fromProduit(produit)).collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> afficherByCategory(long idCategory) {
		// TODO Auto-generated method stub
		List<Produit> produits = produitRep.displayAllProductByCategorieId(idCategory);
		return produits.stream().map(produit ->produitMapperImplementation.fromProduit(produit)).collect(Collectors.toList());
	}

}
