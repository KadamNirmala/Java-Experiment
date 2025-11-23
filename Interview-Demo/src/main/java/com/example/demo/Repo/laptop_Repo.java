package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Laptop;

@Repository
public interface laptop_Repo extends JpaRepository<Laptop, Integer> {

}
