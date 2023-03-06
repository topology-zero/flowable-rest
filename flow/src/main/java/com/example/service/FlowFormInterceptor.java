package com.example.service;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.json.JSONUtil;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.form.api.FormInfo;
import org.flowable.form.model.SimpleFormModel;
import org.flowable.rest.service.api.FormHandlerRestApiInterceptor;
import org.flowable.rest.service.api.FormModelResponse;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.stereotype.Service;

/**
 * 不知道为什么,如果默认返回,中文会乱码,不得已使用 Base64转码返回
 */
@Service
public class FlowFormInterceptor implements FormHandlerRestApiInterceptor {

    @Override
    public String convertStartFormInfo(FormInfo formInfo, ProcessDefinition processDefinition) {
        SimpleFormModel formModel = (SimpleFormModel) formInfo.getFormModel();
        FormModelResponse formModelResponse = new FormModelResponse(formInfo, formModel);
        return Base64Encoder.encode(JSONUtil.toJsonStr(formModelResponse));
    }

    @Override
    public String convertTaskFormInfo(FormInfo formInfo, Task task) {
        SimpleFormModel formModel = (SimpleFormModel) formInfo.getFormModel();
        FormModelResponse formModelResponse = new FormModelResponse(formInfo, formModel);
        return Base64Encoder.encode(JSONUtil.toJsonStr(formModelResponse));
    }

    @Override
    public String convertHistoricTaskFormInfo(FormInfo formInfo, HistoricTaskInstance task) {
        SimpleFormModel formModel = (SimpleFormModel) formInfo.getFormModel();
        FormModelResponse formModelResponse = new FormModelResponse(formInfo, formModel);
        return Base64Encoder.encode(JSONUtil.toJsonStr(formModelResponse));
    }
}
