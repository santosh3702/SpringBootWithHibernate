package com.spring.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE", catalog = "testEmp")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int empId;

	private String firstname;

	private String lastname;

	private String email;

	private String telephone;

	 private Address address;
	
	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "ADDRESS_ID")
	 public Address getAddress() {
	 return address;
	 }
	
	 public void setAddress(Address address) {
	 this.address = address;
	 }

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "LASTNAME")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
