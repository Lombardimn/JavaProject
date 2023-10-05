package edu.curso.java.integrador.sistemareclamosv3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.curso.java.integrador.sistemareclamosv3.bo.Claim;
import edu.curso.java.integrador.sistemareclamosv3.service.ClaimService;

@Controller
@RequestMapping(value = "/reclamos")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@RequestMapping(value = "/listar") //URL FINAL /reclamos/listar
	public String listarReclamos(Model model) {
		List<Claim> claims = claimService.retrieveAllClaims();
		model.addAttribute("reclamos",claims);
		return "/reclamos/listar";
	}
	
	@RequestMapping(value = "/{id}") //URL FINAL /reclamos/ID
	public String viewClaim(Model model,@PathVariable  Long id) {
		Claim claim = claimService.retrieveClaimsById(id);
		model.addAttribute("reclamo", claim);
		return "/reclamos/ver";
	}

	@RequestMapping(value = "/borrar/{id}") //URL FINAL /reclamos/borrar/ID
	public String deletedClaim(Model model,@PathVariable  Long id) {
		claimService.deletedClaim(id);
		return "redirect:/reclamos/listar";
	}

	@RequestMapping(value = "/nuevo")
	public String newClaim(Model model) {
		ClaimForm claimForm = new ClaimForm();
		model.addAttribute("reclamoForm", claimForm);
		return "/reclamos/form";
	}

	@RequestMapping(value = "/{id}/editar")
	public String editClaim(Model model, @PathVariable  Long id) {
		Claim claim = claimService.retrieveClaimsById(id);
		ClaimForm claimForm = new ClaimForm();
		claimForm.setIdForm(claim.getId());
		claimForm.setTitleForm(claim.getTitleClaim());
		claimForm.setDescriptionForm(claim.getDescriptionClaim());
		model.addAttribute("reclamoForm", claimForm);
		return "/reclamos/form";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String saveClaim(Model model, ClaimForm claimForm) {
		Long idCurrent = claimForm.getIdForm();
		
		if(idCurrent == null) {
			Claim claim = new Claim();
			claim.setTitleClaim(claimForm.getTitleForm());
			claim.setDescriptionClaim(claimForm.getDescriptionForm());
			claimService.newClaimDischarge(claim);
		} else {
			Claim claim = claimService.retrieveClaimsById(idCurrent);
			claim.setTitleClaim(claimForm.getTitleForm());
			claim.setDescriptionClaim(claimForm.getDescriptionForm());
			claimService.updateClaim(claim);
		}
		
		return "redirect:/reclamos/listar";
	}
}
