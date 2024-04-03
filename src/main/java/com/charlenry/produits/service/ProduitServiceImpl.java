package com.charlenry.produits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlenry.produits.dto.ProduitDTO;
import com.charlenry.produits.entities.Categorie;
import com.charlenry.produits.entities.Produit;
import com.charlenry.produits.repos.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public ProduitDTO getProduit(Long id) {
		return convertEntityToDto(produitRepository.findById(id).get());
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		return produitRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ProduitDTO convertEntityToDto(Produit produit) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
		return produitDTO;
		
		
		/* ProduitDTO produitDTO = new ProduitDTO();
		produitDTO.setIdProduit(produit.getIdProduit());
		produitDTO.setNomProduit(produit.getNomProduit());
		produitDTO.setPrixProduit(produit.getPrixProduit());
		produitDTO.setDateCreation(produit.getDateCreation());
		produitDTO.setCategorie(produit.getCategorie());
		return produitDTO; */
		
	
		/* return ProduitDTO.builder()
				.idProduit(produit.getIdProduit())
				.nomProduit(produit.getNomProduit())
				.prixProduit(produit.getPrixProduit())
				.dateCreation(produit.getDateCreation())
				.categorie(produit.getCategorie())
				.nomCat(produit.getCategorie().getNomCat())
				.build(); */
		
	}

	@Override
	public Produit convertDtoToEntity(ProduitDTO produitDto) {
		Produit produit = new Produit();
		
		produit = modelMapper.map(produitDto, Produit.class);
		return produit;
		
		/* produit.setIdProduit(produitDto.getIdProduit());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixProduit(produitDto.getPrixProduit());
		produit.setDateCreation(produitDto.getDateCreation());
		produit.setCategorie(produitDto.getCategorie());
		return produit; */
	}



}
