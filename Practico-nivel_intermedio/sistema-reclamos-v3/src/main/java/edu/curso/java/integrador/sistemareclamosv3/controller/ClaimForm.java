package edu.curso.java.integrador.sistemareclamosv3.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClaimForm {
	
	private Long idForm;
	
	@NotNull(message = "No puede dejar vacio el titulo del reclamo.")
	@Size(max = 50)
	private String titleForm;
	
	@NotEmpty(message = "Falta completar la descripcion del reclamo.")
	private String descriptionForm;
	
	public Long getIdForm() {
		return idForm;
	}
	
	public void setIdForm(Long idForm) {
		this.idForm = idForm;
	}
	
	public String getTitleForm() {
		return titleForm;
	}
	
	public void setTitleForm(String titleForm) {
		this.titleForm = titleForm;
	}
	
	public String getDescriptionForm() {
		return descriptionForm;
	}
	
	public void setDescriptionForm(String descriptionForm) {
		this.descriptionForm = descriptionForm;
	}
	
}
