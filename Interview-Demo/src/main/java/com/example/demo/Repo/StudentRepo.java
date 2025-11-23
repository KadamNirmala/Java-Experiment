package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

//	@Query("SELECT s FROM Student s WHERE s.rollNo = :id")
//	Student findStudentById(@Param("id") int id);
	
	@Query("SELECT s FROM Student s WHERE s.branch = :branch")
	List<Student> findStudentByBranch(@Param("branch") String branch);
	
	@Query("SELECT s FROM Student s WHERE s.percentage > :percentage")
	List<Student> findStudentperctMoreThan(@Param("percentage") float percentage);
	
	@Query("SELECT s FROM Student s ORDER BY s.percentage DESC")
	List<Student> findAllOrderedByPercentageDesc();
	
	@Query("SELECT COUNT(s) FROM Student s WHERE s.branch = :branch")
	Long countByBranch(@Param("branch") String branch);
		
}