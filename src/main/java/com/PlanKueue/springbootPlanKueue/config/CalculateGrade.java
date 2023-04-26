package com.PlanKueue.springbootPlanKueue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;
import com.PlanKueue.springbootPlanKueue.models.Task;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


/**
 * CalculateGrade for a desires class
 */
public class CalculateGrade
{
    private static final String List = null;

	@Autowired
    TaskRepository taskRepository;

    @Getter
    @Setter
    private double calculatedGrade;

    /**
     * when we load our program we want to calculate the grade for the class
     * This should happen again once the user adds another assignment or task for that class
     * that has points associated with it. 
     */

   private void updateCalculationForGrade(){

      Iterable<Task> tasks =  taskRepository.findAll();
      Iterator<Task> iterator = tasks.iterator();

    
    while (iterator.hasNext()) {

        Task task = iterator.next();
        // perform the calculation for the grade of the current task
        // using task.getGrade() and any other necessary data



    }




   }





    
}