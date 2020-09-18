/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thefifthcontinent.sfgpetclinic.controllers;

import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.services.PetService;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;
import java.beans.PropertyEditorSupport;
import java.time.LocalTime;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author richard
 */
@Controller
@RequiredArgsConstructor
public class VisitController {
    
    private final VisitService visitService;
    private final PetService petService;
    
    @InitBinder
    public void setAllowedFields(WebDataBinder binder) {
        binder .setDisallowedFields("id");
        
        binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalTime.parse(text));
            }
        });
    }
    
    @ModelAttribute("visit")
    public Visit loadVisitForPet(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        Visit visit = new Visit();
        pet.addVisit(visit);
        model.addAttribute("pet", pet);
        return visit;
    }
    
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model) {
        return "pets/createOrUpdateVisitForm";
    }
    
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }
        
        visitService.save(visit);
        return "redirect:/owners/{ownerId}";
    }
    
}
