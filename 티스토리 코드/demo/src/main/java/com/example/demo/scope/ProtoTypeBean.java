package com.example.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
@Component
public class ProtoTypeBean {

    @PostConstruct
    public void open() {
        System.out.println("Prototype 빈, 메모리 주소값:" + this);
    }

}
