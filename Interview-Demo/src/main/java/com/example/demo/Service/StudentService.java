package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public List<Student> getAllStudent(){
		List<Student> students = repo.findAll();
		
//		just to find second highest
		List<Student> list = repo.findAllOrderedByPercentageDesc();
		Student second = list.size() >= 2 ? list.get(1) : null;
		System.out.println(second);
		
		return students;
	}
	public Optional<Student> getStudent(int id) {
		return repo.findById(id);
	}
	public Student addStudent(Student student) {
		return repo.save(student);
		
	}
	
	public List<Student> getStudentByBranch(String branch){
		return repo.findStudentByBranch(branch);
	}
	
	public List<Student> getStudentByPersMoreThan(float percentage){
		return repo.findStudentperctMoreThan(percentage);
	}
	
	public Student updateStudent(Student s) {
		Optional<Student> existingStudent = repo.findById(s.getRollNo());
		if(existingStudent.isPresent()) {
			Student student = existingStudent.get();
			student.setName(s.getName());
			student.setBranch(s.getBranch());
			student.setPercentage(s.getPercentage());
			return repo.save(student);
		}else {
			return null;
		}
		
	}
	
	public boolean deleteStudent(int id) {
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			repo.delete(student.get());
			 return true;
		}
		else {
			return false;
		}
		
	}
	
}
