package com.udacity.jdnd.course3.critter.pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	private PetDao petDao;

	public PetDTO savePet(PetDTO petDTO) {
		PetEntity petEntity = convertDtoToEntity(petDTO);
		petDao.save(petEntity);
		petDTO.setId(petEntity.getId());
		return petDTO;
	}

	public PetDTO getPet(long petId) {
		PetEntity petEntity = petDao.findById(petId).get();
		PetDTO petDTO = convertEntityToDto(petEntity);
		return petDTO;
	}

	public List<PetDTO> getPets() {
		List<PetEntity> list = petDao.findAll();
		List<PetDTO> listDTO = convertListOfPetEntityToListOfPetDto(list);
		return listDTO;
	}

	public List<PetDTO> getPetsByOwner(long ownerId) {
		List<PetEntity> list = petDao.findAllByOwnerId(ownerId);
		List<PetDTO> listDTO = convertListOfPetEntityToListOfPetDto(list);
		return listDTO;

	}

	public PetEntity convertDtoToEntity(PetDTO petDTO) {
		PetEntity petEntity = new PetEntity();
		petEntity.setBirthDate(petDTO.getBirthDate());
		petEntity.setName(petDTO.getName());
		petEntity.setNotes(petDTO.getNotes());
		petEntity.setOwnerId(petDTO.getOwnerId());
		petEntity.setType(petDTO.getType());
		return petEntity;
	}

	private PetDTO convertEntityToDto(PetEntity petEntity) {
		PetDTO petDTO = new PetDTO();
		petDTO.setId(petEntity.getId());
		petDTO.setBirthDate(petEntity.getBirthDate());
		petDTO.setName(petEntity.getName());
		petDTO.setNotes(petEntity.getNotes());
		petDTO.setOwnerId(petEntity.getOwnerId());
		petDTO.setType(petEntity.getType());
		return petDTO;
	}

	public List<PetDTO> convertListOfPetEntityToListOfPetDto(List<PetEntity> list) {
		List<PetDTO> listDTO = new ArrayList<PetDTO>();
		for (PetEntity pet : list) {
			listDTO.add(convertEntityToDto(pet));
		}
		return listDTO;
	}
	
	public List<PetEntity> convertListOfPetDtoToListOfPetEntity(List<PetDTO> list) {
		List<PetEntity> listDTO = new ArrayList<PetEntity>();
		for (PetDTO pet : list) {
			listDTO.add(convertDtoToEntity(pet));
		}
		return listDTO;
	}
	
	

}
