package edu.curso.java.integrador.sistemareclamosv3.controller.dto;

import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;

public class ClaimDTO {
	private Long idDTO;
	private String titleDTO;
	private String descriptionDTO;
	
	public ClaimDTO() {}
	
	public ClaimDTO(Claim claim) {
		this.idDTO = claim.getId();
		this.titleDTO = claim.getTitleClaim();
		this.descriptionDTO = claim.getDescriptionClaim();
	}
	
	public Long getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(Long idDTO) {
		this.idDTO = idDTO;
	}

	public String getTitleDTO() {
		return titleDTO;
	}

	public void setTitleDTO(String titleDTO) {
		this.titleDTO = titleDTO;
	}

	public String getDescriptionDTO() {
		return descriptionDTO;
	}

	public void setDescriptionDTO(String descriptionDTO) {
		this.descriptionDTO = descriptionDTO;
	}
}
