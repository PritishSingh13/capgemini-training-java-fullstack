package org.cap.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToMany(mappedBy = "courses")
	
	@OneToOne
	@JoinColumn(name  = "idCard_id")
	private Idcard idcard;
	
	
	@ManyToMany
	@JoinTable(name= "student_course",
	joinColumns = @JoinColumn(name= "student_id"),inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses = new ArrayList<>();

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
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
	public Idcard getIdcard() {
		return idcard;
	}
	public void setIdcard(Idcard idcard) {
		this.idcard = idcard;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

	
	
	

}
