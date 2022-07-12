package com.aazaykov.artplancomtest.Repositories;

import com.aazaykov.artplancomtest.Entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
