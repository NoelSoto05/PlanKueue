package com.PlanKueue.springbootPlanKueue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.annotation.Validated;

import com.PlanKueue.springbootPlanKueue.models.Courses;

//By having a CRUD repository it is easier to (Create, Read, Update, Delete) operations on the data stored without having to write the underlying persistence logic. 
/**
 * save(): saves an instance of the entity to the database
 * findById(): finds an entity by its primary key
 * findAll(): finds all entities in the database
 * deleteById(): deletes an entity by its primary key
 * 
 */

@Validated
public interface CourseRepository extends CrudRepository<Courses, Long> {

}