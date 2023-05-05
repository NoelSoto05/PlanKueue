package com.PlanKueue.springbootPlanKueue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "note")
public class Note {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id; 

    @Getter
    @Setter
    private String noteDesc;

    @ManyToOne // define a many-to-one relationship between Note and Account
    @jakarta.persistence.JoinColumn(name = "account_id")
    @Getter
    @Setter
    private Account account;

    //Default Constructor
    public Note() {}

    //Parameterized Constructor attached to account
    public Note(String noteDesc, Account account){
        this.noteDesc = noteDesc;
        this.account = account;
    }

    //Parameterized Constructor attached to something
    public Note(String noteDesc, Long id, Account account){
        this.noteDesc = noteDesc;
        this.id = id;
        this.account = account;
    }

    // getters and setters for id, noteDesc, and account omitted for brevity
}
