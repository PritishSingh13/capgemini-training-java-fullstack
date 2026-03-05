package org.capgemini.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private String orderDate;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	public Order() {
		
	}
	

	public Order(String orderDate,Customer customer) {
		this.orderDate=orderDate;
		this.customer=customer;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
