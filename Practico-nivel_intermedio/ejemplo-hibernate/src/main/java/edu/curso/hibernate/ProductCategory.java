package edu.curso.hibernate;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue
	private Long idCategory;
	
	@Column(length = 400)
	private String nameCategory;

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nombreCategory) {
		this.nameCategory = nombreCategory;
	}
}
