package com.example.myshop.service.impl;

import com.example.myshop.domain.Account;
import com.example.myshop.repository.AccountRepository;
import com.example.myshop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Account login(String username, String password){
        Account opt = accountRepository.findByUsername(username);
        if(opt != null || bCryptPasswordEncoder.matches(password, opt.getPassword())){
            return opt;
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public <S extends Account> S save(S entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return accountRepository.save(entity);
    }

    @Override
    public Optional<Account> findById(UUID uuid) {
        return accountRepository.findById(uuid);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return accountRepository.existsById(uuid);
    }

    @Override
    public long count() {
        return accountRepository.count();
    }

    @Override
    public void deleteById(UUID uuid) {
        accountRepository.deleteById(uuid);
    }

    @Override
    public void delete(Account entity) {
        accountRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        accountRepository.deleteAllById(uuids);
    }

    @Override
    public void deleteAll(Iterable<? extends Account> entities) {
        accountRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
