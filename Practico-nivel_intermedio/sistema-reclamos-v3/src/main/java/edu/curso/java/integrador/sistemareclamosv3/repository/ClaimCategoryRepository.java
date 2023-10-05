package edu.curso.java.integrador.sistemareclamosv3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistemareclamosv3.bo.ClaimCategory;

@Repository
public interface ClaimCategoryRepository extends CrudRepository<ClaimCategory, Long> {

}
