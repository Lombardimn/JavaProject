package edu.curso.hibernate;

import javax.persistence.*;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue
	private Long idManufacturer;
	private String nameManufacturer;
	
	public Long getIdManufacturer() {
		return idManufacturer;
	}
	
	public void setIdManufacturer(Long idManufacturer) {
		this.idManufacturer = idManufacturer;
	}
	
	public String getNameManufacturer() {
		return nameManufacturer;
	}
	
	public void setNameManufacturer(String nameManufacturer) {
		this.nameManufacturer = nameManufacturer;
	}
	
	
}
