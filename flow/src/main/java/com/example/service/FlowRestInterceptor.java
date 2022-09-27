package com.example.service;

import org.flowable.batch.api.Batch;
import org.flowable.batch.api.BatchPart;
import org.flowable.batch.api.BatchQuery;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.engine.form.FormData;
import org.flowable.engine.history.*;
import org.flowable.engine.repository.*;
import org.flowable.engine.runtime.*;
import org.flowable.eventsubscription.api.EventSubscription;
import org.flowable.eventsubscription.api.EventSubscriptionQuery;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.api.User;
import org.flowable.idm.api.UserQuery;
import org.flowable.job.api.*;
import org.flowable.rest.service.api.BpmnRestApiInterceptor;
import org.flowable.rest.service.api.form.SubmitFormRequest;
import org.flowable.rest.service.api.history.*;
import org.flowable.rest.service.api.identity.GroupRequest;
import org.flowable.rest.service.api.identity.UserRequest;
import org.flowable.rest.service.api.repository.ModelRequest;
import org.flowable.rest.service.api.runtime.process.*;
import org.flowable.rest.service.api.runtime.task.TaskActionRequest;
import org.flowable.rest.service.api.runtime.task.TaskQueryRequest;
import org.flowable.rest.service.api.runtime.task.TaskRequest;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.flowable.task.api.history.HistoricTaskLogEntryQuery;
import org.flowable.variable.api.history.HistoricVariableInstance;
import org.flowable.variable.api.history.HistoricVariableInstanceQuery;
import org.springframework.stereotype.Service;


@Service
public class FlowRestInterceptor implements BpmnRestApiInterceptor {


    @Override
    public void accessTaskInfoById(Task task) {

    }

    @Override
    public void accessTaskInfoWithQuery(TaskQuery taskQuery, TaskQueryRequest request) {

    }

    @Override
    public void createTask(Task task, TaskRequest request) {

    }

    @Override
    public void updateTask(Task task, TaskRequest request) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public void executeTaskAction(Task task, TaskActionRequest actionRequest) {
        Authentication.setAuthenticatedUserId("1");
    }

    @Override
    public void accessExecutionInfoById(Execution execution) {

    }

    @Override
    public void accessExecutionInfoWithQuery(ExecutionQuery executionQuery, ExecutionQueryRequest request) {

    }

    @Override
    public void doExecutionActionRequest(ExecutionActionRequest executionActionRequest) {

    }

    @Override
    public void accessProcessInstanceInfoById(ProcessInstance processInstance) {

    }

    @Override
    public void accessProcessInstanceInfoWithQuery(ProcessInstanceQuery processInstanceQuery, ProcessInstanceQueryRequest request) {

    }

    @Override
    public void createProcessInstance(ProcessInstanceBuilder processInstanceBuilder, ProcessInstanceCreateRequest request) {

    }

    @Override
    public void updateProcessInstance(ProcessInstance processInstance, ProcessInstanceUpdateRequest updateRequest) {

    }

    @Override
    public void deleteProcessInstance(ProcessInstance processInstance) {

    }

    @Override
    public void sendSignal(SignalEventReceivedRequest signalEventReceivedRequest) {

    }

    @Override
    public void changeActivityState(ExecutionChangeActivityStateRequest changeActivityStateRequest) {

    }

    @Override
    public void migrateProcessInstance(String processInstanceId, String migrationDocument) {

    }

    @Override
    public void migrateInstancesOfProcessDefinition(ProcessDefinition processDefinition, String migrationDocument) {

    }

    @Override
    public void injectActivity(InjectActivityRequest injectActivityRequest) {

    }

    @Override
    public void accessEventSubscriptionById(EventSubscription eventSubscription) {

    }

    @Override
    public void accessEventSubscriptionInfoWithQuery(EventSubscriptionQuery eventSubscriptionQuery) {

    }

    @Override
    public void accessProcessDefinitionById(ProcessDefinition processDefinition) {

    }

    @Override
    public void accessProcessDefinitionsWithQuery(ProcessDefinitionQuery processDefinitionQuery) {

    }

    @Override
    public void accessDeploymentById(Deployment deployment) {

    }

    @Override
    public void accessDeploymentsWithQuery(DeploymentQuery deploymentQuery) {

    }

    @Override
    public void executeNewDeploymentForTenantId(String tenantId) {

    }

