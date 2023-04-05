package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.produit;
import com.example.demo.entities.rendezVous;
@Repository
public interface  produitrepository extends JpaRepository<produit, Integer> {
 //public produit findByname(String nom);
	
	


}
