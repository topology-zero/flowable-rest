package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.flowable.engine.form.FormData;
import org.flowable.engine.form.FormProperty;
import org.flowable.rest.service.api.form.FormDataResponse;
import org.flowable.rest.service.api.form.RestEnumFormProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class EnhanceForm {

    /**
     * 增强自定义参数的返回
     */
    @Around("execution(* org.flowable.rest.service.api.RestResponseFactory.createFormDataResponse(..))")
    public Object enhance(ProceedingJoinPoint jp) throws Throwable {
        FormData formData = (FormData) jp.getArgs()[0];
        Object proceed = jp.proceed(new Object[]{formData});
        FormDataResponse res = (FormDataResponse) proceed;
        List<FormProperty> formProperties = formData.getFormProperties();
        for (int i = 0; i < formProperties.size(); i++) {
            FormProperty formProperty = formProperties.get(i);
            Object values = formProperty.getType().getInformation("values");
            if (values == null) {
                continue;
            }

            Map<String, String> enumValues = (Map<String, String>) values;
            for (String enumId : enumValues.keySet()) {
                RestEnumFormProperty enumProperty = new RestEnumFormProperty();
                enumProperty.setId(enumId);
                enumProperty.setName(enumValues.get(enumId));
                res.getFormProperties().get(i).addEnumValue(enumProperty);
            }
        }
        return res;
    }
}
