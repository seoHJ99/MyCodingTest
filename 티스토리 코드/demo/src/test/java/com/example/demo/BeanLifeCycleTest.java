package com.example.demo;

import com.example.demo.lifeCycle.AutoConnect;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        AutoConnect client = ac.getBean(AutoConnect.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        //빈 옵션 등록
        @Bean
        public AutoConnect autoConnect(){
            System.out.println("빈 등록함수 호출");
            AutoConnect autoConnect = new AutoConnect();
            System.out.println("객체 생성");
            autoConnect.setFieldA("aaaaaaaaaa");
            System.out.println("필드값 셋팅 완료");
            return autoConnect;
        }
    }
}
