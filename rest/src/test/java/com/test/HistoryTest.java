package com.test;

import com.example.Application;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricDetail;
import org.flowable.task.service.HistoricTaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes= Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class HistoryTest {

    @Autowired
    private HistoryService historyService;

    @Test
    public void taskForm () {
        List<HistoricDetail> list = historyService
                .createHistoricDetailQuery()
                .variableUpdates()
                .taskId("caee952d-3ed6-11ed-9508-38f3ab6b92c1")
                .list();
        System.out.println(list);
    }
}
