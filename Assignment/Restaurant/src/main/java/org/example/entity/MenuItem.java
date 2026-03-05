package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MenuItem")
public class MenuItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item;
	private int price;
	public MenuItem() {
		
	}
	public MenuItem(String item,int price) {
		this.item=item;
		this.price=price;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "item is: "+item+" price is: "+price;
	}
	
	
	
}
