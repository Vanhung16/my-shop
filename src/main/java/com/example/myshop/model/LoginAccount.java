package com.example.myshop.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginAccount {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
