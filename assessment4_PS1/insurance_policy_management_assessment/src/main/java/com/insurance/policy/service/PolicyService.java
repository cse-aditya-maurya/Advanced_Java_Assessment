package com.insurance.policy.service;

import com.insurance.policy.dto.request.PolicyRequestDTO;
import com.insurance.policy.dto.response.PolicyResponseDTO;

import org.springframework.data.domain.Page;

import java.util.List;

public interface PolicyService {

    PolicyResponseDTO createPolicy(PolicyRequestDTO requestDTO);

    PolicyResponseDTO getPolicyById(Long id);

    PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO requestDTO);

    void cancelPolicy(Long id);

    List<PolicyResponseDTO> getPoliciesByType(String type);

    List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max);

    Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy, String direction);
}