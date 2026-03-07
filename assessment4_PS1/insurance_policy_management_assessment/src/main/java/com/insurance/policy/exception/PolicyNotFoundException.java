package com.insurance.policy.exception;

public class PolicyNotFoundException extends RuntimeException {

    public PolicyNotFoundException(String message) {
        super(message);
    }
}