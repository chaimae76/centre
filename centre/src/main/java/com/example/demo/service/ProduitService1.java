package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.commande;
import com.example.demo.entities.produit;
import com.example.demo.repository.produitrepository;

@Service
public class ProduitService1 {
	@Autowired
	private produitrepository prresp;
	public List<produit> findAllCommande(){
		return prresp.findAll();
	}
	public List<produit> ListAll(){
		
		return prresp.findAll();
	}
	
	
	public produit get(Integer id) {
		
		return prresp.findById(id).get();
	}
	public produit getById(int id) {
		return prresp.findById(id).orElse(null);
	}
	
	
	
	
}
