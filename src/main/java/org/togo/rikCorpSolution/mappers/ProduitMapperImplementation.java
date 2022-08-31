package org.togo.rikCorpSolution.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.togo.rikCorpSolution.dtos.ProduitDTO;
import org.togo.rikCorpSolution.entities.Produit;

@Service
public class ProduitMapperImplementation {
    public ProduitDTO fromProduit(Produit produit){
        ProduitDTO produitDTO = new ProduitDTO();
        BeanUtils.copyProperties(produit,produitDTO);
        produitDTO.setCategorieDTO(CategorieMapperImplementation.fromCategorie(produit.getCategorie()));
        return produitDTO;
    }
    public Produit fromProduitDTO(ProduitDTO produitDTO){
        Produit produit = new Produit();
        BeanUtils.copyProperties(produitDTO,produit);
        produit.setCategorie(CategorieMapperImplementation.fromCategorieDTO(produitDTO.getCategorieDTO()));
        return produit;
    }
}
