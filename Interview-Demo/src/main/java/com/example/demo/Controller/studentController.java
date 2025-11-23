package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import com.example.demo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("student")
public class studentController {
	@Autowired
	StudentService service;

	@GetMapping
	public List<Student> getAllStudents(){
		return service.getAllStudent();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
	    Student student = service.getStudent(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
				System.out.println("HIIII");
//				sdfghjkl
//		jhgfdsdfg
	    return ResponseEntity.ok(student);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		Student updatedStudent = service.updateStudent(student);
		
		if(updatedStudent != null) {
			return ResponseEntity.ok(updatedStudent);
		}else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Student not found");
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id){
		boolean isDeleted= service.deleteStudent(id);
		
		if(isDeleted) {
			return ResponseEntity.ok("Student Deleted SuccesFully..");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Not Found");
		}
	}
	
	@GetMapping("/branch/{branch}")
	public List<Student> getStudentByBranch(@PathVariable String branch){
		return service.getStudentByBranch(branch);
	}
	
	
	@GetMapping("/percentage/{percentage}")
	public List<Student> getStudentByPersMoreThan(@PathVariable float percentage){
		return service.getStudentByPersMoreThan(percentage);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
