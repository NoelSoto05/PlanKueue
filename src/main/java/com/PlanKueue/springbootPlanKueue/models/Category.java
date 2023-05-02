package com.PlanKueue.springbootPlanKueue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long categoryId;

    @Getter
    @Setter
    private String categoryName;

    @Getter
    @Setter
    private double percentage;

    public Category(){};

    public Category(String name, double percentage){
        categoryName = name;
        this.percentage = percentage;
    }
}
