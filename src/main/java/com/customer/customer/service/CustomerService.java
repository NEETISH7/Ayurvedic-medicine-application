package com.customer.customer.service;
import java.util.List;
import java.util.Optional;

import com.customer.customer.entity.Customer;
import com.customer.customer.exception.CustomerAlreadyExistsException;

public interface CustomerService {

	Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException;

	List<Customer> getAllCustomers();

	Optional<Customer> getCustomerById(int id);

	String deleteCustomerById(int id);

	List<Customer> getCustomerByName(String firstName);
}
