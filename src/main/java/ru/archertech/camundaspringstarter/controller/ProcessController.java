package ru.archertech.camundaspringstarter.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("process")
public class ProcessController {
    @Autowired
    private ProcessEngine processEngine;

    @GetMapping("{key}/start")
    public String start(@PathVariable String key) {
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(key);
        return processInstance.getId();
    }

//    @GetMapping("{key}/start")
//    public Mono<String> startAsync(@PathVariable String key) {
//        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(key);
//        return processInstance.getId();
//    }
}
