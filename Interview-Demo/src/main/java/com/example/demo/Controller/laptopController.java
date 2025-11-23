package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Laptop;
import com.example.demo.Entity.Student;
import com.example.demo.Repo.StudentRepo;
import com.example.demo.Repo.laptop_Repo;

@RestController
@RequestMapping("laptop")
public class laptopController {
	
	@Autowired
	laptop_Repo laptop_repo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping
	public List<Laptop> getAllLaptop(){
		return laptop_repo.findAll();
	}
	
	@PostMapping
	public Laptop addLaptop(@RequestBody Laptop dto) {

	    Student student = studentRepo.findById(dto.getStudent().getRollNo())
	        .orElseThrow(() -> new RuntimeException("Student not found"));

	    Laptop laptop = new Laptop();
	    laptop.setBrand(dto.getBrand());
	    laptop.setModelNumber(dto.getModelNumber());
	    laptop.setStudent(student);
	    student.setLaptop(laptop);

	    return laptop_repo.save(laptop);
	}


}
