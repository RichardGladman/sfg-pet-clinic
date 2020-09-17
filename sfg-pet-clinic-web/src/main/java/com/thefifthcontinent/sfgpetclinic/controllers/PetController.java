package com.thefifthcontinent.sfgpetclinic.controllers;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.model.PetType;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import com.thefifthcontinent.sfgpetclinic.services.PetService;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;
import java.util.Collection;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{id}")
@RequiredArgsConstructor
public class PetController {
    
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;
    
    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }
    
    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long id) {
        return ownerService.findById(id);
    }
    
    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }
    
    @GetMapping("/pets/new")
    public String initNewForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }
    
    @GetMapping("/pets/{petId}/edit")
    public String initEditForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return "pets/createOrUpdatePetForm";
    }
    
    @PostMapping("/pets/new")
    public String processNewForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        
        owner.addPet(pet);
        
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }
        
        petService.save(pet);
        return "redirect:/owners/" + owner.getId();
    }
    
    @PostMapping("/pets/{petId}/edit")
    public String processEditForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }
        
        owner.addPet(pet);
        petService.save(pet);

        return "redirect:/owners/" + owner.getId();
    }
}
