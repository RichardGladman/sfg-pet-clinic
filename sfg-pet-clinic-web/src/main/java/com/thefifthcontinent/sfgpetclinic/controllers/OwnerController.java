package com.thefifthcontinent.sfgpetclinic.controllers;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        super();
        this.ownerService = ownerService;
    }

    @InitBinder
    public void disallowedFields(WebDataBinder binder) {

        binder.setDisallowedFields("id");

    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView show(@PathVariable("ownerId") Long ownerId) {

        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;

    }

    @GetMapping
    public String find(Owner owner, BindingResult result, Model model) {

        if (owner.getSurname() == null) {
            owner.setSurname("");
        }

        List<Owner> owners = ownerService.findBySurnameContainingIgnoreCase(owner.getSurname());

        if (owners.isEmpty()) {
            result.rejectValue("Surname", "notFound", "not found");
            return "owners/findOwners";
        }

        if (owners.size() == 1) {
            owner = owners.iterator().next();
            return "redirect:/owners/" + owner.getId();
        }

        model.addAttribute("selections", owners);
        return "owners/ownersList";
    }

    @GetMapping("/new")
    public String initNewForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/form";
    }

    @PostMapping("/new")
    public String processNewForm(@Valid Owner owner, BindingResult result) {

        if (result.hasErrors()) {
            return "owners/form";
        }

        return "redirect:/owners/" + ownerService.save(owner).getId();
    }
    
    @GetMapping("{id}/edit")
    public String initEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/form";
    }

    @PostMapping("/{id}/edit")
    public String processEditForm(@Valid Owner owner, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "owners/form";
        }

        owner.setId(id);
        return "redirect:/owners/" + ownerService.save(owner).getId();
    }
}
