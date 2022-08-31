package org.togo.rikCorpSolution.dtos;

import java.util.List;

public class CategoryHistoryDTO {
    private long id;
    private String libelle;
    private int currentPage;
    private int totalPages;
    private int sizePages;
    List<ProduitDTO> produitDTOS;

    public CategoryHistoryDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProduitDTO> getProduitDTOS() {
        return produitDTOS;
    }

    public void setProduitDTOS(List<ProduitDTO> produitDTOS) {
        this.produitDTOS = produitDTOS;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getSizePages() {
        return sizePages;
    }

    public void setSizePages(int sizePages) {
        this.sizePages = sizePages;
    }
}
