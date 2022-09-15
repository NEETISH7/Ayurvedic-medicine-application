package com.customer.customer.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customer.entity.Customer;
import com.customer.customer.exception.CustomerAlreadyExistsException;
import com.customer.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
		if (customerRepository.existsById(customer.getId()))
			throw new CustomerAlreadyExistsException();

		return customerRepository.save(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		Optional<Customer> Customer = customerRepository.findById(id);
		return Customer;
	}

	@Override
	public String deleteCustomerById(int id) {
		if (customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return "id is deleted successfully";
		}
		return "id doesn't exist";
	}
	
	@Override
	public List<Customer> getCustomerByName(String firstName) {
		List<Customer> list = customerRepository.findByFirstName(firstName);
		return list;
	}
}
