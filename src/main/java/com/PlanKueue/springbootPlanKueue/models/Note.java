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

// TO FIX: ADJUST TABLES, NEED BRIDGE NODE: NOTE CAN BE ATTACHED TO
//         EVENT, OR NOTE, OR NOTHING, DIFFERENTIATE SOMEHOW
    @ManyToOne
    @JoinColumn(name = "not_assignmentID", referencedColumnName = "assignmentId")
    private Task not_assignmentId;

    @ManyToOne
    @JoinColumn(name = "not_iD", referencedColumnName = "id")
    private Event not_id;

    @ManyToOne
    @JoinColumn(name = "not_accountId", referencedColumnName = "accountId")
    private Account not_accountId;

    //Default Constructor
    public Note() {}

    //Parameterized Constructor attached to account
    public Note(String noteDesc, Long not_accountId){
        
    }
    //Parameterized Constructor attached to something
    public Note(String noteDesc, Long id, Long not_accountId){

    }
}
