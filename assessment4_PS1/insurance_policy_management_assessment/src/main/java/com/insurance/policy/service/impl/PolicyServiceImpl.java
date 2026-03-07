package com.insurance.policy.service.impl;

import com.insurance.policy.dto.request.PolicyRequestDTO;
import com.insurance.policy.dto.response.PolicyResponseDTO;
import com.insurance.policy.entity.Customer;
import com.insurance.policy.entity.Policy;
import com.insurance.policy.exception.CustomerNotFoundException;
import com.insurance.policy.exception.PolicyNotFoundException;
import com.insurance.policy.mapper.PolicyMapper;
import com.insurance.policy.repository.CustomerRepository;
import com.insurance.policy.repository.PolicyRepository;
import com.insurance.policy.service.PolicyService;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository, CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO requestDTO) {

        Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        Policy policy = PolicyMapper.toEntity(requestDTO, customer);

        Policy savedPolicy = policyRepository.save(policy);

        return PolicyMapper.toResponseDTO(savedPolicy);
    }

    @Override
    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        return PolicyMapper.toResponseDTO(policy);
    }

    @Override
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO requestDTO) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setPolicyNumber(requestDTO.getPolicyNumber());
        policy.setPolicyType(requestDTO.getPolicyType());
        policy.setPremiumAmount(requestDTO.getPremiumAmount());
        policy.setCoverageAmount(requestDTO.getCoverageAmount());
        policy.setStartDate(requestDTO.getStartDate());
        policy.setEndDate(requestDTO.getEndDate());

        Policy updatedPolicy = policyRepository.save(policy);

        return PolicyMapper.toResponseDTO(updatedPolicy);
    }

    @Override
    public void cancelPolicy(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max) {

        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return policyRepository.findAll(pageable)
                .map(PolicyMapper::toResponseDTO);
    }
}