package com.products.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SystemUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String firstName;
	private String userName;
	private String password;
	private Date birthdate;
	private char sex;
	private int zipCode;
	private String address;
	private int addressNumber;
	private String addressComplement;
	private String city;
	private String state;
	@OneToMany(mappedBy="systemUser")
	private List<SystemUserOrder> orders = new ArrayList<SystemUserOrder>();

	public SystemUser() {}
	
	public SystemUser(int uid, String firstName, String userName, String password, Date birthdate, char sex,
			int zipCode, String address, int addressNumber, String addressComplement, String city, String state,
			List<SystemUserOrder> orders) {
		super();
		this.uid = uid;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.birthdate = birthdate;
		this.sex = sex;
		this.zipCode = zipCode;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
		this.city = city;
		this.state = state;
		this.orders = orders;
	}
	
	public SystemUser(int uid, String firstName, String userName, String password, Date birthdate, char sex, int zipCode,
			String address, int addressNumber, String addressComplement, String city, String state) {
		this.uid = uid;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.birthdate = birthdate;
		this.sex = sex;
		this.zipCode = zipCode;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
		this.city = city;
		this.state = state;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "SystemUser [uid=" + uid + ", firstName=" + firstName + ", userName=" + userName + ", password="
				+ password + ", birthdate=" + birthdate + ", sex=" + sex + ", zipCode=" + zipCode + ", address="
				+ address + ", addressNumber=" + addressNumber + ", addressComplement=" + addressComplement + ", city="
				+ city + ", state=" + state + ", orders=" + orders + "]";
	}
}
