package com.example.demo.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingletonBean {
    private final ObjectProvider<ProtoTypeBean> protoTypeBeanProvider;

    public void test(){
        ProtoTypeBean object = protoTypeBeanProvider.getObject();
    }
}
