package org.togo.rikCorpSolution.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.togo.rikCorpSolution.entities.Categorie;
import org.togo.rikCorpSolution.entities.Produit;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	@Query("SELECT cat FROM Categorie cat WHERE cat.libelle=:x")
	public Categorie findByLibelle(@Param("x")String libelle);
	
	@Query("SELECT cat FROM Categorie cat ORDER BY cat.libelle")
	public List<Categorie> displayAllCategories();

	@Query("SELECT cat FROM Categorie cat WHERE cat.libelle like %:x% ORDER BY cat.libelle")
	public List<Categorie> searchByKeyword(@Param("x")String libelle);


}
