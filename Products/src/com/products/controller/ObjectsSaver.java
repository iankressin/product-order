package com.products.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import com.products.model.Product;
import com.products.model.SystemUser;
import com.products.model.SystemUserOrder;

public class ObjectsSaver {

	public ObjectsSaver () {}
	
	public boolean persistSystemUser(SystemUser systemUser) {
		LoginController loginController = new LoginController();
		String username = systemUser.getUserName();
		String password = systemUser.getPassword();
		boolean userExists = loginController.userExists(username, password);
		
		if(!userExists) {
			EntityManager em = createEntityManager();
			em.getTransaction().begin();
			em.persist(systemUser);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
	
	public void persistProduct(Product product) {
		EntityManager em = createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}
	
	public void persistSystemUserOrder(SystemUserOrder systemUserOrder) {
		EntityManager em = createEntityManager();
		em.getTransaction().begin();
		em.persist(systemUserOrder);
		em.getTransaction().commit();
	}
	
	public EntityManager createEntityManager() {
		return createEntityManagerFactory().createEntityManager();
	}
	
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("pu");
	}
	
	public SystemUser createSystemUser (Enumeration<String> parameterNames, HttpServletRequest request) {
		
		SystemUser newSystemUser = new SystemUser();
		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			switch(paramName) {
				case "firstName":
					System.out.println("firstName: " + paramValues[0]);
					newSystemUser.setFirstName(paramValues[0]);
					break;
				case "username":
					System.out.println("username: " + paramValues[0]);
					newSystemUser.setUserName(paramValues[0]);
					break;
				case "password": 
					System.out.println("password: " + paramValues[0]);
					newSystemUser.setPassword(paramValues[0]);
					break;
				case "birthdate":
					System.out.println("birthdate: " + paramValues[0]);
					Date birthdate = null;
					try {
						birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(paramValues[0]);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					newSystemUser.setBirthdate(birthdate);
					break;
				case "sex":
					System.out.println("sex: " + paramValues[0]);
					char sex = paramValues[0].charAt(0);
					newSystemUser.setSex(sex);
					break;
				case "zipCode":
					System.out.println("zipCode: " + paramValues[0]);
					int zipCode = Integer.parseInt(paramValues[0]);
					newSystemUser.setZipCode(zipCode);
					break;
				case "address":
					System.out.println();
					newSystemUser.setAddress(paramValues[0]);
					break;
				case "addressNumber":
					System.out.println();
					int addressNumber = Integer.parseInt(paramValues[0]);
					newSystemUser.setAddressNumber(addressNumber);
					break;
				case "addressComplement":
					System.out.println();
					newSystemUser.setAddressComplement(paramValues[0]);
					break;
				case "city":
					System.out.println();
					newSystemUser.setCity(paramValues[0]);
					break;
				case "state":
					System.out.println();
					newSystemUser.setState(paramValues[0]);
					break;
				default:
					System.out.println("Wrong parameter");
					break;
			}
		}
		
		return newSystemUser;
	}
}
