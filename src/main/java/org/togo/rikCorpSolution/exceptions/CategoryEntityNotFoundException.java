package org.togo.rikCorpSolution.exceptions;

public class CategoryEntityNotFoundException extends Throwable {
    public CategoryEntityNotFoundException(String categorie_not_found) {
        super(categorie_not_found);
    }
}
