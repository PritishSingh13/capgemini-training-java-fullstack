package com.example.SpringMvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMvc.Model.Student;
import com.example.SpringMvc.Repository.StudentDao;


@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public void saveStudent(Student student) {
		studentDao.save(student);
	}

}
