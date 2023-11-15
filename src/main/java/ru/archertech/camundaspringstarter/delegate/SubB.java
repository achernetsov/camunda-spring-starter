package ru.archertech.camundaspringstarter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubB implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(SubB.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Hi from B");
    }
}
