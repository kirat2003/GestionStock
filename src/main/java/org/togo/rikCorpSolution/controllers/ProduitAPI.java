package org.togo.rikCorpSolution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.togo.rikCorpSolution.dtos.CategorieDTO;
import org.togo.rikCorpSolution.dtos.ProduitDTO;
import org.togo.rikCorpSolution.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping(path = "/API/V1/Product")
@CrossOrigin("*")
public class ProduitAPI {

    private ProduitService produitService;

    @Autowired
    public ProduitAPI(ProduitService produitService){
        this.produitService=produitService;
    }

    @GetMapping(path = "/products")
    public List<ProduitDTO> displayAllProducts(){
        return produitService.afficherAll();
    }

    @GetMapping(path = "/category/{id}/products")
    public List<ProduitDTO> displayInOneCategoryAllProducts(@PathVariable("id")long idCategory){
        return produitService.afficherByCategory(idCategory);
    }

    @PostMapping(path = "/create")
    public ProduitDTO createProduct(@RequestParam(name = "libelle") String libelle,@RequestParam(name = "quantite")int quantite,@RequestParam(name = "prixUnitaire")double prixUnitaire,@RequestParam(name = "idCategory")long idCategory){
        return produitService.ajouter(libelle,quantite,prixUnitaire,idCategory);
    }

    @DeleteMapping(path="/deleteById/{id}")
    public void deleteProductById(@PathVariable("id")long id){
        produitService.supprimer(id);
    }

    @DeleteMapping(path="/deleteByLibelle/{libelle}")
    public void deleteProductByLibelle(@PathVariable("libelle")String libelle){
        produitService.supprimerByLibelle(libelle);
    }

    @PutMapping(path = "/update/{id}")
    public ProduitDTO updateProduct(@PathVariable("id")long id,@RequestParam(name = "libelle",required = false) String libelle,@RequestParam(name = "quantite",required = false) int quantite,@RequestParam(name = "prixUnitaire",required = false) double prixUnitaire,@RequestBody CategorieDTO categorieDTO){
        return produitService.updateProduit(new ProduitDTO(id,libelle,quantite,prixUnitaire,categorieDTO));
    }
    @PutMapping(path = "/updateV2/{id}")
    public ProduitDTO updateProductV2(@PathVariable("id")long id,@RequestParam(name = "libelle",required = false) String libelle,@RequestParam(name = "quantite",required = false) int quantite,@RequestParam(name = "prixUnitaire",required = false) double prixUnitaire,@RequestParam(name="idCategory",required=false)long idCategory){
        return produitService.updateProduitV2(new ProduitDTO(id,libelle,quantite,prixUnitaire),idCategory);
    }
}
