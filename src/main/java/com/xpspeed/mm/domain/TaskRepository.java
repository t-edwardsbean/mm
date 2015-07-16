package com.xpspeed.mm.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
public interface TaskRepository extends MongoRepository<Task, String> {
}