    @Override
    public void enhanceDeployment(DeploymentBuilder deploymentBuilder) {
//        String cate = request.getParameter("category");
//        deploymentBuilder.category(cate);
    }

    @Override
    public void deleteDeployment(Deployment deployment) {

    }

    @Override
    public void accessModelInfoById(Model model) {

    }

    @Override
    public void accessModelInfoWithQuery(ModelQuery modelQuery) {

    }

    @Override
    public void createModel(Model model, ModelRequest request) {

    }

    @Override
    public void accessJobInfoById(Job job) {

    }

    @Override
    public void accessHistoryJobInfoById(HistoryJob job) {

    }

    @Override
    public void accessJobInfoWithQuery(JobQuery jobQuery) {

    }

    @Override
    public void accessTimerJobInfoWithQuery(TimerJobQuery jobQuery) {

    }

    @Override
    public void accessSuspendedJobInfoWithQuery(SuspendedJobQuery jobQuery) {

    }

    @Override
    public void accessDeadLetterJobInfoWithQuery(DeadLetterJobQuery jobQuery) {

    }

    @Override
    public void accessHistoryJobInfoWithQuery(HistoryJobQuery jobQuery) {

    }

    @Override
    public void deleteJob(Job job) {

    }

    @Override
    public void deleteHistoryJob(HistoryJob historyJob) {

    }

    @Override
    public void accessBatchInfoById(Batch batch) {

    }

    @Override
    public void accessBatchInfoWithQuery(BatchQuery batchQuery) {

    }

    @Override
    public void deleteBatch(Batch batch) {

    }

    @Override
    public void accessBatchPartInfoOfBatch(Batch batch) {

    }

    @Override
    public void accessBatchPartInfoById(BatchPart batchPart) {

    }

    @Override
    public void accessManagementInfo() {

    }

    @Override
    public void accessTableInfo() {

    }

    @Override
    public void accessHistoryTaskInfoById(HistoricTaskInstance historicTaskInstance) {

    }

    @Override
    public void accessHistoryTaskInfoWithQuery(HistoricTaskInstanceQuery historicTaskInstanceQuery, HistoricTaskInstanceQueryRequest request) {

    }

    @Override
    public void deleteHistoricTask(HistoricTaskInstance historicTaskInstance) {

    }

    @Override
    public void accessHistoryProcessInfoById(HistoricProcessInstance historicProcessInstance) {

    }

    @Override
    public void accessHistoryProcessInfoWithQuery(HistoricProcessInstanceQuery historicProcessInstanceQuery, HistoricProcessInstanceQueryRequest request) {

    }

    @Override
    public void deleteHistoricProcess(HistoricProcessInstance historicProcessInstance) {

    }

    @Override
    public void accessHistoryActivityInfoWithQuery(HistoricActivityInstanceQuery historicActivityInstanceQuery, HistoricActivityInstanceQueryRequest request) {

    }

    @Override
    public void accessHistoryDetailById(HistoricDetail historicDetail) {

    }

    @Override
    public void accessHistoryDetailInfoWithQuery(HistoricDetailQuery historicDetailQuery, HistoricDetailQueryRequest request) {

    }

    @Override
    public void accessHistoryVariableInfoById(HistoricVariableInstance historicVariableInstance) {

    }

    @Override
    public void accessHistoryVariableInfoWithQuery(HistoricVariableInstanceQuery historicVariableInstanceQuery, HistoricVariableInstanceQueryRequest request) {

    }

    @Override
    public void accessHistoricTaskLogWithQuery(HistoricTaskLogEntryQuery historicTaskLogEntryQuery, HistoricTaskLogEntryQueryRequest request) {

    }

    @Override
    public void accessGroupInfoById(Group group) {

    }

    @Override
    public void accessGroupInfoWithQuery(GroupQuery groupQuery) {

    }

    @Override
    public void createGroup(GroupRequest groupRequest) {

    }

    @Override
    public void deleteGroup(Group group) {

    }

    @Override
    public void accessUserInfoById(User user) {

    }

    @Override
    public void accessUserInfoWithQuery(UserQuery userQuery) {

    }

    @Override
    public void createUser(UserRequest userRequest) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void accessFormData(FormData formData) {

    }

    @Override
    public void submitFormData(SubmitFormRequest formRequest) {

    }
}


