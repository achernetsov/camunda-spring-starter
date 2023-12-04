package ru.archertech.camundaspringstarter.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestartEndListener implements ExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(RestartEndListener.class);

    public void notify(DelegateExecution execution) throws Exception {
        log.info("Got restart event");
    }
}
