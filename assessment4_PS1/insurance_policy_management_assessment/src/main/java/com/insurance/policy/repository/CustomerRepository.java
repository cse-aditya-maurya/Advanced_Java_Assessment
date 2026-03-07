package com.insurance.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.policy.entity.Customer;
import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	  Optional<Customer> findByEmail(String email);

}





