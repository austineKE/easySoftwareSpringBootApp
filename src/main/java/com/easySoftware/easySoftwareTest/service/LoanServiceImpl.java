package com.easySoftware.easySoftwareTest.service;

import com.easySoftware.easySoftwareTest.dao.Loans;
import com.easySoftware.easySoftwareTest.model.LoansRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {



    @Override
    public List<LoanDetails> getAll(String customerId) {
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Loans");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Create our repositories
        LoansRepository bookRepository = new LoansRepository(entityManager);
        List<LoanDetails> loanDetails=new ArrayList<>();
        List<Loans> loans= bookRepository.findAll();
        for(Loans loan:loans){
            LoanDetails loanDetails1=new LoanDetails();
            loanDetails1.setAmount(loan.getAmount());
            loanDetails1.setCustomerId(loan.getCustomerId());
            loanDetails1.setInterest(loan.getInterest());
            loanDetails1.setLoanCode(loan.getLoanCode());
            loanDetails1.setLoanDate(loan.getLoanDate());
            loanDetails1.setLoanDueDate(loan.getLoanDueDate());
            loanDetails1.setTransactionId(loan.getTransactionId());
            loanDetails.add(loanDetails1);
        }
        return loanDetails;

    }

    @Override
    public LoanDetails getOne(String transactionId) {
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Loans");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Create our repositories
        LoansRepository bookRepository = new LoansRepository(entityManager);
        Loans loan = entityManager.createNamedQuery("Loans.findById", Loans.class)
                .setParameter("transactionId", transactionId)
                .getSingleResult();
        LoanDetails loanDetail=new LoanDetails();
        loanDetail.setAmount(loan.getAmount());
        loanDetail.setCustomerId(loan.getCustomerId());
        loanDetail.setInterest(loan.getInterest());
        loanDetail.setLoanCode(loan.getLoanCode());
        loanDetail.setLoanDate(loan.getLoanDate());
        loanDetail.setLoanDueDate(loan.getLoanDueDate());
        loanDetail.setTransactionId(loan.getTransactionId());
        return loanDetail;
    }

    @Override
    public Response loanPut(LoanDetails loanDetails, String transactionId) {
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Loans");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Create our repositories
        LoansRepository bookRepository = new LoansRepository(entityManager);
        try {
            Loans loans = new Loans();
            loans.setAmount(loanDetails.getAmount());
            loans.setCustomerId(transactionId);
            loans.setInterest(loanDetails.getInterest());
            loans.setLoanCode(loanDetails.getLoanCode());
            loans.setLoanDate(loanDetails.getLoanDate());
            loans.setLoanDueDate(loanDetails.getLoanDueDate());
            loans.setInterest(loanDetails.getInterest());
            bookRepository.save(loans);
        }catch (Exception ex){
            return new Response(200,"An error Occured");
        }
        return new Response(100,"Success");
    }

    @Override
    public Response loanPost(LoanDetails loanDetails) {
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Loans");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Create our repositories
        LoansRepository bookRepository = new LoansRepository(entityManager);
        try {
            Loans loans = new Loans();
            loans.setAmount(loanDetails.getAmount());
            loans.setCustomerId(loanDetails.getTransactionId());
            loans.setInterest(loanDetails.getInterest());
            loans.setLoanCode(loanDetails.getLoanCode());
            loans.setLoanDate(loanDetails.getLoanDate());
            loans.setLoanDueDate(loanDetails.getLoanDueDate());
            loans.setInterest(loanDetails.getInterest());
            bookRepository.save(loans);
        }catch (Exception ex){
            return new Response(200,"An error Occured");
        }
        return new Response(100,"Success");
    }

    @Override
    public Response loanPatch(LoanDetails loanDetails, String transactionId) {
//        try {
//            Loans loan = entityManager.createNamedQuery("Loans.findById", Loans.class)
//                    .setParameter("transactionId", transactionId)
//                    .getSingleResult();
//

//            return ResponseEntity.ok(customerPatched);
//        } catch (JsonPatchException | JsonProcessingException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        } catch (CustomerNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
        return null;
    }


}
