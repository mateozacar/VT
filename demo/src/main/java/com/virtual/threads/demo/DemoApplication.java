package com.virtual.threads.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		SpringApplication.run(DemoApplication.class, args);
	}

}
