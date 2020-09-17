package com.thefifthcontinent.sfgpetclinic.controllers;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.model.PetType;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import com.thefifthcontinent.sfgpetclinic.services.PetService;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService service;

    @InjectMocks
    PetController controller;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;

    @BeforeEach
    protected void setUp() throws Exception {

        owner = Owner.builder().id(1L).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Cat").build());
        petTypes.add(PetType.builder().id(2L).name("Dog").build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void initNewForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));

        verifyNoInteractions(service);
    }

    @Test
    void initEditForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(service.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processNewForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(service).save(any());
    }

    @Test
    void processEditForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(service).save(ArgumentMatchers.any());
    }

}
