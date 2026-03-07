package com.insurance.policy.mapper;

import com.insurance.policy.dto.request.CustomerRequestDTO;
import com.insurance.policy.dto.response.CustomerResponseDTO;
import com.insurance.policy.entity.Customer;

public class CustomerMapper {

   
    public static Customer toEntity(CustomerRequestDTO dto) {

        Customer customer = new Customer();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAddress(dto.getAddress());

        return customer;
    }

   
    public static CustomerResponseDTO toResponseDTO(Customer customer) {

        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAddress(customer.getAddress());

        return dto;
    }
}