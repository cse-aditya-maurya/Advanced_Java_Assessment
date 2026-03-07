package com.insurance.policy.repository;

import com.insurance.policy.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    // Find policies by policy type
    List<Policy> findByPolicyType(String policyType);

    // Find policies by customer ID
    List<Policy> findByCustomerId(Long customerId);

    // Find policies by premium range
    List<Policy> findByPremiumAmountBetween(Double min, Double max);

    // Custom JPQL query
    @Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
    List<Policy> findPoliciesByCustomerEmail(String email);

}