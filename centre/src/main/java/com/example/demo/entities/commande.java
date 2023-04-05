package com.example.demo.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class commande {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 private String cin;
	 private String nom;
	 private String prenom;
	 private String adresse;
	 private String email;
	 private String tele;
	 private int quantite;
	
	
}

