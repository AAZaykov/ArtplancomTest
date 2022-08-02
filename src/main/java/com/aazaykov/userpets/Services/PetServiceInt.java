package com.aazaykov.userpets.Services;

import com.aazaykov.userpets.Entities.Pet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PetServiceInt {
    Pet createPet(Pet pet, HttpServletRequest request);
    void editPet(Long id, String type, String date, String gender, String nickName);
    void deletePet(Long id);
    List<Pet> allPets();
    Pet getPetById(Long id);
}
