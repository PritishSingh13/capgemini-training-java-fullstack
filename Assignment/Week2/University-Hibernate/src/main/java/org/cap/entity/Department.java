package org.cap.entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "department")
	List<Student> students = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}
	public void setSs(List<Student> students) {
		this.students = students;
	}
	
	
	
	

}
