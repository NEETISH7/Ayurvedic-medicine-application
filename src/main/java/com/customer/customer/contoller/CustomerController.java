package com.customer.customer.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.customer.entity.Customer;
import com.customer.customer.exception.CustomerAlreadyExistsException;
import com.customer.customer.service.CustomerService;


@RestController
@RequestMapping("api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int id) {
		Optional<Customer> customer = customerService.getCustomerById(id);
		return new ResponseEntity<Optional<Customer>>(customer, HttpStatus.OK);
	}

	@DeleteMapping("customer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
		String str = customerService.deleteCustomerById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/customers/{name}")
	public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable String name) {
		List<Customer> customer = customerService.getCustomerByName(name);
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
	}
}