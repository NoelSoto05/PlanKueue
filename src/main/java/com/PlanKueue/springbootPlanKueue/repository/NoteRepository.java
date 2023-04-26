package com.PlanKueue.springbootPlanKueue.repository;

import org.springframework.data.repository.CrudRepository;

import com.PlanKueue.springbootPlanKueue.models.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
    
}