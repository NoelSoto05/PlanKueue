package com.PlanKueue.springbootPlanKueue.repository;

import org.springframework.data.repository.CrudRepository;

import com.PlanKueue.springbootPlanKueue.models.PlanKueueItem;

public interface PlanKueueItemRepository extends CrudRepository<PlanKueueItem, Long> {

}
