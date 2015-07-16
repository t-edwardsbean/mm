package com.xpspeed.mm.domain;

import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author edwardsbean
 * @date 15-7-15
 */
public interface TaskHistoryRepository extends MongoRepository<TaskHistory, String> {
    TaskHistory findByTaskIdAndTime(String taskId, String time);
}
