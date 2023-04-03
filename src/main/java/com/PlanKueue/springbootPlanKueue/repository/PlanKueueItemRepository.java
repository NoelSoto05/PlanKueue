package com.PlanKueue.springbootPlanKueue.repository;

import org.springframework.data.repository.CrudRepository;

import com.PlanKueue.springbootPlanKueue.models.PlanKueueItem;

//By having a CRUD repository it is easier to (Create, Read, Update, Delete) operations on the data stored without having to write the underlying persistence logic. 
public interface PlanKueueItemRepository extends CrudRepository<PlanKueueItem, Long> {

}
