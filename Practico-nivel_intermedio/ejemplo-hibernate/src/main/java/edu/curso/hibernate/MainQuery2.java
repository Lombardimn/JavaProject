package edu.curso.hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class MainQuery2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); //FALTA EL RESTO DEL CODIGO PARA RECUPERAR UN SESSION
		Transaction transaction = session.beginTransaction();

		
		NativeQuery query1 = session.createSQLQuery("select p.* from products as p where p.id = :idProduct");
		query1.addEntity(Product.class);
		
		query1.setParameter("idProduct", 10L);
		Product product1 = (Product) query1.uniqueResult();
		System.out.println("Producto recuperado: " + product1.getNameProduct());
		
		
		System.out.println("******************************");
		
		NativeQuery query2 = session.createSQLQuery("select p.* from products as p");
		query2.addEntity(Product.class);
		
		List<Product> products = query2.list();
		for (Product product : products) {
			System.out.println(product.getIdProduct() + " - " + product.getNameProduct());
		}
		
		/*
		Query<Product> query1 = session.createQuery("from Product as p where p.id = :idProduct", Product.class);
		query1.setParameter("idProduct", 10L);
		Product product1 = query1.getSingleResult();
		System.out.println("Producto recuperado: " + product1.getNameProduct());
		
		Query<String> query2 = session.createQuery("select p.nameProduct from Product as p where p.idProduct = :idProduct", String.class);
		query2.setParameter("idProduct", 10L);
		String nameProduct = query2.getSingleResult();
		System.out.println("Nombre producto recuperado: " + nameProduct);
		
		Query<Long> query3 = session.createQuery("select count(*) from Product", Long.class);
		Long quantityProduct = query3.getSingleResult();
		System.out.println("Cantidad productos: " + quantityProduct);

		
		Query<ProductCategory> query4 = session.createQuery("select p.productCategory from Product as p where p.id = :idProduct", ProductCategory.class);
		query4.setParameter("idProducto", 10L);
		ProductCategory productCategory = query4.getSingleResult();
		System.out.println("CategoriaProducto recuperado: " + productCategory.getNameCategory());
		*/
		
		transaction.commit();
		session.close(); //IMPORTANTE CERRAR EL SESSION
		HibernateUtil.close();

	}

}