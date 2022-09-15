package com.customer.customer.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.customer.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	@Query("select u from User u where u.firstName =:name")
	public List<Customer> findByFirstName(@Param("name") String firstName);
}
