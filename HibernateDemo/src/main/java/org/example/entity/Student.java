package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id //primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
  

    public Student() {}

    public Student(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }
    
    @Override
    public String toString() {
    	return name+ " "+age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

