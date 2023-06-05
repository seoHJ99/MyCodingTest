package com.example.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestLog {
    private String uuid;
    private String requestURL;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log( String message){
        System.out.println("uuid = " + uuid +"////" + "requestURL = " +requestURL + " ////// " + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("uuid = " + uuid +" 호출된 객체 : " + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("uuid = " + uuid +" 소멸하는 객체 : " + this);
    }
}
