package com.aazaykov.artplancomtest.Services;

import com.aazaykov.artplancomtest.Entities.Gender;
import com.aazaykov.artplancomtest.Entities.Pet;
import com.aazaykov.artplancomtest.Entities.PetType;
import com.aazaykov.artplancomtest.Entities.User;
import com.aazaykov.artplancomtest.Exceptions.PetNotFoundException;
import com.aazaykov.artplancomtest.Repositories.PetRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService implements PetServiceInt{

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("User");
        pet.setOwnerName(user.getUsername());
        return petRepository.save(pet);
    }

    @Override
    public void editPet(Long id, String type, String date, String gender, String nickName) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        Pet pet = null;
        if (optionalPet.isPresent()){
            pet = optionalPet.get();
        }
        pet.setType(PetType.valueOf(type));
        try {
            pet.setBirthday(new SimpleDateFormat("dd-MM-yyyy").parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        pet.setPetGender(Gender.valueOf(gender));
        pet.setName(nickName);
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> allPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet with id " + id + " is not found"));
    }

    public List<Pet> getMyPets(HttpServletRequest request){
        List<Pet> allPets = allPets();
        List<Pet> myPets = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("User");
        for (Pet pet : allPets
             ) {

            if (pet.getOwnerName().equals(user.getUsername())){
                myPets.add(pet);
            }
        }
        return myPets;
    }
}