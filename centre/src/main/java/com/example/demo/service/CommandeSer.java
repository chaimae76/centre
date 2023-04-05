package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.commande;
import com.example.demo.repository.commanderepository;

@Service
public class CommandeSer {
@Autowired
private commanderepository cmdr;
public void savecmd(commande commande) {
	cmdr.save(commande);
	
	
	
}
}
