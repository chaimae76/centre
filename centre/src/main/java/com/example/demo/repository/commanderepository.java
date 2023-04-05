package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.commande;
@Repository
public interface commanderepository extends JpaRepository<commande, Integer>{

}
