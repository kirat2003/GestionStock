package org.togo.rikCorpSolution.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.togo.rikCorpSolution.entities.Produit;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query("SELECT p FROM Produit p ORDER BY p.libelle")
    public List<Produit> displayAllProduct();
    @Query("SELECT p FROM Produit p WHERE p.libelle=:x")
    public Produit findByLibelle(@Param("x")String libelle);
    @Query("SELECT p FROM Produit p,Categorie c WHERE c.id=:id AND c.id=p.categorie.id")
    public List<Produit> displayAllProductByCategorieId(@Param("id")long idCategorie);
    @Query("DELETE FROM Produit p WHERE p.libelle=:x")
    public void deleteByLibelle(@Param("x")String libelle);

    @Query("SELECT p FROM Produit p,Categorie c WHERE p.categorie.id=c.id and c.id=:x")
    Page<Produit> findProductByCat(@Param("x") long id, Pageable pageable);
}
