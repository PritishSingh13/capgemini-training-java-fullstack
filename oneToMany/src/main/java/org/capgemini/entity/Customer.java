package org.capgemini.entity;

import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "customer_seq",sequenceName = "customer_sequence",initialValue = 1,allocationSize = 1)
	private int id;
	private String name;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Order> orders=new ArrayList<Order>();
	
	public Customer() {
		
	}
	public Customer(String name) {
		this.name = name;
	}
	
	
	//getters & setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addOrder(Order order) {
	    orders.add(order);
	    order.setCustomer(this);
	}

	
	

}
