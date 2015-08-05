package com.xpspeed.mm.controller;

import com.edwardsbean.timo.service.model.Msg;
import com.xpspeed.mm.domain.Task;
import com.xpspeed.mm.domain.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author edwardsbean
 * @date 15-8-5
 */
@RestController
@RequestMapping("/v2/api")
public class ApiV2Controller {

    @Autowired
    TaskService taskService;

    @ApiOperation(value = "获取推广任务", notes = "taskId参数为汇报已完成的任务id,可不填.failId参数为失败的任务id列表,让服务端不要返回这个任务", response = Task.class)
    @RequestMapping(value = "/getTask", method = RequestMethod.GET)
    public Msg getTask(@RequestParam(required = false) String taskId, @RequestParam(required = false) List<String> doneIds, @RequestParam(required = false) List<String> failIds) {
        return new Msg(taskService.getTask(taskId, doneIds, failIds));
    }
}
