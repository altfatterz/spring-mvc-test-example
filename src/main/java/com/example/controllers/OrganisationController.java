package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrganisationController {

    @RequestMapping(value = "/org/{id}", method = RequestMethod.GET)
    public String getOrganisation(@PathVariable String id, Model model) {
        Organisation org = new Organisation();
        org.setName("Pothuys");
        model.addAttribute("org", org);
        return "org";
    }
}
