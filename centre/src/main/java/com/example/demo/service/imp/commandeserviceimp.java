
 package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.commandeservice;
import com.example.demo.repository.commanderepository;
import com.example.demo.entities.commande;
@Service
public class commandeserviceimp implements commandeservice {
@Autowired
    private final commanderepository commanderepository;

    public commandeserviceimp(commanderepository commanderepository) {
        this.commanderepository = commanderepository;
    }

    @Override
    public List<commande> getAllcommande() {
        return commanderepository.findAll();
    }

    @Override
    public commande savecommande(commande commande) {
        return commanderepository.save(commande);
    }
    @Override
    public void registercommande(commande commande) {
    	commanderepository.save(commande);
    	
    }
    
}