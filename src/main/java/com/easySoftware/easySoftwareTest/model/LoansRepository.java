package com.easySoftware.easySoftwareTest.model;

import com.easySoftware.easySoftwareTest.dao.Loans;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class LoansRepository {

    private EntityManager entityManager;
    public LoansRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Optional<Loans> findById(Integer id) {
        Loans Loans = entityManager.find(Loans.class, id);
        return Loans != null ? Optional.of(Loans) : Optional.empty();
    }

    public List<Loans> findAll() {
        return entityManager.createQuery("from Loans").getResultList();
    }
    public Optional<Loans> save(Loans Loans) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(Loans);
            entityManager.getTransaction().commit();
            return Optional.of(Loans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
