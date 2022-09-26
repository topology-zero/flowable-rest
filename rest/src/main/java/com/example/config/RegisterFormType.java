package com.example.config;

import com.example.types.FormTypes;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RegisterFormType {

    @Autowired
    private ProcessEngineConfigurationImpl processEngineConfiguration;

    @PostConstruct
    public void registerFormType() {
        FormTypes formTypes = new FormTypes();
        formTypes.addFormType(new StringFormType());
        formTypes.addFormType(new LongFormType());
        formTypes.addFormType(new DateFormType("dd/MM/yyyy"));
        formTypes.addFormType(new BooleanFormType());
        formTypes.addFormType(new DoubleFormType());
        processEngineConfiguration.setFormTypes(formTypes);
    }
}
