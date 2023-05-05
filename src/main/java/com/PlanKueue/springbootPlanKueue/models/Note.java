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


    //Default Constructor
    public Note() {}

    //Parameterized Constructor attached to account
    public Note(String noteDesc){
        this.noteDesc = noteDesc;
    }


    // getters and setters for id, noteDesc, and account omitted for brevity
}
