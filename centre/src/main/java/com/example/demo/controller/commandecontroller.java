package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.commande;
import com.example.demo.entities.produit;
import com.example.demo.entities.rendezVous;
import com.example.demo.service.CommandService;
import com.example.demo.service.CommandeSer;
import com.example.demo.service.ProduitService1;
import com.example.demo.service.commandeservice;
import com.example.demo.repository.commanderepository;
import jakarta.servlet.http.HttpSession;
@Controller
public class commandecontroller {
	@Autowired
	private CommandService cmdService;
	private commandeservice service;
	private CommandeSer CmdS;
	@Autowired
	private commanderepository commanderepository;
    @GetMapping("/commandes")
    public String getAllCommande(Model model) {
    	List<commande> lsCmd = this.cmdService.findAllCommande();
        model.addAttribute("commandes", lsCmd);
        return "commandes";
    }
    @GetMapping("/ajoutercommande")
    public String register(Model model) {
    	commande cmd = new commande();
    	model.addAttribute("commande",cmd);
    	return"ajoutercommande";
    }
    @PostMapping("/ajoutercommande")
    public String ajoutercommande(@ModelAttribute commande commande, HttpSession session, RedirectAttributes redirectAttributes) {
        commanderepository.save(commande);
        
        if (commande.getId() != 0) {
            redirectAttributes.addFlashAttribute("message", "Commande bien enregistré");
        }
        
        return "redirect:ajoutercommande";
    }

    @GetMapping("/updateCommandePage/{id}")
    
   
    public String showupdateproduit(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<commande> pr = commanderepository.findById(id);
       commande commande  = pr.get();
        model.addAttribute("commande",commande);
        return "updateCommande";
    }

    @PostMapping("/updateCommande")
    public String updateComande(@ModelAttribute commande commande, RedirectAttributes redirectAttributes) {
        commanderepository.save(commande);
        redirectAttributes.addFlashAttribute("message", "Commande updated successfully!");
        return "redirect:/produits";
    }
@GetMapping("/updateCommande")
public String showUpdateCommande(Model model, HttpSession session) {
    model.addAttribute("update", "Commande mise à jour");
    String message = (String) session.getAttribute("message");
    if (message != null) {
        model.addAttribute("message", message);
        session.removeAttribute("message");
    }
    return "updateCommande";
}
    
    
    
    
    @GetMapping("/searchcommande")
    public String add(Model model) {
    	List<commande> pr = cmdService.ListAll();
    	model.addAttribute("commande",new commande());
    	
    	return"searchcommande";}
    @PostMapping("/searchcommande")
	public String dosearchcommande(@ModelAttribute("commandesearchFormDate") commande formData, Model model) {
	    commande prd = cmdService.getById(formData.getId());
	    if (prd == null) {
	        // Si l'objet est nul, afficher un message d'erreur
	        model.addAttribute("error", "Aucun commande trouvé pour l'ID spécifié");
	        return "searchcommande";
	    } else {
	        // Sinon, ajouter l'objet au modèle et afficher la vue appropriée
	        model.addAttribute("commande", prd);
	        return "searchcommande";
	    }
	}
    
    
    
    
   
    
    @GetMapping("/deleteCommande/{id}")
    public String deletecommande(@PathVariable("id") Integer id) {
    	commanderepository.deleteById(id);
    	return"redirect:/commandes";
    	
    }
    	
    }
    
    
    
    
    

	

