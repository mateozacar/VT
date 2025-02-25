package com.virtual.threads.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cpu")
public class CpuIntensiveController {

    @GetMapping()
    public double usePlatformThreads() throws InterruptedException {
        Thread.sleep(1000); // Simula una llamada a base de datos
        double value = 0;
        for (int j = 0; j < 10000000; j++) {
            value += Math.sin(j) * Math.cos(j);
        }
        return value;
    }
}
