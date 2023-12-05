package ru.archertech.camundaspringstarter.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.archertech.camundaspringstarter.ResultHolder;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("process")
public class ProcessController {
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private ResultHolder resultHolder;

    @GetMapping("{key}/start")
    public String start(@PathVariable String key) {
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(key);
        return processInstance.getId();
    }

    /**
     * Calls BP using signal; waits for completion of activity
     */
    @GetMapping("{key}/startSync")
    public String syncBpCall(@PathVariable String key) {
        String businessKey = UUID.randomUUID().toString();

        CompletableFuture<String> awaitingResult = new CompletableFuture<>();
        resultHolder.resultsByBusinessKey.put(businessKey, awaitingResult);

        processEngine.getRuntimeService().startProcessInstanceByMessage("Message_Start", businessKey);
        try {
            return awaitingResult.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
