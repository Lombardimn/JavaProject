package edu.curso.hibernate;

import javax.persistence.*;


@Entity
public class Subsidiary {

	@Id
	@GeneratedValue
	private Long idSubsidiary;
	private String nameSubsidiary;
	
	public Long getIdSubsidiary() {
		return idSubsidiary;
	}
	
	public void setIdSubsidiary(Long idSubsidiary) {
		this.idSubsidiary = idSubsidiary;
	}
	
	public String getNameSubsidiary() {
		return nameSubsidiary;
	}
	
	public void setNameSubsidiary(String nameSubsidiary) {
		this.nameSubsidiary = nameSubsidiary;
	}
}
