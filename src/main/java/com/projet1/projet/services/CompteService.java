package com.projet1.projet.services;

import com.projet1.projet.model.Compte;
import com.projet1.projet.model.Test;
import com.projet1.projet.repository.CompteRepository;
import com.projet1.projet.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;
    public List<Compte> getAll(){
        return compteRepository.findAll();
    }
    public  void  saveCompte(Compte compte){
        compteRepository.save(compte);
    }
    public Optional<Compte> getCompteById(Long id){
        return compteRepository.findById(id);
    }
    public void deleteCompte(Long id){
        compteRepository.deleteById(id);
    }
    public boolean existe(String login,String pwd){
        boolean condtion=false;
       Compte compte= compteRepository.findByEmail(login,pwd);
       if (compte!=null){
           condtion=true;
           return true;
       }else {
           return condtion;
       }
    }
}
