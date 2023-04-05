package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class client {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 private String nom;
	 private String prenom;
	 private String address;
	 private int  tele;
	 private String email;
	 
}
