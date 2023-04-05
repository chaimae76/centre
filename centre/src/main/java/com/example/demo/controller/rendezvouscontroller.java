package com.example.demo.controller;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
import com.example.demo.service.RendezService;
import com.example.demo.repository.rendez;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@Controller
public class rendezvouscontroller {
 
	@Autowired
	private RendezService rndService;
	@Autowired
	private rendez rendez;

    @GetMapping("/rendezvous")
    public String getAllCommande(Model model) {
    	List<rendezVous> lsCmd = this.rndService.findAllCommande();
        model.addAttribute("rendezvous", lsCmd);
        return "rendezvous";
    }
    @GetMapping("/ajouterrendezvous")
    
    public String ajouterRendezVous(Model model) {
    	rendezVous pr = new rendezVous();
    	model.addAttribute("rendezvous",pr);
    	return"ajouterrendezvous";
    }
   
	@PostMapping("/ajouterrendezvous")
    public String ajouterrendezvous(@ModelAttribute rendezVous rendezvous , HttpSession session, RedirectAttributes redirectAttributes) {
         rendez.save(rendezvous);
        
        if (rendezvous.getId() != 0) {
            redirectAttributes.addFlashAttribute("message", "Rendez-vous bien enregistré");
        }
        
        return "redirect:ajouterrendezvous";
    }
	
	 @GetMapping("/updaterendezvousPage/{id}")
	    public String showupdateproduit(@PathVariable("id") Integer id,Model model) {
	    	Optional<rendezVous> rd = rendez.findById(id);
	    	 rendezVous rendez = rd.get();
	    	model.addAttribute("rendezvous",rendez);
	    	
	    	return"/updaterendezVous";}
        	@GetMapping("/deleterendezvous/{id}")
        	public String deletecommande(@PathVariable("id") int id) {
        		rendez.deleteById(id);
        		return"redirect:/rendezvous";
        		
        	}
    
    	@GetMapping("/searchrandez")
    	public String add(Model model) {
    		List<rendezVous> pr = rndService.ListAll();
    		model.addAttribute("rendezvous",new rendezVous());
    		
    		return"searchrandez";}
    	@PostMapping("/searchrandez")
    	public String dosearchproduit(@ModelAttribute("rendezvoussearchFormDate") rendezVous formData, Model model) {
    	    rendezVous prd = rndService.getById(formData.getId());
    	    if (prd == null) {
    	        // Si l'objet est nul, afficher un message d'erreur
    	        model.addAttribute("error", "Aucun rendez-vous trouvé pour l'ID spécifié");
    	        return "searchrandez";
    	    } else {
    	        // Sinon, ajouter l'objet au modèle et afficher la vue appropriée
    	        model.addAttribute("rendezvous", prd);
    	        return "searchrandez";
    	    }
    	}
    	
}
