package com.insurance.policy.mapper;

import com.insurance.policy.dto.request.PolicyRequestDTO;
import com.insurance.policy.dto.response.PolicyResponseDTO;
import com.insurance.policy.entity.Policy;
import com.insurance.policy.entity.Customer;

public class PolicyMapper {

  
    public static Policy toEntity(PolicyRequestDTO dto, Customer customer) {

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        policy.setCustomer(customer);

        return policy;
    }

   
    public static PolicyResponseDTO toResponseDTO(Policy policy) {

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(policy.getId());
        dto.setPolicyNumber(policy.getPolicyNumber());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setCoverageAmount(policy.getCoverageAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());
        dto.setStatus(policy.getStatus());

        dto.setCustomer(CustomerMapper.toResponseDTO(policy.getCustomer()));

        return dto;
    }
}