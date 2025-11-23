package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;

import Helper.EmployeeRequest;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employee) {
	    try {
	        Employee emp = employeeService.createEmployee(employee.getEmployee(), employee.getProjectIds());
	        return ResponseEntity.ok(emp);
	    } catch (RuntimeException ex) {
	        return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(Map.of("error", ex.getMessage()));
	    }
	}

	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}

}
