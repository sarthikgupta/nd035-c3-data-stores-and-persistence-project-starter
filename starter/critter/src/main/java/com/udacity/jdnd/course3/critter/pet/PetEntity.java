package com.udacity.jdnd.course3.critter.pet;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class PetEntity {
	@Id
	@GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	private PetType type;
	@Column(name = "pet_name")
	private String name;
	@Column(name = "owner_id")
	private long ownerId;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "notes")
	private String notes;

	public long getId() {
		return id;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
