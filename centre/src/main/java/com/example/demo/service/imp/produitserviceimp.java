package com.example.demo.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.produitservice;
import com.example.demo.repository.produitrepository;
import com.example.demo.entities.produit;
import com.example.demo.service.imp.produitserviceimp;

@Service
public class produitserviceimp implements produitservice {
	@Autowired
	private produitrepository produitrepository;
	
public List<produit> getAllproduit(){
 return produitrepository.findAll();
 }
 @Override
 public void saveproduit(produit produit) {
	 produitrepository.save(produit);
	 
	 
	 
 }
}
