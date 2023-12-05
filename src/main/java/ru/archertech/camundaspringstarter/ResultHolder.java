package ru.archertech.camundaspringstarter;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ResultHolder {
    public Map<String, CompletableFuture<String>> resultsByBusinessKey = new ConcurrentHashMap<>();
}
