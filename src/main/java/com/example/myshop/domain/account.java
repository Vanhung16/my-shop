package com.example.myshop.domain;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "name", columnDefinition = "nvarchar(20) not null")
    private String name;
    @Column(name = "username", columnDefinition = "nvarchar(20) not null")
    private String username;
    @Column(name = "password", length = 60, nullable = false)
    private String password;
    @Column(name = "email", columnDefinition ="nvarchar(50) not null")
    private String email;
    
}
