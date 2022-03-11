package com.example.myshop.service;

import com.example.myshop.domain.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    <S extends Account> S save(S entity);

    Optional<Account> findById(UUID uuid);

    boolean existsById(UUID uuid);

    long count();

    void deleteById(UUID uuid);

    void delete(Account entity);

    void deleteAllById(Iterable<? extends UUID> uuids);

    void deleteAll(Iterable<? extends Account> entities);

    void deleteAll();
}
