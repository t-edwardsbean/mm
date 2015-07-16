package com.xpspeed.mm.domain;

import java.util.List;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
public interface TaskService {

    public Task getTask(String taskId, List<String> doneIds, List<String> failId);
}
