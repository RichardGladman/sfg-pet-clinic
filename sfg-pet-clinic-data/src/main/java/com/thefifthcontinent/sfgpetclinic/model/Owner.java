package com.thefifthcontinent.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Owners")
public class Owner extends Person {

    private static final long serialVersionUID = 1L;

    @Builder
    public Owner(Long id, String givenName, String surname, String address, String city, String phoneNumber, Set<Pet> pets) {
        super(id, givenName, surname);
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;

    public void addPet(Pet pet) {
        if (null == pets) {
            pets = new HashSet<>();
        }

        pet.setOwner(this);
        pets.add(pet);
    }
    
    public Pet getPet(String name, boolean ignoreNew) {
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                if (pet.getName().equalsIgnoreCase(name)) {
                    return pet;
                }
            }
        }
        
        return null;
    }

}
