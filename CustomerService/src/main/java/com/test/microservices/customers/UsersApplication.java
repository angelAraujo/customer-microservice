
package com.test.microservices.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Angel
 * @since 1.0.0
 */

@SpringBootApplication
public class UsersApplication {


    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
   
}
