package ru.archertech.camundaspringstarter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IncrementDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(IncrementDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Integer counter = (Integer) execution.getVariable("counter");
        if (counter == null) {
            counter = 0;
        }
        counter = ++counter;
        execution.setVariable("counter", counter);
        log.info("Counter new value = {}", counter);
    }
}
