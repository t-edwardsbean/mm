package com.xpspeed.mm.controller;

import com.edwardsbean.timo.service.model.Msg;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpspeed.mm.domain.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
@RestController
@RequestMapping("/v1/api")
public class ApiV1Controller {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskHistoryRepository taskHistoryRepository;

    @ApiOperation(value = "获取推广任务", notes = "taskId参数为汇报已完成的任务id,可不填.failId参数为失败的任务id列表,让服务端不要返回这个任务", response = Task.class)
    @RequestMapping(value = "/getTask", method = RequestMethod.GET)
    public Msg getTask(@RequestParam(required = false) String taskId, @RequestParam(required = false) List<String> doneIds, @RequestParam(required = false) List<String> failIds) {
        Task task = taskService.getTask(taskId, doneIds, failIds);
        if (task != null) {
            task.setWeight(null);
            task.setCount(null);
        }
        return new Msg(task);
    }

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
