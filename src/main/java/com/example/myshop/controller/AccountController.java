package com.example.myshop.controller;

import com.example.myshop.domain.Account;
import com.example.myshop.model.AccountDTO;

import com.example.myshop.model.LoginAccount;
import com.example.myshop.service.AccountService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    HttpSession session;

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
    public ModelAndView save(ModelMap model,@ModelAttribute AccountDTO dto ){
        Account entity = new Account();
        BeanUtils.copyProperties(dto, entity);
        entity.setPassword(encoder.encode(entity.getPassword()));
        accountService.save(entity);
        model.addAttribute("message", "account is registed");

        return new ModelAndView("/index", model);
    }
    @GetMapping(value="/login")
    public String login(ModelMap model) {

        LoginAccount dto = new LoginAccount();
        model.addAttribute("account", dto);
        return "/login";
    }
    @PostMapping("/login")
    public ModelAndView login(ModelMap model, @Validated @ModelAttribute("account") LoginAccount dto, BindingResult result){

        if(result.hasErrors()){
            return new ModelAndView("/login", model);
        }

        Account account = accountService.login(dto.getUsername(), dto.getPassword());
        System.out.print(account);
        if(account == null)  {
            model.addAttribute("message", "password or username not true");
            return new ModelAndView("/login", model);
        }
        session.setAttribute("username", account.getUsername());
        return new ModelAndView("/index", model);

    }
    
}
