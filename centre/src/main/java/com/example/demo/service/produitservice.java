package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.produit;
import com.example.demo.repository.produitrepository;
@Service
public interface produitservice {

	@Autowired
	 //private  produitrepository produitrepository;
	public void  saveproduit(produit produit);
	
	
	
 }

