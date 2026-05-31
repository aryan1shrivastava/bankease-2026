package com.aryan.bankease.repository;

import com.aryan.bankease.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    // You can add custom queries later if needed
}