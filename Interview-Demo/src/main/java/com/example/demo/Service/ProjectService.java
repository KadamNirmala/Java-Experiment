package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Project;
import com.example.demo.Repo.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo projectRepo;
	
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}

	public List<Project> getAllProjects() {
		
		return projectRepo.findAll();
	}
	
}
