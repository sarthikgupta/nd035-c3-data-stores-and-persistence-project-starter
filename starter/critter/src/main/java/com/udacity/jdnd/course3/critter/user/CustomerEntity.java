package com.udacity.jdnd.course3.critter.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.PetEntity;

@Entity
@Table(name = "customers")
public class CustomerEntity {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String phoneNumber;
	private String notes;
	@OneToMany
	private List<PetEntity> pets;

	public long getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", notes=" + notes + ", pets=" + pets + "]";
	}

}
