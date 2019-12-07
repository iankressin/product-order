package com.products.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {	
	@Id
	private int pid;
	private String name;
	private String prodcutImagePath;
	private String amountMeasure;
	private double price;
	private int amountAvaible;
	@OneToMany(mappedBy="product")
	private List<SystemUserOrder> orders = new ArrayList<SystemUserOrder>();
	
	public Product(int pid, String name, String prodcutImagePath, String amountMeasure, double price, int amountAvaible,
			List<SystemUserOrder> orders) {
		super();
		this.pid = pid;
		this.name = name;
		this.prodcutImagePath = prodcutImagePath;
		this.amountMeasure = amountMeasure;
		this.price = price;
		this.amountAvaible = amountAvaible;
		this.orders = orders;
	}

	public Product() {}
	
	public Product(int pid, String name, String prodcutImagePath, String amountMeasure, double price,
			int amountAvaible) {
		this.pid = pid;
		this.name = name;
		this.prodcutImagePath = prodcutImagePath;
		this.amountMeasure = amountMeasure;
		this.price = price;
		this.amountAvaible = amountAvaible;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProdcutImagePath() {
		return prodcutImagePath;
	}

	public void setProdcutImagePath(String prodcutImagePath) {
		this.prodcutImagePath = prodcutImagePath;
	}

	public String getAmountMeasure() {
		return amountMeasure;
	}

	public void setAmountMeasure(String amountMeasure) {
		this.amountMeasure = amountMeasure;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmountAvaible() {
		return amountAvaible;
	}

	public void setAmountAvaible(int amountAvaible) {
		this.amountAvaible = amountAvaible;
	}

}
