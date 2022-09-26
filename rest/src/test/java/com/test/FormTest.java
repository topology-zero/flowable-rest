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
        StartFormData startFormData = formService.getStartFormData("Process_1663924286899:5:c79fb200-3d6b-11ed-9313-38f3ab6b92c1");
        log.info("{}", startFormData);
    }
}
