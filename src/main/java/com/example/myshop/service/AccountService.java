package com.example.myshop.service;

import com.example.myshop.domain.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountService {


    Account login(String username, String password);

    Account findByUsername(String username);

    List<Account> findAll();

    <S extends Account> S save(S entity);

    Optional<Account> findById(UUID uuid);

    boolean existsById(UUID uuid);

    void deleteById(UUID uuid);

    void delete(Account entity);
}
