package com.kh.aimal.model.dto;

import java.sql.Date;

public class AnimalDto {
	private String animalId;
	private String animalName;
	private String speciesId;
	private String zoneId;
	private String keeperId;
	private String gender;  
	private double wrightKg;
	private Date birthDate;
	private Date arrivalDate;
	
	public AnimalDto() {}
	public AnimalDto(String animalName, String speciesId, String zoneId, String keeperId, String gender,
			double wrightKg) {
		this.animalName = animalName;
		this.speciesId = speciesId;
		this.zoneId = zoneId;
		this.keeperId = keeperId;
		this.gender = gender;
		this.wrightKg = wrightKg;
	}
	
	
	public String getAnimalId() {
		return animalId;
	}
	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getKeeperId() {
		return keeperId;
	}
	public void setKeeperId(String keeperId) {
		this.keeperId = keeperId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getWrightKg() {
		return wrightKg;
	}
	public void setWrightKg(double wrightKg) {
		this.wrightKg = wrightKg;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Override
	public String toString() {
		return "AnimalDto [animalId=" + animalId + ", animalName=" + animalName + ", speciesId=" + speciesId
				+ ", zoneId=" + zoneId + ", keeperId=" + keeperId + ", gender=" + gender + ", wrightKg=" + wrightKg
				+ ", birthDate=" + birthDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
	

}
