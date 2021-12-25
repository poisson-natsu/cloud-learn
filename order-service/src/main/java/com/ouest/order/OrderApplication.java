package com.ouest.order;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
import com.ouest.order.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.ouest.order.mapper")
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class)
//@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    // 注入
    @Bean
    // 负载均衡
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }
}
