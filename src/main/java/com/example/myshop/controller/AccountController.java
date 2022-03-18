package com.example.myshop.controller;

import com.example.myshop.domain.Account;
import com.example.myshop.model.AccountDTO;
import com.example.myshop.model.ResponseObject;
import com.example.myshop.service.AccountService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    BCryptPasswordEncoder encoder;
    @GetMapping("/view")
    public String index(){
        return "index";
    }
    @GetMapping("/register")
    public String register(ModelMap model){
        AccountDTO dto = new AccountDTO();
        model.addAttribute("account", dto);
        return "/register";
    }
    @PostMapping("/save")
    public ModelAndView save(ModelMap model, @Validated @ModelAttribute AccountDTO dto, BindingResult result ){
        if(result.hasErrors()){
            return new ModelAndView("/register");
        }
        Account entity = new Account();
        BeanUtils.copyProperties(dto, entity);
        entity.setPassword(encoder.encode(entity.getPassword()));
        accountService.save(entity);
        model.addAttribute("message", "account is registed");

        return new ModelAndView("/index", model);
    }
    @GetMapping(value="/login")
    public String login(ModelMap model, @RequestParam String username, @RequestParam String password) {

        // AccountDTO dto = new AccountDTO();

        if(accountService.login(username, password) == null){
            return "/api/accounts/login";
        }
        
        return "forward:/api/accounts/index";
    }
    
}
