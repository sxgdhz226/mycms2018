package com.ruoyi.project.activiti.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.activiti.service.IWorkflowService;
import com.ruoyi.project.system.menu.domain.Menu;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程管理控制器
 */
@Controller
@RequestMapping("/activiti")
public class WorkFlowController {

    @Autowired
    private IWorkflowService workflowService;

    @GetMapping()
    public String deployHome(){
        return "workflow/workflow";
    }

    @RequiresPermissions("activiti:processDefine:view")
    @GetMapping("processDefine")
    public String processDefine(){
        return "workflow/workflow";
    }

    @GetMapping("historyProcess")
    public String historyProcess(){
        return "workflow/workflow";
    }


    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AjaxResult uploadProcessDefineFile(@RequestParam("processFile")  MultipartFile file){
        try {
            workflowService.saveNewDeploye(file,file.getOriginalFilename());
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return AjaxResult.error();
    }

    @PostMapping("/list")
    @ResponseBody
    public Object findDeploymentList()
    {
        List<Map<String,Object>> result = new ArrayList<>();
        //1:查询部署对象信息，对应表（act_re_deployment）
        List<Deployment> depList = workflowService.findDeploymentList();
        //2:查询流程定义的信息，对应表（act_re_procdef）
        List<ProcessDefinition> pdList = workflowService.findProcessDefinitionList();

        pdList.forEach(e -> {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name",e.getName());
            map.put("key",e.getKey());
            map.put("version",e.getVersion());
            map.put("resourceName",e.getResourceName());
            map.put("deploymentId",e.getDeploymentId());
            map.put("diagramResourceName",e.getDiagramResourceName());
            result.add(map);
        });

//        JSONObject json = new JSONObject();
//        json.put("totalLength", 2);
//        json.put("dataList", result);
//        return json;
        return result;
    }

}
