package com.example.demo.service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.rendez;
import com.example.demo.entities.commande;
import com.example.demo.entities.rendezVous;
@Service
public class RendezService {

    @Autowired
    private rendez rendez;
    
    public List<rendezVous> findAllCommande(){
        return rendez.findAll();
    }
    
    public List<rendezVous> ListAll(){    
        return rendez.findAll();
    }
    
    public rendezVous get(Integer i) {    
        return rendez.findById(i).get();
    }
    
    public rendezVous getById(Integer id) {
        return rendez.findById(id).orElse(null);
    }
}

