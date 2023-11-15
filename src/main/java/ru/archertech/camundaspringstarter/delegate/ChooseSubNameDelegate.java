package ru.archertech.camundaspringstarter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChooseSubNameDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(ChooseSubNameDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String subName = "A";
        delegateExecution.setVariable("subName", subName);
        log.info("Chosen sub name: {}", subName);
    }
}
