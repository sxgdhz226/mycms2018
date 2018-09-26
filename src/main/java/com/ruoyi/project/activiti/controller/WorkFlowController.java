package com.ruoyi.project.activiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
