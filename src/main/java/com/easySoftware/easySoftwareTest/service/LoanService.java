package com.easySoftware.easySoftwareTest.service;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface LoanService {
    List<LoanDetails> getAll(String customerId);
    LoanDetails getOne(String transactionId);
    Response loanPut(LoanDetails loanDetails, String transactionId);
    Response loanPost(LoanDetails loanDetails);
    Response loanPatch(LoanDetails loanDetails, String transactionId);
}
