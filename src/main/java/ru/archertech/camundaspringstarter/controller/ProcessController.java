package ru.archertech.camundaspringstarter.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("process")
public class ProcessController {
    @Autowired
    private ProcessEngine processEngine;

    @GetMapping("{key}/start")
    public StartedProcess start(@PathVariable String key) {
        String businessKey = UUID.randomUUID().toString();
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(key, businessKey);

        return new StartedProcess(processInstance.getId(), businessKey);
    }

    @GetMapping("{businessKey}/signal")
    public void signal(@PathVariable String businessKey, @RequestParam String message) {
        processEngine.getRuntimeService().correlateMessage(message, businessKey);
    }

    public record StartedProcess(String processId, String busynessKey){};
}
