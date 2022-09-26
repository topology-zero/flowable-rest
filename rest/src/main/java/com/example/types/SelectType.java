package com.example.types;

import org.flowable.engine.form.AbstractFormType;

import java.util.Map;

public class SelectType extends AbstractFormType {

    protected Map<String, String> values;

    public SelectType(Map<String, String> values) {
        this.values = values;
    }

    @Override
    public String getName() {
        return "select";
    }

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
    public Object getInformation(String key) {
        if ("values".equals(key)) {
            return values;
        }
        return null;
    }
}
