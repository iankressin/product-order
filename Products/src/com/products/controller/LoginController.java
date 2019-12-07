package com.products.controller;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class LoginController {
	public boolean userExists(String username, String password) {
		String select = "SELECT user FROM SystemUser user WHERE user.userName=:username and user.password=:password";
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		   
		 Query query = entityManager.createQuery(select);
		 query.setParameter("username", username);
		 query.setParameter("password", password);
		 
		 try {
			 query.getSingleResult();
			 return true;
		 } catch (NoResultException noResult) {
			 return false;
		 }
	}	

}
