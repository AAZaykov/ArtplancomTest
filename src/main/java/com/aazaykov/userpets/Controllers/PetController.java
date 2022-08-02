package com.aazaykov.userpets.Controllers;

import com.aazaykov.userpets.Entities.Pet;
import com.aazaykov.userpets.Services.PetService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet, HttpServletRequest request){
        petService.createPet(pet, request);
        return pet;
    }

    @PutMapping("/{id}")
    public void editPet(@PathVariable Long id, String type, String date, String gender, String nickName){
        petService.editPet(id, type, date, gender, nickName);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id){
        petService.deletePet(id);
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id){
        return petService.getPetById(id);
    }

    @GetMapping("/my")
    public List<Pet> getMyPets(HttpServletRequest request){
        return petService.getMyPets(request);
    }

}