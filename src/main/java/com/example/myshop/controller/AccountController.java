package com.example.myshop.controller;

import com.example.myshop.model.Account;
import com.example.myshop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;


}
