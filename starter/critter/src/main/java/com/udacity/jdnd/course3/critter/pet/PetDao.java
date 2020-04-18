package com.udacity.jdnd.course3.critter.pet;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDao extends JpaRepository<PetEntity, Long> {

	public List<PetEntity> findAllByOwnerId(Long ownerId);
}
