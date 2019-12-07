package com.products.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.products.model.Product;

public class ProductsController {
	
	public List<Product> getAllProducts() {
		String select = "SELECT product FROM Product product";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery(select);

		List<Product> allProducts = query.getResultList();

		System.out.println(allProducts.toString());

		return allProducts;
	}
}
