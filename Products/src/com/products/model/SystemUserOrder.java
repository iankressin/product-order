package com.products.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SystemUserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	@ManyToOne
	private SystemUser systemUser;
	@ManyToOne
	private Product product;
	private Date orderDate;
	private int amount;
	private double totalPrice;
	
	public SystemUserOrder(){}
	
	public SystemUserOrder(int oid, SystemUser user, Product product, Date orderDate, int amount, double totalPrice) {
		this.oid = oid;
		this.systemUser = user;
		this.product = product;
		this.orderDate = orderDate;
		this.amount = amount;
		this.totalPrice = totalPrice;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public SystemUser getUser() {
		return systemUser;
	}

	public void setUser(SystemUser user) {
		this.systemUser = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
