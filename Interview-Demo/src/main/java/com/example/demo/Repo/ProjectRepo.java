package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

}
