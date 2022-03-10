package com.example.myshop.model;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account{
    private UUID id;
    private String name;
    private String password;
    private Date created_at;
}
