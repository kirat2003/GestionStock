package org.togo.rikCorpSolution.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.togo.rikCorpSolution.dtos.CategorieDTO;
import org.togo.rikCorpSolution.entities.Categorie;

@Service
public class CategorieMapperImplementation {
    public static CategorieDTO fromCategorie(Categorie categorie){
        CategorieDTO categorieDTO = new CategorieDTO();
        BeanUtils.copyProperties(categorie,categorieDTO);
        return categorieDTO;
    }

    public static Categorie fromCategorieDTO(CategorieDTO categorieDTO){
        Categorie categorie = new Categorie();
        BeanUtils.copyProperties(categorieDTO,categorie);
        return categorie;
    }
}
