package com.projet1.projet.controller;


import com.projet1.projet.model.Test;
import com.projet1.projet.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String listTest(Model model) {

        List<Test> tests = testService.getAll();
        model.addAttribute("tests", tests);
        return "test/index";
    }

    @GetMapping("/new")
    public String createTestForm(Model model) {
        model.addAttribute("teste", new Test());
        return "test/add";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("teste") Test test) {
        testService.saveTest(test);
        return "redirect:/test/";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Optional<Test> optionalTest = testService.getTesteById(id);
        if (optionalTest.isPresent()) {
            model.addAttribute("teste", optionalTest.get());
            return "test/edit";
        } else {
            model.addAttribute("errorMessage", "Product not found");
            return "error";
        }
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("test") Test test) {
        Optional<Test> optionalTest = testService.getTesteById(id);
        if (optionalTest.isPresent()) {
            Test existingTest = optionalTest.get();
            existingTest.setNom(test.getNom());

            testService.saveTest(existingTest);
            return "redirect:/test/";
        } else {
            // Handle the case when the product is not found
            return "redirect:/test/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable Long id) {
        Optional<Test> optionalTest = testService.getTesteById(id);
        if (optionalTest.isPresent()) {
            testService.deleteTest(id);
        } else {
            // Handle the case when the product is not found
            // Optionally add a message or redirect
        }
        return "redirect:/test/";
    }
}


