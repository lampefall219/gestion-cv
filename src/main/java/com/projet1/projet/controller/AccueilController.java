package com.projet1.projet.controller;

import com.projet1.projet.model.Compte;
import com.projet1.projet.model.Inscription;
import com.projet1.projet.model.Utilisateur;
import com.projet1.projet.repository.UtilisateurRepository;
import com.projet1.projet.services.CompteService;
import com.projet1.projet.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;


@Controller
@RequestMapping("/compte")
public class AccueilController {

    @Autowired
    private CompteService compteService;
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("/")
    public String getInfo(Model model){
        model.addAttribute("activePage", "index");
        return "index";
    }
    @GetMapping("/new")
    public String createUtilisateurForm(Model model) {
        model.addAttribute("compte", new Compte());
        return "compte/inscription";

    }
    @GetMapping("/login")
    public String connexion(Model model) {
        model.addAttribute("compte", new Compte());
        return "compte/login";
    }
    @PostMapping("/add")
    public String login(@RequestParam("email") String email,@RequestParam("password") String password, RedirectAttributes redirectAttributes,Model model, @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size) {
       String mailadmin="lolampe91@gmail.com";
       String pwd="123";
        Utilisateur utilisateur1 = utilisateurService.existe(email);
        if(mailadmin == email && password ==pwd){
            Pageable pageable = PageRequest.of(page, size);
            Page<Utilisateur> userPage = utilisateurService.findAll(pageable);
            model.addAttribute("userPage", userPage);
            return "utilisateur/index";

        } else if (!compteService.existe(email,password)) {
           // model.addAttribute("compte", new Compte()); // Formulaire d'inscription si l'utilisateur n'existe pas
            redirectAttributes.addFlashAttribute("error", "Email OU Mot de passe incorrect !!!!.");
            return "redirect:/";
        } else if (utilisateur1!=null) {
            model.addAttribute("utilisateur",utilisateur1 ); // Formulaire d'inscription si l'utilisateur n'existe pas
                    return "utilisateur/afficher";
        } else {
            Utilisateur utilisateur = new Utilisateur();

            utilisateur.setEducations(new ArrayList<>());
            utilisateur.setExperiences(new ArrayList<>());
            utilisateur.setQualifications(new ArrayList<>());
            utilisateur.setLanguages(new ArrayList<>());
            utilisateur.setKnowledges(new ArrayList<>());
            utilisateur.setCentreInterets(new ArrayList<>());




            model.addAttribute("Utilisateur", new Utilisateur()); // Ajouter un objet formulaire de CV vide
            return "utilisateur/add"; // Vue du formulaire de création de CV
        }

    }
    @PostMapping
    public String saveUser(@ModelAttribute("compte") Compte compte, RedirectAttributes redirectAttributes) {
        boolean test = compteService.existe(compte.getEmail(),compte.getPassword());
        if (test){
            redirectAttributes.addFlashAttribute("error", "vous avez deja un compte.");
            return "redirect:/";
        }else {
            compteService.saveCompte(compte);
            redirectAttributes.addFlashAttribute("success", "Inscription réussie! Vous pouvez maintenant vous connecter.");
            return "redirect:/";
        }

    }
}
