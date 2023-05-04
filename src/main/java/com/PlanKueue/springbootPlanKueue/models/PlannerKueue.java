package com.PlanKueue.springbootPlanKueue.models;

import java.util.Comparator;
import java.util.PriorityQueue;

import lombok.Getter;
import lombok.Setter;

public class PlannerKueue 
{
    @Getter
    @Setter
    private PriorityQueue<Task> planner_Queue;

    public PlannerKueue()
    {
        Comparator<Task> taskComparator = Comparator.comparing(Task::getPossiblePoints).thenComparing(Task::getDueDate);
        
        this.planner_Queue= new PriorityQueue<>(taskComparator);
    }


}
