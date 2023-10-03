package edu.curso.hibernate;

import org.hibernate.*;
//import java.util.List;
//import org.dom4j.Branch;
//import org.hibernate.query.Query;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); //FALTA EL RESTO DEL CODIGO PARA RECUPERAR UN SESSION
		Transaction transaction = session.beginTransaction();
		
		/*
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setNameCategory("general");
		session.save(productCategory1);
		
		Product product1 = new Product();
		product1.setNameProduct("Ejemplo4");
		product1.setDescripcionProduct("Este es un ejemplo de un producto 4");
		product1.setPriceProduct(31000.0);
		product1.setProductCategory(productCategory1);
		session.save(product1); //ESTO GENERA UN INSER EN LA BASE DE DATOS
		
		System.out.println("El id generado del nuevo producto es: " + product1.getIdProduct());
		
		Manufacturer manufacturer1 = new Manufacturer();
		manufacturer1.setNameManufacturer("fabricante1");
		session.save(manufacturer1);

		Manufacturer manufacturer2 = new Manufacturer();
		manufacturer2.setNameManufacturer("fabricante2");
		session.save(manufacturer2);
		
		product1.getManufacturers().add(manufacturer1);
		product1.getManufacturers().add(manufacturer2);
		session.update(product1);

		Subsidiary subsidiary1 = new Subsidiary();
		subsidiary1.setNameSubsidiary("sucursal1");
		session.save(subsidiary1);
		
		product1.getSubsidiaries().add(subsidiary1);
		session.update(product1);*/
		
		/*
		Long idSearch = 10L; //EJEMPLO DE COMO RECUPERAR!!!!
		Product searchProduct = session.load(Product.class, idSearch);
		System.out.println("Nombre: " + searchProduct.getNameProduct());
		System.out.println("Desc: " + searchProduct.getDescripcionProduct());
		System.out.println("Categoria: " + searchProduct.getProductCategory().getNameCategory());
		
		List<Manufacturer> manufacturers = searchProduct.getManufacturers();
		for (Manufacturer manufacturer : manufacturers) {
			System.out.println("Fabricante: " + manufacturer.getNameManufacturer());
		}
		
		System.out.println("Precio: " + searchProduct.getPriceProduct());
		
		
		//EJEMPLO DE UPDATE
		searchProduct.setDescripcionProduct("Ejemplo de update....");
		session.update(searchProduct);
		
		//EJEPLO DE DELETE
		session.delete(searchProduct);
		*/
		
		/*
		Query<Product> queryProducts= session.createQuery("from Producto as p where p.precio > :precio order by p.nombre", Producto.class);
		queryProducts.setParameter("precio", 10000.0);
		
		List<Product> products = queryProducts.list();
		for (Product p : products) {
			System.out.println("Id: " + p.getIdProduct());
			System.out.println("Nombre: " + p.getNameProduct());
			System.out.println("Desc: " + p.getDescripcionProduct());
			System.out.println("Precio: " + p.getPriceProduct());
			System.out.println("****************************");
		}*/
		
		transaction.commit();
		session.close(); //IMPORTANTE CERRAR EL SESSION
		HibernateUtil.close();
	}

}
