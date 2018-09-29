package com.ruoyi.project.activiti.service.impl;

import com.ruoyi.project.activiti.entity.LeaveBill;
import com.ruoyi.project.activiti.entity.WorkflowBean;
import com.ruoyi.project.activiti.service.IWorkflowService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

@Service("WorkflowServiceImpl")
public class WorkflowServiceImpl implements IWorkflowService {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public void saveNewDeploye(MultipartFile file, String filename) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream());
            repositoryService.createDeployment().name(filename)
                    .addZipInputStream(zipInputStream).deploy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Deployment> findDeploymentList() {
        return repositoryService.createDeploymentQuery().orderByDeploymenTime().asc().list();
    }

    @Override
    public List<ProcessDefinition> findProcessDefinitionList() {

        return repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionVersion().asc().list();
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
