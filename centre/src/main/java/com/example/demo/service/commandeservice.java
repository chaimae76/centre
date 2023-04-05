package com.example.demo.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.example.demo.service.commandeservice;
import com.example.demo.entities.commande;
@Service
public interface commandeservice {
	
	    	List<commande> getAllcommande();
	    	 
	    	 commande savecommande(commande commande);
	    	 
	    	 public void registercommande(commande commande);
	     }


