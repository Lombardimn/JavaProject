package edu.curso.java.integrador.sistemareclamosv3.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;
import edu.curso.java.integrador.sistemareclamosv3.bo.ClaimCategory;
import edu.curso.java.integrador.sistemareclamosv3.repository.ClaimCategoryRepository;
import edu.curso.java.integrador.sistemareclamosv3.repository.ClaimRepository;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	private ClaimCategoryRepository claimCategoryRepository;
	
	@Autowired
	private ClaimRepository claimRepository;
	
	@Override
	public Long newClaimDischarge(Claim claim) {
		claim.setDischargeDateClaim(new Date());
		
		//ClaimCategory claimCategory = null;
		//claim.setClaimCategory(claimCategory);
		
		claimRepository.save(claim);
		return claim.getId();
	}
	
	@Override
	public List<Claim> retrieveAllClaims() {
		return claimRepository.retrieveAllClaimsSortedByTitle();
	}
	
	@Override
	public List<Claim> retrieveAllClaims(String titleClaim) {
		return claimRepository.searchClaimsByTitle(titleClaim);
	}
	
	@Override
	public Claim retrieveClaimsById(Long id) {
		return claimRepository.findById(id).get();
	}
	
	@Override
	public void deletedClaim(Long id) {
		claimRepository.deleteById(id);
	}
	
	@Override
	public void updateClaim(Claim claim) {
		claimRepository.save(claim);
	}
}
