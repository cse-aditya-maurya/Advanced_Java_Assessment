package com.insurance.policy.service;

import com.insurance.policy.dto.request.CustomerRequestDTO;
import com.insurance.policy.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO requestDTO);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Long id);
}