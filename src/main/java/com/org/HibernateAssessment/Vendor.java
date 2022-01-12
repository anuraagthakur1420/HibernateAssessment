package com.org.HibernateAssessment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
public class Vendor {
	@Id
	@Column(name = "vendid")
	private int vendorId;

	@Column(name = "venName", length = 10)
	private String vendorName;

	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "venid", referencedColumnName = "vendid")
	private Set customers;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Set getCustomers() {
		return customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

}