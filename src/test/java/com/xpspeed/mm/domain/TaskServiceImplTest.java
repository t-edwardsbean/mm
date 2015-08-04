package com.xpspeed.mm.domain;

import com.xpspeed.mm.MarketMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MarketMain.class)
@WebAppConfiguration
public class TaskServiceImplTest {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TypeRepository typeRepository;

    @Test
    public void testGetTask() throws Exception {
        Task task = taskService.getTask(null, null, null);
        System.out.println(task);
    }

    @Test
    public void testGetTask1() throws Exception {
        Task taska = new Task();
        taska.setWeight(10);
        Task taskb = new Task();
        taskb.setWeight(7);
        List<Task> tasks = Arrays.asList(taska, taskb).stream().sorted((a, b) -> a.getWeight().compareTo(b.getWeight())).collect(Collectors.toList());
        System.out.println(tasks);
    }

    @Test
    public void testSave() throws Exception {
//        Task task = new Task();
//        task.setPackageName("com.test");
//        task.setUrl("http://dl.yiyunfushi.com/download/yuanfenba_1.4.030.apk");
//        task.setName("缘分吧");
//        task.setCount(200);
//        task.setWeight(1);
//        taskRepository.save(task);

        Task task2 = new Task();
        task2.setPackageName("com.test");
        task2.setUrl("http://dl.yiyunfushi.com/download/tongchengyuehuiba_4.1.5_020196.apk");
        task2.setName("同城约会交友吧");
        task2.setCount(1000);
        task2.setWeight(2);
        Type type = new Type();
        type.setId("55c0a76774d2b1b6d91fdfaa");
        task2.setType(type);
        taskRepository.save(task2);
    }

    @Test
    public void testType() throws Exception {
        Type type = new Type();
        type.setName("网页");
        typeRepository.save(type);
    }
}