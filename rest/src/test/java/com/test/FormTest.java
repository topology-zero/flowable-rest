package com.test;


import com.example.Application;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.FormService;
import org.flowable.engine.form.StartFormData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=Application.class)
@RunWith(value = SpringRunner.class)
@Slf4j
public class FormTest {

    @Autowired
    private FormService formService;

    @Test
    public void getForm() {
        StartFormData startFormData = formService.getStartFormData("Process_1664178530144:1:17b0612b-3d70-11ed-a6e0-38f3ab6b92c1");
        log.info("{}", startFormData);
    }
}
