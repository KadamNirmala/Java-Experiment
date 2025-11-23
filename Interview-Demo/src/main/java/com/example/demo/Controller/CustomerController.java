package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.OrderAndCustomerRelationship.Customer;
import com.example.demo.Entity.OrderAndCustomerRelationship.Order;
import com.example.demo.Repo.CustomerRepo;
import com.example.demo.Repo.OrderRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	OrderRepo orderRepo;

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		for (Order o : customer.getOrders()) {
			o.setCustomer(customer);
		}
		return customerRepo.save(customer);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

//  get Specific customer

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerRepo.findById(id).orElseThrow(() -> new RuntimeException(" Sorry Customer not found..."));
	}
}
