package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.commanderepository;
import com.example.demo.entities.commande;
import com.example.demo.entities.produit;
import com.example.demo.entities.rendezVous;

@Service
public class CommandService {
	@Autowired
	private commanderepository cmdRepo;
	public List<commande> findAllCommande(){
		return cmdRepo.findAll();
	}
public List<commande> ListAll(){
		
		return cmdRepo.findAll();
	}
	
	
	public commande get(Integer i) {
		
		return cmdRepo.findById(i).get();
	}
	public commande getById(int id) {
		return cmdRepo.findById(id).orElse(null);
	}
}
