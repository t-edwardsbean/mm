package com.xpspeed.mm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
public class TaskHistory {

    @Id
    String id;

    String taskId;

    String time;

    Integer count;

    @Transient
    Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public TaskHistory(String id, String taskId, String time, Integer count) {
        this.id = id;
        this.taskId = taskId;
        this.time = time;
        this.count = count;
    }
}
