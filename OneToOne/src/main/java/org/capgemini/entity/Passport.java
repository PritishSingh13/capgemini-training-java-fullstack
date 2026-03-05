package org.capgemini.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "passport")
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "passport_seq")
	@SequenceGenerator(name= "passport_seq",sequenceName = "passport_sequence",initialValue = 1,allocationSize = 1)
	private int passportId;
	private String passportNumber;
	private String country;
	//step after giving input in db
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	public Passport() {
		
	}
	public Passport(String passportNumber,String country) {
		this.passportNumber=passportNumber;
		this.country=country;
	}
	
	
	//Getters and Setters

	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	

	
	
}
