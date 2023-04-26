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

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "assignmentId")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    //Default Constructor
    public Note() {}

    //Parameterized Constructor attached to account
    public Note(String noteDesc, Account account){
        this.noteDesc = noteDesc;
        this.account = account;
    }

    //Parameterized Constructor attached to task
    public Note(String noteDesc, Task task, Account account){
        this.noteDesc = noteDesc;
        this.task = task;
        this.account = account;
    }

    //Parameterized Constructor attached to event
    public Note(String noteDesc, Event event, Account account){
        this.noteDesc = noteDesc;
        this.event = event;
        this.account = account;
    }
}