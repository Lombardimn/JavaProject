package edu.curso.java.integrador.sistemareclamosv3.service;

import java.util.List;

import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;

public interface ClaimService {

	Long newClaimDischarge(Claim claim);

	List<Claim> retrieveAllClaims();

	List<Claim> retrieveAllClaims(String titleClaim);

	Claim retrieveClaimsById(Long id);

	void deletedClaim(Long id);

	void updateClaim(Claim claim);

}