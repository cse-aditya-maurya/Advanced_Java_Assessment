package com.insurance.policy.service.impl;

import com.insurance.policy.dto.request.CustomerRequestDTO;
import com.insurance.policy.dto.response.CustomerResponseDTO;
import com.insurance.policy.entity.Customer;
import com.insurance.policy.exception.CustomerNotFoundException;
import com.insurance.policy.mapper.CustomerMapper;
import com.insurance.policy.repository.CustomerRepository;
import com.insurance.policy.service.CustomerService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO requestDTO) {

        Customer customer = CustomerMapper.toEntity(requestDTO);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.toResponseDTO(savedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));

        return CustomerMapper.toResponseDTO(customer);
    }
}