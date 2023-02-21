package com.test;

import com.example.Application;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.FormService;
import org.flowable.engine.TaskService;
import org.flowable.engine.form.StartFormData;
import org.flowable.engine.form.TaskFormData;
import org.flowable.form.api.FormInfo;
import org.flowable.form.api.FormModel;
import org.flowable.form.api.FormRepositoryService;
import org.flowable.form.model.SimpleFormModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes= Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class TaskFormTest {

    @Autowired
    private FormService formService;

    @Autowired
    private FormRepositoryService formRepositoryService;

    @Autowired
    private TaskService taskService;

    @Test
    public void getTaskForm() {
        TaskFormData taskFormData = formService.getTaskFormData("Process_1664329728907:3:c441e746-3ed6-11ed-9508-38f3ab6b92c1");
        System.out.println(taskFormData);
    }


    @Test
    public void deploy(){
        System.out.println(1);
        formRepositoryService
                .createDeployment()
                .addString("xxx.form", "{\n" +
                        "\"key\": \"form1\",\n" +
                        "\"name\": \"请假流程\",\n" +
                        "\"fields\": [\n" +
                        "            {\n" +
                        "            \"id\": \"startTime\",\n" +
                        "            \"name\": \"开始时间\",\n" +
                        "            \"type\": \"date\",\n" +
                        "            \"required\": true,\n" +
                        "            \"placeholder\": \"empty\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "            \"id\": \"days\",\n" +
                        "            \"name\": \"请假天数\",\n" +
                        "            \"type\": \"string\",\n" +
                        "            \"required\": true,\n" +
                        "            \"placeholder\": \"empty\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "            \"id\": \"reason\",\n" +
                        "            \"name\": \"请假原因\",\n" +
                        "            \"type\": \"text\",\n" +
                        "            \"required\": true,\n" +
                        "            \"placeholder\": \"empty\"\n" +
                        "            }\n" +
                        "    ]\n" +
                        "}\n")
                .name("xyz")
                .category("111")
                .deploy();
    }

    @Test
    public void getForm(){
        FormInfo formModelById = formRepositoryService.getFormModelByKey("form1");
        SimpleFormModel formModel = (SimpleFormModel)formModelById.getFormModel();
        formModel.getFields().forEach(v -> {
            System.out.println(v.getName());
            System.out.println(v.getId());
            System.out.println(v.getValue());
        });
        System.out.println(formModelById);
    }
}
