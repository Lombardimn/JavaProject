package edu.curso.java.integrador.sistemareclamosv3.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity 
public class Claim {

	@Id
	@GeneratedValue
	private Long id;
	
	private String titleClaim;
	private String descriptionClaim;
	private Date dischargeDateClaim;
	
	@ManyToOne
	private ClaimCategory claimCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitleClaim() {
		return titleClaim;
	}

	public void setTitleClaim(String titleClaim) {
		this.titleClaim = titleClaim;
	}

	public String getDescriptionClaim() {
		return descriptionClaim;
	}

	public void setDescriptionClaim(String descriptionClaim) {
		this.descriptionClaim = descriptionClaim;
	}

	public Date getDischargeDateClaim() {
		return dischargeDateClaim;
	}

	public void setDischargeDateClaim(Date dischargeDateClaim) {
		this.dischargeDateClaim = dischargeDateClaim;
	}

	public ClaimCategory getClaimCategory() {
		return claimCategory;
	}

	public void setClaimCategory(ClaimCategory claimCategory) {
		this.claimCategory = claimCategory;
	}
	
	
}
