package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Project;
import com.example.demo.Service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping
	public Project createProject(@RequestBody Project project) {
		return projectService.createProject(project);
	}
	
	@GetMapping
	public List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
}
