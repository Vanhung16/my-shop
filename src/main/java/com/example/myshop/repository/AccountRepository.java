package com.example.myshop.repository;

import java.util.UUID;

import com.example.myshop.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{
    // Iterable<Account> findByNameList<Account> findByName(String name);
}
