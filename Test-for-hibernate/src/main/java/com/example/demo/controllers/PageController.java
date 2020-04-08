package com.example.demo.controllers;

import com.example.demo.models.Individuu;
import com.example.demo.models.Pay;
import com.example.demo.models.Produit;
import com.example.demo.models.Sexe;
import com.example.demo.service.PaysService;
import com.example.demo.service.ProduitService;
import com.example.demo.service.SexeService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    UserService userService;

    @Autowired
    SexeService sexeService;

    @Autowired
    PaysService paysService;

    @Autowired
    ProduitService produitService;

//    @RequestMapping("/home/Produit?idP={id}")
//    public ModelAndView showProductPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("product");
//        Produit product = produitService.getProduit(id);
//        mav.addObject("product", product);
//
//        return mav;
//    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        Individuu user = new Individuu();
        modelAndView.addObject("user", user);
        modelAndView.addObject("paysList", paysService.findAll());
        List<Sexe> sexeList = (List<Sexe>) sexeService.findAll();
        modelAndView.addObject("sexeList", sexeList);
        modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid Individuu user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        // Check for the validations
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Veuillez corrigez les erreurs dans le formulaire!");
            modelMap.addAttribute("bindingResult", bindingResult);
        } else if (userService.isUserAlreadyPresent(user)) {
            modelAndView.addObject("successMessage", "=>Email déja existant , svp utilisez en un autre !");
        }
        // ajouter l'user dans la base de donnée si aucune erreur n'est intervenue ...
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
        }
        modelAndView.addObject("user", new Individuu());
        List<Pay> paysList = paysService.findAll();
        modelAndView.addObject("paysList", paysList);
        List<Sexe> sexeList = (List<Sexe>) sexeService.findAll();
        modelAndView.addObject("sexeList", sexeList);
        modelAndView.setViewName("register");
//        modelAndView.setViewName("/login?afterRegister=true");
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }


}

