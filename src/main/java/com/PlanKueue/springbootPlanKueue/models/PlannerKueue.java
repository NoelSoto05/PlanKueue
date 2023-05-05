package com.PlanKueue.springbootPlanKueue.models;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Component
public class PlannerKueue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long plannerKueueId;

    @Getter
    @Setter
    private PriorityQueue<Task> general_Planner_Queue;

    @Getter
    @Setter
    private PriorityQueue<Task> daily_Planner_Queue;

    public PlannerKueue() {
        // Comparator<Task> taskComparator =
        // Comparator.comparing(Task::getPossiblePoints).reversed().thenComparing(Task::getDueDate);
        Comparator<Task> taskComparator = Comparator.comparing(Task::getPossiblePoints, Comparator.reverseOrder());

        this.general_Planner_Queue = new PriorityQueue<Task>(taskComparator);

        this.daily_Planner_Queue = new PriorityQueue<Task>(taskComparator);
    }

    public void addTask(Task assignment, String today) {
        if (!assignment.isCompleted()) {
            general_Planner_Queue.add(assignment);

            if (assignment.getDueDate().equals(today)) {
                daily_Planner_Queue.add(assignment);
            }
        }
    }

}
