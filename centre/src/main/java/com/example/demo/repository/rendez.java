package com.example.demo.repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.user;
import com.example.demo.entities.rendezVous;
@Controller
public interface rendez extends JpaRepository<rendezVous, Integer> {
	
	List<rendezVous> findBydateR(String dateR);
List<rendezVous> findByServiceAndDateR(String service, String date);
List<rendezVous> findByDateR(String date);
}





