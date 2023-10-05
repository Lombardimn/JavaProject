package edu.curso.java.integrador.sistemareclamosv3.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClaimCategory {
	@Id
	@GeneratedValue
	private Long idClaim;
	private String nameClaimCategory;
	
	public Long getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}
	public String getNameClaimCategory() {
		return nameClaimCategory;
	}
	public void setNameClaimCategory(String nameClaimCategory) {
		this.nameClaimCategory = nameClaimCategory;
	}
}
