package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.commande;
import com.example.demo.entities.produit;
import com.example.demo.service.CommandService;
import com.example.demo.service.ProduitService1;
import com.example.demo.service.produitservice;
import com.example.demo.repository.produitrepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class produitcontroller {
private produitservice produitservice;
@Autowired
private ProduitService1 cmdService;
@Autowired
private produitservice produitService1;
@Autowired
private produitrepository produitrepository;
@Autowired
private produitservice prd;
@GetMapping("/pr")
public String getAllCommande(Model model) {
	List<produit> lspr = this.cmdService.findAllCommande();
    model.addAttribute("produit", lspr);
	return"pr";
}
@GetMapping("/ajouterproduit")
public String ajouterproduit(Model model) {
	produit pr = new produit();
	model.addAttribute("produit",pr);
	return"ajouterproduit";
}

@Autowired
private ProduitService1 produitService;

@PostMapping("/ajouterproduit")
public String ajouterproduit(@ModelAttribute produit produit, HttpSession session, RedirectAttributes redirectAttributes) {
    produitrepository.save(produit);
    
    if (produit.getId() != 0) {
        redirectAttributes.addFlashAttribute("message", "Produit bien enregistre!!!!");
    }
    
    return "redirect:ajouterproduit";
}


@GetMapping("/updateproduitPage/{id}")
public String showupdateproduit(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    Optional<produit> pr = produitrepository.findById(id);
    produit produit  = pr.get();
    model.addAttribute("produit",produit);
    return "updateproduit";
}

@PostMapping("/updateproduit")
public String updateproduit(@ModelAttribute produit produit, RedirectAttributes redirectAttributes) {
    produitrepository.save(produit);
    redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
    return "redirect:/produits";
}

@GetMapping("/deleteproduit/{id}")
public String deletecommande(@PathVariable("id") int id) {
	produitrepository.deleteById(id);
	return"redirect:/pr";
	
}
@GetMapping("/search")
public String add(Model model) {
	List<produit> pr = cmdService.ListAll();
	model.addAttribute("produit",new produit());
	return"search";}
@PostMapping("/search")
	public String dosearchproduit(@ModelAttribute("commandesearchFormDate") commande formData, Model model) {
	    produit prd = cmdService.getById(formData.getId());
	    if (prd == null) {
	        // Si l'objet est nul, afficher un message d'erreur
	        model.addAttribute("error", "Aucun produit trouvé pour l'ID spécifié");
	        return "search";
	    } else {
	        // Sinon, ajouter l'objet au modèle et afficher la vue appropriée
	        model.addAttribute("produit", prd);
	        return "search";
	    }
	}
   
}
