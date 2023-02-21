package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.flowable.form.api.*;
import org.flowable.form.rest.FormRestApiInterceptor;
import org.flowable.form.rest.service.api.form.FormInstanceQueryRequest;
import org.flowable.form.rest.service.api.form.FormRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
@Slf4j
public class FormRestInterceptor implements FormRestApiInterceptor {

    @Autowired
    private HttpServletRequest request;

    @Override
    public void accessFormInfoById(FormInfo formInfo, FormRequest formRequest) {

    }

    @Override
    public void accessFormInstanceById(FormInstance formInstance) {

    }

    @Override
    public void accessFormInstanceInfoWithQuery(FormInstanceQuery formInstanceQuery, FormInstanceQueryRequest request) {

    }

    @Override
    public void storeFormInstance(FormRequest formRequest) {

    }

    @Override
    public void accessFormDefinitionInfoById(FormDefinition formDefinition) {

    }

    @Override
    public void accessFormDefinitionInfoWithQuery(FormDefinitionQuery formDefinitionQuery) {

    }

    @Override
    public void accessDeploymentById(FormDeployment deployment) {

    }

    @Override
    public void accessDeploymentsWithQuery(FormDeploymentQuery deploymentQuery) {

    }

    @Override
    public void executeNewDeploymentForTenantId(String tenantId) {

    }

    @Override
    public void enhanceDeployment(FormDeploymentBuilder deploymentBuilder) {
        deploymentBuilder.category(request.getParameter("category"));

    }

    @Override
    public void deleteDeployment(FormDeployment deployment) {

    }

    @Override
    public void accessFormManagementInfo() {

    }
}
