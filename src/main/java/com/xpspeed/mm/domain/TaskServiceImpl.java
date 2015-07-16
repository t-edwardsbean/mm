package com.xpspeed.mm.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskHistoryRepository taskHistoryRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Task getTask(String taskId, List<String> doneIds, List<String> failId) {
        //当天该任务计数+1
        if (taskId != null) {
            mongoTemplate.upsert(new Query(where("taskId").is(taskId).and("time").is(LocalDate.now().toString())), new Update().inc("count", 1), TaskHistory.class);
        }
        //权重最高的新任务
        List<Task> tasks = taskRepository.findAll();
        List<Task> sortedTasks = tasks.stream().sorted((a, b) -> a.getWeight().compareTo(b.getWeight())).collect(Collectors.toList());
        Task task = null;
        for (Task sortedTask : sortedTasks) {
            //不返回已成功的任务,不返回失败的任务
            if (sortedTask.getId().equals(taskId)  || sortedTask.getId().equals(failId) || doneIds != null && doneIds.contains(sortedTask.getId())) {
                continue;
            }
            //无限次任务
            if (sortedTask.getCount() == 0) {
                task = sortedTask;
            }
            TaskHistory taskHistory = taskHistoryRepository.findByTaskIdAndTime(sortedTask.getId(), LocalDate.now().toString());
            //取出权重最高，任务数量未完成的
            if (taskHistory == null || taskHistory.getCount() <= sortedTask.getCount()) {
                task = sortedTask;
                break;
            }
        }
        return task;
    }
}
