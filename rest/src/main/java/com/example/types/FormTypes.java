package com.example.types;

import org.flowable.bpmn.model.FormProperty;
import org.flowable.bpmn.model.FormValue;
import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.engine.form.AbstractFormType;

import java.util.LinkedHashMap;
import java.util.Map;

// 系统自带 string, bool, date, double, enum, long, month
// 自定义 textarea, select, checkbox, radio, time, datetime, upload, number
public class FormTypes extends org.flowable.engine.impl.form.FormTypes {
    AbstractFormType formType= null;
    public AbstractFormType parseFormPropertyType(FormProperty formProperty) {
        try {
            formType = super.parseFormPropertyType(formProperty);
        } catch (FlowableIllegalArgumentException e) {
            // 自定义 type
            Map<String, String> values = new LinkedHashMap<>();
            for (FormValue formValue : formProperty.getFormValues()) {
                values.put(formValue.getId(), formValue.getName());
            }

            // select
            if (formProperty.getType().equals("select")) {
                return new SelectType(values);
            }

            // textarea
            if (formProperty.getType().equals("textarea")) {
                return new TextareaType();
            }

            // checkbox
            if (formProperty.getType().equals("checkbox")) {
                return new CheckboxType(values);
            }

            // radio
            if (formProperty.getType().equals("radio")) {
                return new RadioType(values);
            }

            // time
            if (formProperty.getType().equals("time")) {
                return new TimeType();
            }

            // datetime
            if (formProperty.getType().equals("datetime")) {
                return new DateTimeType();
            }

            // upload
            if (formProperty.getType().equals("upload")) {
                return new UploadType();
            }

            // number
            if (formProperty.getType().equals("number")) {
                return new NumberType();
            }

            throw e;
        }
        return formType;
    }
}
