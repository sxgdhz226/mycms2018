package com.ruoyi.project.activiti.service.impl;

import com.ruoyi.project.activiti.entity.LeaveBill;
import com.ruoyi.project.activiti.entity.WorkflowBean;
import com.ruoyi.project.activiti.service.IWorkflowService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service("WorkflowServiceImpl")
public class WorkflowServiceImpl implements IWorkflowService {

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void saveNewDeploye(File file, String filename) {

    }

    @Override
    public List<Deployment> findDeploymentList() {
        return null;
    }

    @Override
    public List<ProcessDefinition> findProcessDefinitionList() {
        return null;
    }

    @Override
    public InputStream findImageInputStream(String deploymentId, String imageName) {
        return null;
    }

    @Override
    public void deleteProcessDefinitionByDeploymentId(String deploymentId) {

    }

    @Override
    public void saveStartProcess(WorkflowBean workflowBean) {

    }

    @Override
    public void saveProcess(WorkflowBean workflowBean) {

    }

    @Override
    public List<Task> findTaskListByName(String name) {
        return null;
    }

    @Override
    public String findTaskFormKeyByTaskId(String taskId) {
        return null;
    }

    @Override
    public LeaveBill findLeaveBillByTaskId(String taskId) {
        return null;
    }

    @Override
    public List<String> findOutComeListByTaskId(String taskId) {
        return null;
    }

    @Override
    public void saveSubmitTask(WorkflowBean workflowBean) {

    }

    @Override
    public List<Comment> findCommentByTaskId(String taskId) {
        return null;
    }

    @Override
    public List<Comment> findCommentByLeaveBillId(Long id) {
        return null;
    }

    @Override
    public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
        return null;
    }

    @Override
    public Map<String, Object> findCoordingByTask(String taskId) {
        return null;
    }
}
