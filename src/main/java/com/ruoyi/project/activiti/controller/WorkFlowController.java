package com.ruoyi.project.activiti.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@Controller
@RequestMapping("/activiti")
public class WorkFlowController {

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


}
