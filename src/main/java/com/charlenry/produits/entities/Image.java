package com.charlenry.produits.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
//import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;

@Entity
/**
 * `@Builder` is a Lombok annotation that generates a builder for the annotated class. 
 * This builder pattern allows you to create instances of the class with a fluent API style, making it easier to 
 * construct objects with many attributes. The generated builder class provides methods to set values for each 
 * attribute and then build the object with those values. This can be particularly useful when dealing with classes 
 * that have a large number of fields or when you want to create immutable objects with a convenient way to initialize 
 * them.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_image")
	private Long idImage;
	private String name;
	private String type;
	
	@Column(name = "IMAGE", length = 4048576)  // la valeur de length équivaut à Medium LOB
	@Lob  // BLOB : Binary Large Object (permet de stocker en autres les images)
	private byte[] image;

	//@OneToOne
	//private Produit produit;
}