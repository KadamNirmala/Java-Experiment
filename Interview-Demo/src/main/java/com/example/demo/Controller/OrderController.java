package com.example.demo.Controller;

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

import DTOs.CustomerDTO;
import DTOs.OrderDTO;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	OrderRepo orderRepo;

	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		Customer customer = customerRepo.findById(order.getCustomer().getId())
				.orElseThrow(() -> new RuntimeException(" Customer Not Found..."));

		order.setCustomer(customer);
		return orderRepo.save(order);
	}

	@GetMapping("/{id}")
	public OrderDTO getAllOrders(@PathVariable int id) {

		Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found.."));
//		 	Map Customer to CustomerDTO

		Customer customer = order.getCustomer();
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getEmail());

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setPrice(order.getPrice());
		orderDTO.setProductName(order.getProductName());
		orderDTO.setCustomer(customerDTO);

		return orderDTO;
	}

}
