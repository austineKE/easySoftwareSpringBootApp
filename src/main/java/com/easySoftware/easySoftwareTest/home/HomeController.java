package com.easySoftware.easySoftwareTest.home;


import com.easySoftware.easySoftwareTest.service.LoanDetails;
import com.easySoftware.easySoftwareTest.service.LoanService;
import com.easySoftware.easySoftwareTest.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    final
    private LoanService loanService;

    @Autowired
    public HomeController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loanList/{customer_id}")
    List<LoanDetails> getLoanList(@PathVariable(value = "customer_id") String customerId) {
        return loanService.getAll(customerId);
    }

    @GetMapping("/loan/{transaction_id}")
    LoanDetails getLoan(@PathVariable(value = "transaction_id") String transactionId) {
        return loanService.getOne(transactionId);
    }

    @PutMapping("/loanPut/{transactionId}")
    Response loanPut(@RequestBody LoanDetails loanDetails, @PathVariable("id") String transactionId) {
        return loanService.loanPut(loanDetails,transactionId);
    }

    @PostMapping("/loanPost")
    Response loanPost(@RequestBody LoanDetails loanDetails) {
        return loanService.loanPost(loanDetails);
    }

    @PatchMapping("/loanPatch/{transactionId}")
    Response loanPatch(@RequestBody LoanDetails loanDetails, @PathVariable("id") String transactionId) {
        return loanService.loanPatch(loanDetails,transactionId);
    }


}
