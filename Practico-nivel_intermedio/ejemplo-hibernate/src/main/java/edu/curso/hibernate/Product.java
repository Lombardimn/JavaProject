package edu.curso.hibernate;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "products")
public class Product {

	@Id // PK DE LA TABLA PRODUCTOS
	@GeneratedValue // VALOR DEL ID AUTO GENERADO
	private Long idProduct;
	private String nameProduct;
	private Double priceProduct;
	
	@ManyToMany
	private List<Subsidiary> subsidiaries = new ArrayList<Subsidiary>();
	
	public List<Subsidiary> getSubsidiaries() {
		return subsidiaries;
	}
	public void setSubsidiaries(List<Subsidiary> subsidiaries) {
		this.subsidiaries = subsidiaries;
	}
	
	@OneToMany
	private List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
	
	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCategory productCategory;
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	@Column(name = "fullDescription")
	private String descripcionProduct;

	
	public Long getIdProduct() {
		return idProduct;
	}
	
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	
	public String getNameProduct() {
		return nameProduct;
	}
	
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	public Double getPriceProduct() {
		return priceProduct;
	}
	
	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}
	
	public String getDescripcionProduct() {
		return descripcionProduct;
	}
	
	public void setDescripcionProduct(String descripcionProduct) {
		this.descripcionProduct = descripcionProduct;
	}
}

