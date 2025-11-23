package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "laptopID")
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int laptopID;
	private String modelNumber;
	private String brand;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public int getLaptopID() {
		return laptopID;
	}

	public void setLaptopID(int laptopID) {
		this.laptopID = laptopID;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Laptop(int laptopID, String modelNumber, String brand, Student student) {
		super();
		this.laptopID = laptopID;
		this.modelNumber = modelNumber;
		this.brand = brand;
		this.student = student;
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

}
