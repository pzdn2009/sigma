package com.l3lab.sigma.eurekacluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * http://blog.csdn.net/tianyaleixiaowu/article/details/78184793
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClusterApplication.class, args);
	}
}
