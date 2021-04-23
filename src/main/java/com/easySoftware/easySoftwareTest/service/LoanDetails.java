package com.easySoftware.easySoftwareTest.service;

import java.util.Date;

public class LoanDetails {
    private String transactionId;
    private double amount;
    private double interest;
    private int loanCode;
    private Date loanDate;
    private Date loanDueDate;
    private String CustomerId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(int loanCode) {
        this.loanCode = loanCode;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(Date loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }
}
