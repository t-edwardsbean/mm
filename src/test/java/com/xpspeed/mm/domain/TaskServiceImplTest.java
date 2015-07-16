package com.xpspeed.mm.domain;

import com.xpspeed.mm.MarketMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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

    @Test
    public void testGetTask() throws Exception {
//        Task task = taskService.getTask("55a63b52e4b06795716651e5");
    }

    @Test
    public void testGetTask1() throws Exception {
//        Task task = taskService.getTask();
//        System.out.println(task);
    }

    @Test
    public void testSave() throws Exception {
        Task task = new Task();
        task.setPackageName("com.test");
        task.setUrl("http://dl.yiyunfushi.com/download/yuanfenba_1.4.030.apk");
        task.setName("缘分吧");
        task.setCount(200);
        task.setWeight(1);
        taskRepository.save(task);

        Task task2 = new Task();
        task2.setPackageName("com.test");
        task2.setUrl("http://dl.yiyunfushi.com/download/tongchengyuehuiba_4.1.5_020196.apk");
        task2.setName("同城约会交友吧");
        task2.setCount(1000);
        task2.setWeight(2);
        taskRepository.save(task2);
    }
}