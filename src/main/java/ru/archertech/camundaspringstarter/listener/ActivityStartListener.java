package ru.archertech.camundaspringstarter.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityStartListener implements ExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(ActivityStartListener.class);

    public void notify(DelegateExecution execution) throws Exception {
        log.info("Activity start listener called on {}", execution.getCurrentActivityName());
    }
}
