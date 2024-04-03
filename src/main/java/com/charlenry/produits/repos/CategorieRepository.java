package com.charlenry.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.charlenry.produits.entities.Categorie;

// fournit toutes les API standard pour l'entité Catégorie dont l'endpoint fini par /cat
// http://localhost:8080/produits/cat
@RepositoryRestResource(path = "cat")  
//pour autoriser angular ; en l'absence de cette annotation, on obtient une erreur cors
@CrossOrigin("http://localhost:4200") 
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
}
