package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Laptop;
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
		if (student.getLaptop() != null) {
	        student.getLaptop().setStudent(student); // link both sides
	    }
		return repo.save(student);
		
	}
	
	public List<Student> getStudentByBranch(String branch){
		return repo.findStudentByBranch(branch);
	}
	
	public List<Student> getStudentByPersMoreThan(float percentage){
		return repo.findStudentperctMoreThan(percentage);
	}
	
	public Student updateStudent(Student s) {

	    Optional<Student> existing = repo.findById(s.getRollNo());

	    if(existing.isPresent()) {
	        Student student = existing.get();

	        // Update student fields
	        student.setName(s.getName());
	        student.setBranch(s.getBranch());
	        student.setPercentage(s.getPercentage());

	        // -----------------------------
	        //      LAPTOP UPDATE LOGIC 
	        // -----------------------------
	        if (s.getLaptop() != null) {

	            // CASE A: Existing laptop present → update its fields
	            if (student.getLaptop() != null) {

	                Laptop existingLaptop = student.getLaptop();
	                existingLaptop.setBrand(s.getLaptop().getBrand());
	                existingLaptop.setModelNumber(s.getLaptop().getModelNumber());
	            } 
	            // CASE B: Student has no laptop earlier → create new laptop
	            else {
	                Laptop newLaptop = s.getLaptop();
	                newLaptop.setStudent(student);  // set other side
	                student.setLaptop(newLaptop);   // set this side
	            }
	        }

	        return repo.save(student);
	    }

	    return null;
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
