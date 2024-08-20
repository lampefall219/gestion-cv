package com.projet1.projet.services;


import com.projet1.projet.model.Test;
import com.projet1.projet.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;
    public List<Test> getAll(){
        return testRepository.findAll();
    }
    public  void  saveTest(Test t){
        testRepository.save(t);
    }
    public Optional<Test> getTesteById(Long id){
        return testRepository.findById(id);
    }
    public void deleteTest(Long id){
       testRepository.deleteById(id);
    }

}
