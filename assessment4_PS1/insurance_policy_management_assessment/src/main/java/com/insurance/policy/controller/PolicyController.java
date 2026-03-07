package com.insurance.policy.controller;

import com.insurance.policy.dto.request.PolicyRequestDTO;
import com.insurance.policy.dto.response.PolicyResponseDTO;
import com.insurance.policy.service.PolicyService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public PolicyResponseDTO createPolicy(@Valid @RequestBody PolicyRequestDTO requestDTO) {
        return policyService.createPolicy(requestDTO);
    }

    @GetMapping
    public Page<PolicyResponseDTO> getAllPolicies(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        return policyService.getAllPolicies(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(
            @PathVariable Long id,
            @Valid @RequestBody PolicyRequestDTO requestDTO) {

        return policyService.updatePolicy(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void cancelPolicy(@PathVariable Long id) {
        policyService.cancelPolicy(id);
    }

    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getPoliciesByType(@PathVariable String type) {
        return policyService.getPoliciesByType(type);
    }

    @GetMapping("/premium")
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(
            @RequestParam Double min,
            @RequestParam Double max) {

        return policyService.getPoliciesByPremiumRange(min, max);
    }
}