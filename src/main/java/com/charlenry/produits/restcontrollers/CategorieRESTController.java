package com.charlenry.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.charlenry.produits.dto.ProduitDTO;
import com.charlenry.produits.entities.Categorie;
import com.charlenry.produits.repos.CategorieRepository;

@RestController
@CrossOrigin("*")  // pour autoriser n'importe quel client
public class CategorieRESTController {
	
	@Autowired
	CategorieRepository categorieRepository;
	
	// Get all categories
	@GetMapping("/api/cat")
	public List<Categorie> getAllProduits() {
		return categorieRepository.findAll();
	}
	
	// Get a category by ID
		@GetMapping("/api/cat/{idCat}")
		public Categorie getCategorieById(@PathVariable("idCat") Long id) {
			return categorieRepository.findById(id).get();
		}
}
