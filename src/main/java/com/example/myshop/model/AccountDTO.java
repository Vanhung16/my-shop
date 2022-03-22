package com.example.myshop.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO{
    private String username;
    private String name;
    private String password;
    private String email;
}
