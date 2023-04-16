package com.PlanKueue.springbootPlanKueue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "Account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long accountId;

    @Getter
    @Setter
    @NotBlank(message = "Username required")
    private String username;

    @Getter
    @Setter
    @NotBlank(message = "Password required")
    private String password;

    //Default Constructor, should link to <html> for user to fill out username and password
    public Account(){

    }
}
