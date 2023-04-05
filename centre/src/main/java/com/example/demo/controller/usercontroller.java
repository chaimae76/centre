package com.example.demo.controller;




import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.user;
import com.example.demo.entities.commande;
import com.example.demo.entities.produit;
import com.example.demo.entities.rendezVous;
import com.example.demo.repository.produitrepository;
import com.example.demo.repository.rendez;
import com.example.demo.repository.userRepository;
import com.example.demo.service.commandeservice;
import com.example.demo.service.produitservice;
import com.example.demo.service.userservice;

import io.micrometer.common.util.StringUtils;

@Controller
public class usercontroller {
	@Autowired
	 private userservice userservice;
	private produitservice pr;
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user",new user());
		return mav;
		
	}
@PostMapping("/login")
public String login(@ModelAttribute("user") User user) {
	user oauthuser= userservice.login(user.getUsername(),user.getPassword());
	System.out.print(oauthuser);
	if(Objects.nonNull(oauthuser)) { return "redirect:/pageadmin";}
	else {
		return"redirect:/login";
	}
	
}
@GetMapping("/")
public String index() {
	   
	   return "ind";
	   
}
	
	@GetMapping("/produits")
	   public String produits() {
		   
		   return "produits";
		   
	   }
	
	@GetMapping("/pageadmin")
	   public String pageadmin() {
		   
		   return "pageadmin";
		   
	   }
	
	//@GetMapping("/ajouterproduit")
	  // public String ajouterp1(Model model) {
		//model.addAttribute("produit", p);
		 //  return "/";
	  // }@Autowired
	  // private produit p;
	
	
	@GetMapping("/reserver")
	   public String reserver(Model model) {
		rendezVous rendezVous = new rendezVous();
		model.addAttribute("rendezVous", rendezVous);
		
		   return "reserver";
		   
	   }
	
	@Autowired
	private rendez rend;
	@PostMapping("/reserver")
	public String reserver(@ModelAttribute rendezVous rendezVous, Model model) {
		String dateR = rendezVous.getDateR();
	    List<rendezVous> reservations =   (List<com.example.demo.entities.rendezVous>) rend.findBydateR(dateR);
	    if (!reservations.isEmpty()) {
	        model.addAttribute("error", "Cette date est déjà réservée.");
	    }
	    
	    // Save the reservation
	    else { rend.save(rendezVous);
	    model.addAttribute("success", "votre reservation et bien enregistrer");}
	    return"reserver";
	}
	@GetMapping("erreur")
	   public String erreur() {
		   
		   return "erreur";}
	@GetMapping("message")
	   public String message() {
		   
		   return "massegeS";}
    
	@GetMapping("/service")
	   public String service() {
		   
		   return "service";
		   
	   }
	@GetMapping("/acheter")
	   public String acheter(Model model) {
		commande commande = new commande();
		model.addAttribute("commande",commande);
		
		   return "acheter";
		   
	   } //@Autowired
	   // private commandeservice commandeService;
	    
	  // @PostMapping("/acheter")
	   // public  String creerCommande(@RequestBody commande commande) throws Exception {
	    //    try {
	         //   commandeService.creerCommande(commande);
	           
	           // return "redirect:/";
	       // }  catch (IllegalArgumentException e) {
	         //
	        
	    
	
	        @GetMapping("/mesproduits")
		 	   public String mesproduits() {
		 		   return "mesproduits";
		    }
	
	
	        @GetMapping("admin")
	 	   public String produitS() {
	 		   
	 		   return "savep";}

	        @GetMapping("details")
		 	   public String details() {
		 		   
		 		   return "details";}
	        
	        @GetMapping("/ajouterendezvous")
	        public String ajouterrendezvous() {
	      	 return("ajouterrendezvous");
	       }
	        

}
