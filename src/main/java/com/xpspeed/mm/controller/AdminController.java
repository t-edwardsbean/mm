package com.xpspeed.mm.controller;

import com.xpspeed.mm.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author edwardsbean
 * @date 15-7-16
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskHistoryRepository taskHistoryRepository;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> tasks() {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/taskHistories", method = RequestMethod.GET)
    public List<TaskHistory> taskHistoies() {
        List<TaskHistory> taskHistories = taskHistoryRepository.findAll();
        taskHistories.forEach(taskHistory -> taskHistory.setTask(taskRepository.findOne(taskHistory.getTaskId())));
        return taskHistories;
    }

    @RequestMapping(value = "/taskHistories/{id}", method = RequestMethod.DELETE)
    public String deleteTaskHistoies(@PathVariable String id) {
        taskHistoryRepository.delete(id);
        return "{\"message\":\"ok\"}";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public void save(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public void update(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        taskRepository.delete(id);
        taskHistoryRepository.deleteByTaskId(id);
        return "{\"message\":\"ok\"}";
    }
}
