package com.example.demo.controllers;

import com.example.demo.models.CategorieProduit;
import com.example.demo.models.Produit;
import com.example.demo.models.ProduitViewModel;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.CategorieService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class ProduitsController {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ProduitService produitService;

    @Autowired
    CategorieService categorieService;

   @GetMapping("/Panel")
   public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
       //**
       Pageable sortedById = PageRequest.of(page, 4, Sort.by("idProduit").ascending());
       //**
       model.addAttribute("data",
               countryRepository.findAll(PageRequest.of(page, 4))
               produitService.findAll(sortedById)
       );
       model.addAttribute("currentPage", page);
       return "index";
   }

   @PostMapping("/save")
   public String save(Produit country) {
       produitRepository.save(country);
       return "redirect:/";
   }

   @GetMapping("/delete")
   public String deleteCountry(Integer id) {
       produitRepository.deleteById(id);
       return "redirect:/";
   }

   @GetMapping("/findOne")
   @ResponseBody
   public Produit findOne(Integer id) {
       return produitRepository.findById(id).get();
   }

    @RequestMapping(value = "/Panel", method = RequestMethod.GET)
    public ModelAndView showPage(@RequestParam(defaultValue = "0") int page) {
        Pageable sortedById = PageRequest.of(page, 4, Sort.by("idProduit").ascending());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", produitService.findAll(sortedById));
        modelAndView.addObject("listCategorie", categorieService.listAll());
        modelAndView.addObject("currentPage", page);
        modelAndView.setViewName("GestionProduits");
        return modelAndView;
    }

    public static String uploadDirectory = System.getProperty("user.dir") + "/ImageProduct";

    public void EnregistrerImage(MultipartFile file) {
        StringBuilder fileName = new StringBuilder();
//        for (MultipartFile file : files) {

            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileName.append(file.getOriginalFilename() + " ");
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }

    // Fontionne
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequestMapping(value=("/save"),headers=("content-type=multipart/*"),method=RequestMethod.POST)
    public String save(@RequestParam("cheminImage") MultipartFile cheminImage/*, Produit produit*/) {
//        System.out.println("nom fichier : " + cheminImage.getOriginalFilename());
        this.EnregistrerImage(cheminImage);

//        produitRepository.save(produit);
        return "redirect:/Panel";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCountry(Integer id) {
        produitRepository.deleteById(id);
        return "redirect:/Panel";
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    @ResponseBody
    public ProduitViewModel findOne(Integer id) {
        ProduitViewModel produitViewModel = new ProduitViewModel();
        produitViewModel.Copie(produitRepository.findById(id).get());
        return produitViewModel;
    }

    //TODO deleteME
    @RequestMapping("/remplire")
    public String remplissageHome() {
        produitService.remplirProduits();
        return "redirect:/Panel";
    }
}
