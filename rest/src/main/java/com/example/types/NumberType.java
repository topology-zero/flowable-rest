package com.example.types;

import org.flowable.engine.form.AbstractFormType;

import java.math.BigDecimal;

public class NumberType extends AbstractFormType {
    @Override
    public Object convertFormValueToModelValue(String propertyValue) {
        if (propertyValue == null || "".equals(propertyValue)) {
            return null;
        }
        return new BigDecimal(propertyValue);
    }

    @Override
    public String convertModelValueToFormValue(Object modelValue) {
        if (modelValue == null) {
            return null;
        }
        return modelValue.toString();
    }

    @Override
    public String getName() {
        return "number";
    }
}
