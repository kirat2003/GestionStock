package org.togo.rikCorpSolution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.togo.rikCorpSolution.dtos.CategorieDTO;
import org.togo.rikCorpSolution.dtos.CategoryHistoryDTO;
import org.togo.rikCorpSolution.exceptions.CategoryEntityNotFoundException;
import org.togo.rikCorpSolution.services.CategorieService;

import java.util.List;

@RestController
@RequestMapping(path = "/API/V1/Category")
@CrossOrigin("*")
public class CategorieAPI {
    private final CategorieService categorieService;

    @Autowired
    public CategorieAPI(CategorieService categorieService){
        this.categorieService=categorieService;
    }

    @GetMapping(path = "/categories")
    public List<CategorieDTO>displayAllCategories(){
        return categorieService.afficherAll();
    }
    @GetMapping(path = "/categories/{id}/produits")
    public CategoryHistoryDTO displayAllProduitPaged (@PathVariable("id") long id,@RequestParam(name = "page")int page,@RequestParam(name = "size")int size) throws CategoryEntityNotFoundException {
        return categorieService.getProductPaged(id,page,size);
    }
    @GetMapping(path = "/categories/search")
    public List<CategorieDTO>searchCategories(@RequestParam(name = "keyword",defaultValue = "")String keyword){
        return categorieService.rechercherByKeyWord(keyword);
    }
    @GetMapping(path = "/GetCategorieById/{id}")
    public CategorieDTO displayOneCategoryById(@PathVariable("id")long id){
        return categorieService.rechercherById(id);
    }
    @GetMapping(path = "/GetCategorieByLibelle/{libelle}")
    public CategorieDTO displayOneCategoryByLibelle(@PathVariable("libelle")String libelle){
        return categorieService.rechercherByLibelle(libelle);
    }

    @PostMapping(path = "/create")
    public CategorieDTO createCategorie(@RequestBody CategorieDTO categorieDTO){
        return categorieService.ajouter(categorieDTO);
    }
    @PutMapping(path = "/update/{id}")
    public CategorieDTO updateCategory(@PathVariable("id") long id,@RequestBody CategorieDTO categorieDTO){
        categorieDTO.setId(id);
        return categorieService.updateCategorie(categorieDTO);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCategory(@PathVariable("id") long id){
        categorieService.supprimer(id);
    }
}
