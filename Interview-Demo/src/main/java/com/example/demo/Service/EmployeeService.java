package com.example.demo.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Project;
import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.Repo.ProjectRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	ProjectRepo projectRepo;

	public Employee createEmployee(Employee employee, List<Long> projectIds) {
	    Set<Project> projects = new HashSet<>();
	    for (Long id : projectIds) {
	        Project project = projectRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Project not found: " + id));
	        projects.add(project);
	    }

	    employee.setProjects(projects);
	    // Link both sides for bi-directional Many-to-Many
	    for (Project p : projects) {
	        p.getEmployees().add(employee);
	    }

	    return employeeRepo.save(employee);
	}


	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}
}
