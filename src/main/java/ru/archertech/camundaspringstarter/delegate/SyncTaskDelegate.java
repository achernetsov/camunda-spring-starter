package ru.archertech.camundaspringstarter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.archertech.camundaspringstarter.ResultHolder;

import java.util.concurrent.CompletableFuture;

@Service
public class SyncTaskDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(SayHelloDelegate.class);

    @Autowired
    private ResultHolder resultHolder;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String businessKey = delegateExecution.getBusinessKey();
        CompletableFuture<String> completableFuture = resultHolder.resultsByBusinessKey.get(businessKey);
        completableFuture.complete("result!");
        log.info("Sync task is completed!");
    }
}