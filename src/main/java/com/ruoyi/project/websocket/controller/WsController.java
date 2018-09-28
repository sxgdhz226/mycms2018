package com.ruoyi.project.websocket.controller;

import com.ruoyi.project.websocket.model.RequestMessage;
import com.ruoyi.project.websocket.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage requestMessage) {
        System.out.println(requestMessage.getName());
        return new ResponseMessage("welcome " + requestMessage.getName());
    }

    @GetMapping("wsPage")
    public String wsPage() {
        return "ws";
    }

}
