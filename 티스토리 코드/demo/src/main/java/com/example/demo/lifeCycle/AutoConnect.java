package com.example.demo.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AutoConnect  {
    private String fieldA;

    public AutoConnect() {
        System.out.println("AutoConnect 객체 생성됨");

    }

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect:" + fieldA);
    }

    public void call(String message){
        System.out.println("CallField:" + fieldA +", message :" + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close:" + fieldA);
    }


    @PostConstruct
    public void init(){
        connect();
    }

    @PreDestroy
    public void close(){
        disconnect();
    }

}
