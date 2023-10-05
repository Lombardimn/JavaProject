package edu.curso.java.integrador.sistemareclamosv3.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;
import edu.curso.java.integrador.sistemareclamosv3.controller.dto.ClaimDTO;
import edu.curso.java.integrador.sistemareclamosv3.service.ClaimService;

@RestController
@RequestMapping("/api/reclamos")
public class ClaimRestController {
	
	@Autowired
	private ClaimService claimService;
	
	@GetMapping //URL FINAL ES: /api/reclamos
	public List<ClaimDTO> retrieveAllClaims() {
		List<ClaimDTO> claimsDTO = new ArrayList<ClaimDTO>();
		
		List<Claim> claims = claimService.retrieveAllClaims();
		for (Claim claim : claims) {
			claimsDTO.add(new ClaimDTO(claim));
		}
		
		return claimsDTO;
	}
	
	@GetMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ClaimDTO retrieveClaimsById(@PathVariable Long id) {
		Claim claim = claimService.retrieveClaimsById(id);
		ClaimDTO claimDTO = new ClaimDTO(claim);
		return claimDTO;
	}
	
	@PostMapping //URL FINAL ES: /api/reclamos
	public ClaimDTO newClaimDischarge(@RequestBody ClaimDTO claimDTO) {
		Claim claim = new Claim();
		claim.setTitleClaim(claimDTO.getTitleDTO());
		claim.setDescriptionClaim(claimDTO.getDescriptionDTO());
		Long idNewClaim = claimService.newClaimDischarge(claim);
		claimDTO.setIdDTO(idNewClaim);
		return claimDTO;
	}
	
	
	@DeleteMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public void deletedClaim(@PathVariable Long id) {
		claimService.deletedClaim(id);	
	}
	
	@PutMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ClaimDTO newClaimDischarge(@PathVariable Long id, @RequestBody ClaimDTO claimDTO) {
		Claim claim = claimService.retrieveClaimsById(id);
		claim.setTitleClaim(claimDTO.getTitleDTO());
		claim.setDescriptionClaim(claimDTO.getDescriptionDTO());
		claimService.updateClaim(claim);
		return claimDTO;
	}
}
