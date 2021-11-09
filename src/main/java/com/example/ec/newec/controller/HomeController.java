package com.example.ec.newec.controller;

import com.example.ec.newec.repo.Customer;
import com.example.ec.newec.repo.Status;
import com.example.ec.newec.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final CustomerService service;
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("greeting", "Welcome to MyKart");
        model.addAttribute("customer", service.getAllCustomerByStatus(Status.NEW));
        return "index";
    }
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer, Model model){
        service.createCustomer(customer);
        model.addAttribute("customer",customer);
        return "thankyou";
    }
    @GetMapping("/add")
    public String createCustomer(@ModelAttribute Customer customer, Model model){
        model.addAttribute("customer", customer);
        return "Add";
    }

}
