package com.example.types;

import org.flowable.engine.form.AbstractFormType;

public class TimeType extends AbstractFormType {
    @Override
    public Object convertFormValueToModelValue(String propertyValue) {
        if (propertyValue == null || "".equals(propertyValue)) {
            return null;
        }
        return propertyValue;
    }

    @Override
    public String convertModelValueToFormValue(Object modelValue) {
        if (modelValue == null) {
            return null;
        }
        return (String) modelValue;
    }

    @Override
    public String getName() {
        return "time";
    }
}
