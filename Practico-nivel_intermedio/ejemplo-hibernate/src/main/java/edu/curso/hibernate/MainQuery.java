package edu.curso.hibernate;

import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;

public class MainQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); //FALTA EL RESTO DEL CODIGO PARA RECUPERAR UN SESSION
		Transaction transaction = session.beginTransaction();
		
		/*
		Query<Product> query1 = session.createQuery("from Producto as p where p.id = :idProducto", Product.class);
		query1.setParameter("idProducto", 10L);
		Product product1 = query1.getSingleResult();
		System.out.println("Producto recuperado: " + product1.getNameProduct());
		
		Query<String> query2 = session.createQuery("select p.nombre from Producto as p where p.id = :idProducto", String.class);
		query2.setParameter("idProducto", 10L);
		String nameProduct = query2.getSingleResult();
		System.out.println("Nombre producto recuperado: " + nameProduct);
		
		Query<Long> query3 = session.createQuery("select count(*) from Producto", Long.class);
		Long quantityProduct = query3.getSingleResult();
		System.out.println("Cantidad productos: " + quantityProduct);

		
		Query<ProductCategory> query4 = session.createQuery("select p.categoriaProducto from Producto as p where p.id = :idProducto", CategoriaProducto.class);
		query4.setParameter("idProducto", 10L);
		ProductCategory productCategory = query4.getSingleResult();
		System.out.println("CategoriaProducto recuperado: " + productCategory.getNameCategory());
		*/
		
		Query<Product> query1 = session.createQuery("from Product as p order by p.nameProduct", Product.class);
		List<Product> products1 = query1.list();
		

		for (Product product : products1) {
			System.out.println("Id: " + product.getIdProduct() + " " + product.getNameProduct());
		}
		
		System.out.println("*****************************");

		
		
		Query<Product> query2 = session.createQuery("from Product as p where p.priceProduct >= :priceQuery by p.nameProduct", Product.class);
		query2.setParameter("priceQuery", 1000.0);
		List<Product> products2 = query2.list();
		
		for (Product product : products2) {
			System.out.println("Id: " + product.getIdProduct() + " " + product.getNameProduct());
		}
		
		System.out.println("*****************************");
		
		
		
		Query<Product> query3 = session.createQuery("from Product as p where p.nameProduct like :nameQuery order by p.nameProduct", Product.class);
		query3.setParameter("nameQuery", "%emplo%");
		List<Product> products3 = query3.list();
		

		for (Product product : products3) {
			System.out.println("Id: " + product.getIdProduct() + " " + product.getNameProduct());
		}

		System.out.println("*****************************");
		
		
		
		Query<Product> query4 = session.createQuery("from Product as p where p.ProductCategory.nameCategory = :nameCategory order by p.nameCategory", Product.class);
		query4.setParameter("nameCategory", "general");
		List<Product> products4 = query4.list();
		

		for (Product product : products4) {
			System.out.println("Id: " + product.getIdProduct() + " " + product.getNameProduct());
		}

		System.out.println("*****************************");
				
		Product simpleSearchProduct = session.load(Product.class, 10L);
		List<Manufacturer> simplemanufacturers = simpleSearchProduct.getManufacturers();
		for (Manufacturer manufacturer : simplemanufacturers) {
			System.out.println(manufacturer.getIdManufacturer() + " " + manufacturer.getNameManufacturer());
		}
		
		System.out.println("*****************************");
		
		
		
		Query<Manufacturer> query5 = session.createQuery("select f from Product as p inner join p.fabricantes as f where p.id = :idPorducto", Manufacturer.class);
		query5.setParameter("idPorducto", 10L);
		List<Manufacturer> manufacturers2 = query5.list();
		for (Manufacturer manufacturer : manufacturers2) {
			System.out.println(manufacturer.getIdManufacturer() + " " + manufacturer.getNameManufacturer());
		}
		
		
		
		transaction.commit();
		session.close(); //IMPORTANTE CERRAR EL SESSION
		HibernateUtil.close();

	}
}
