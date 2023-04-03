package com.PlanKueue.springbootPlanKueue.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.PlanKueue.springbootPlanKueue.models.PlanKueueItem;
import com.PlanKueue.springbootPlanKueue.repository.PlanKueueItemRepository;

@Component
public class PlanKueueItemLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(PlanKueueItemLoader.class);

    @Autowired
    PlanKueueItemRepository planKueueItemRepository;

    @Override
    public void run(String... args) throws Exception {

        loadSeedData();
    }

    /*
     * start of the program we are making an instant 2 items so that we actually see
     * something in the database.
     */
    private void loadSeedData() {
        if (planKueueItemRepository.count() == 0) {
            PlanKueueItem plannerItem1 = new PlanKueueItem("get this milk");
            PlanKueueItem plannerItem2 = new PlanKueueItem("rake the leaves");

            planKueueItemRepository.save(plannerItem1);
            planKueueItemRepository.save(plannerItem2);

        }

        // lets us know for debugging purposes how many items are in the Queue
        logger.info("Number of PlanKueueItems: {}", planKueueItemRepository.count());

    }

}
