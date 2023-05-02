package com.PlanKueue.springbootPlanKueue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "note")
public class Note {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long noteId; 

    @Getter
    @Setter
    private String noteDesc;

    //Default Constructor
    public Note() {}

    //Parameterized Constructor attached to account
    public Note(String noteDesc, Long not_accountId){
        
    }
    //Parameterized Constructor attached to something
    public Note(String noteDesc, Long id, Long not_accountId){

    }
}
