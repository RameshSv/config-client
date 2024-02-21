package com.spring.io.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class ConfigClientApplication {

	@Value("${message}")
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@PostMapping("/hello")
	public String sayHello(@RequestBody String str){
		System.out.println(str);
		System.out.printf("hey"+message);
		return message;
	}
}
