package com.udacity.jdnd.course3.critter.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.PetEntity;
import com.udacity.jdnd.course3.critter.pet.PetService;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	PetService petService;

	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = convertCustomerDtoToCustomerEntity(customerDTO);
		customerDao.save(customerEntity);
		customerDTO.setId(customerEntity.getId());
		return customerDTO;
	}

	private CustomerEntity convertCustomerDtoToCustomerEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		List<Long> petIds = customerDTO.getPetIds();
		List<PetEntity> petEntities = new ArrayList<PetEntity>();
		for(Long l:petIds) {
			PetDTO petDTO = petService.getPet(l);	
			PetEntity petEntity = petService.convertDtoToEntity(petDTO);
			petEntities.add(petEntity);
		}
		customerEntity.setName(customerDTO.getName());
		customerEntity.setNotes(customerDTO.getNotes());
		customerEntity.setPets(petEntities);
		customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
		return customerEntity;
	}

	public List<CustomerDTO> getAllCustomers() {
		List<CustomerEntity> listOfCustomerEntities = customerDao.findAll();
		List<CustomerDTO> listOfCustomerDto = convertListOfCustomerEntityToCustomerDto(listOfCustomerEntities);
		return listOfCustomerDto;
	}

	private List<CustomerDTO> convertListOfCustomerEntityToCustomerDto(List<CustomerEntity> listOfCustomerEntities) {
		List<CustomerDTO> listOfCustomerDto = new ArrayList<CustomerDTO>();
		for(CustomerEntity customerEntity : listOfCustomerEntities) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setId(customerEntity.getId());
			customerDTO.setName(customerEntity.getName());
			customerDTO.setNotes(customerEntity.getNotes());
			customerDTO.setPetIds(getIdOfAllThePetsFromListOfEntities(customerEntity.getPets()));
			customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
			listOfCustomerDto.add(customerDTO);
		}
		return listOfCustomerDto;
	}

	private List<Long> getIdOfAllThePetsFromListOfEntities(List<PetEntity> pets) {
		return pets.stream().map(x -> x.getId()).collect(Collectors.toList());
	}

	public CustomerDTO getOwnerByPet(long petId) {
		// TODO Auto-generated method stub
		return null;
	}

}
