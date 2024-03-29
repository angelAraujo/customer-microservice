package om.test.microservices.gateway;

import org.springframework.aop.TargetSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulGatewayServer {
    public static void main(String[] args){
        SpringApplication.run(ZuulGatewayServer.class, args);
    }
}
