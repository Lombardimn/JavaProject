package edu.curso.java.integrador.sistemareclamosv3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//BO
import edu.curso.java.integrador.sistemareclamosv3.bo.ClaimCategory;
import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;

//Repository
import edu.curso.java.integrador.sistemareclamosv3.repository.ClaimCategoryRepository;

//Service
import edu.curso.java.integrador.sistemareclamosv3.service.ClaimService;

@SpringBootApplication
public class SistemaReclamosV3Application implements CommandLineRunner {
	
	//@Autowired
	//private ClaimCategoryRepository claimCategoryRepository;

	@Autowired
	private ClaimService claimService;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaReclamosV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//ClaimCategory claimCategory1 = new ClaimCategory();
		//claimCategory1.setNameClaimCategory("nuevo");
		
		//claimCategoryRepository.save(claimCategory1);
		//System.out.println("ID generado: " + claimCategory1.getIdClaim());
		
		//System.out.println("Cantidad de categorias: " + claimCategoryRepository.count());
		//Long idQuery = 1l;
		//ClaimCategory claimCategory = claimCategoryRepository.findById(idQuery).get();
		//System.out.println("Nombre: " + claimCategory.getNameClaimCategory());
		
		
		//Claim claim1 = new Claim();
		//claim1.setTitleClaim("Ejemplo 1");
		//claim1.setDescriptionClaim("Ejemplo de reclamo creado desde la consola");
		
		//Long Idgenerated = claimService.newClaimDischarge(claim1);
		
		//System.out.println("Id generado del nuevo reclamo: " + Idgenerated);
		
		//List<Claim> claims = claimService.retrieveAllClaims();
		//for (Claim claim : claims) {
		//	System.out.println("Reclamo: " + claim.getTitleClaim());
		//}
		
	}

}
