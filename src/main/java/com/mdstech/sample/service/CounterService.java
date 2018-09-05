package com.mdstech.sample.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CounterService {
    private AtomicInteger atomicInteger = new AtomicInteger();

    public Integer increment() {
        return atomicInteger.incrementAndGet();
    }
}
