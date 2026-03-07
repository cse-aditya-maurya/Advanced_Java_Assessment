package com.insurance.policy.controller;

import com.insurance.policy.dto.request.CustomerRequestDTO;
import com.insurance.policy.dto.response.CustomerResponseDTO;
import com.insurance.policy.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO) {
        return customerService.createCustomer(requestDTO);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}