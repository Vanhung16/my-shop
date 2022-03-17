package com.example.myshop.controller;

import com.example.myshop.domain.Account;
import com.example.myshop.model.ResponseObject;
import com.example.myshop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/view")
    public String index(){
        return "index";
    }
}
