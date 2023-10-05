package edu.curso.java.integrador.sistemareclamosv3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;

import java.util.*;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {

	
	@Query(value = "select r from Claim r order by r.titleClaim")
	public List<Claim> retrieveAllClaimsSortedByTitle();
	
	@Query(value = "select r from Claim r where r.titleClaim like %:titleLike% order by r.titleClaim")
	public List<Claim> searchClaimsByTitle(@Param("titLike") String titulo);

}
